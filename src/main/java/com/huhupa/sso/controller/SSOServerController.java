package com.huhupa.sso.controller;

import com.huhupa.base.controller.BaseController;
import com.huhupa.common.ResultObject;
import com.huhupa.sso.entity.AccessToken;
import com.huhupa.sso.entity.App;
import com.huhupa.sso.service.AccessTokenService;
import com.huhupa.sso.service.AppService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/sso")
public class SSOServerController extends BaseController{

    @Autowired
    private AppService appService;

    public static final String SSO_LOGIN = "sso/login";
    public static final String SSO_ADMIN_INDEX = "sso/index";

    @Autowired
    private AccessTokenService accessTokenService;
    /**
     *
     * @param appId 应用id
     * @param secret 应用秘钥
     * @param expire 有效时间 默认30分钟
     * @return
     */
    @RequestMapping("/getAccessToken")
    @ResponseBody
    public ResultObject getAccessToken(HttpSession session,String appId, String secret, Integer expire) {
        AccessToken accessToken = accessTokenService.getAccessToken(session, appId, secret);
        return new ResultObject(accessToken);
    }

    @RequestMapping("/addApp")
    @ResponseBody
    public ResultObject addApp(App app) {
        App app1 = appService.saveOrUpdate(app);
        return new ResultObject(app1);
    }

    @RequestMapping("/checkLogin")
    public String checkLogin(String appId, String secret,String redirectUrl, HttpSession session, Model model) {
        AccessToken accessToken = (AccessToken)session.getAttribute("accessToken");
        System.out.println("token:" + accessToken);
        if (null == accessToken) {
            // 没有全局会话
            model.addAttribute("redirectUrl", redirectUrl);
            model.addAttribute("appId", appId);
            model.addAttribute("secret", secret);
            return SSO_LOGIN;
        }
        if (StringUtils.isEmpty(redirectUrl)) {
            return SSO_ADMIN_INDEX;
        }
        return "redirect:" + redirectUrl + "?accessToken=" + accessToken.getAccessToken();
    }

    @RequestMapping(value = {"/toLogin"}, method = RequestMethod.POST)
    public String login(String username,String password, String redirectUrl,
                        HttpSession session, Model model, String appId, String secret){
        try {
            Subject subject = SecurityUtils.getSubject();
            UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken(username, password);
            subject.login(usernamePasswordToken);
            AccessToken accessToken = accessTokenService.getAccessToken(session, appId, secret);
            if (StringUtils.isEmpty(redirectUrl))
                return SSO_ADMIN_INDEX;
            return redirect(redirectUrl + "?accessToken=" + accessToken.getAccessToken());
        } catch (AuthenticationException e) {
            e.printStackTrace();
            model.addAttribute("message", e.getMessage());
        }
        model.addAttribute("appId", appId);
        model.addAttribute("secret", secret);
        model.addAttribute("redirectUrl", redirectUrl);
        return SSO_LOGIN;
    }

    @RequestMapping("/verify")
    @ResponseBody
    public ResultObject verifyToken(String accessToken){
        AccessToken token = accessTokenService.getAccessToken(accessToken);
        System.out.println("验证token:" + token);
        return new ResultObject(token);
    }
}
