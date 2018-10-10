package com.huhupa.base.controller.admin;

import com.huhupa.base.controller.BaseController;
import com.huhupa.base.core.shiro.session.ShiroSessionRepository;
import com.huhupa.base.core.token.manager.TokenManager;
import com.huhupa.base.entity.User;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController extends BaseController {

	@Autowired
	private ShiroSessionRepository shiroSessionRepository;

	@RequestMapping(value = { "/admin/login" }, method = RequestMethod.GET)
	public String login(ModelMap map) {
		User token = TokenManager.getToken(true);
		map.put("token", token);
		return "admin/login";
	}

	/**
	 * 此接口为前后端结合使用的，前后端分离的请使用 sessionController里面的登陆接口
	 * @param username
	 * @param password
	 * @param model
	 * @return
	 */
	@RequestMapping(value = { "/admin/login" }, method = RequestMethod.POST)
	public String login(@RequestParam("username") String username,
			@RequestParam("password") String password,ModelMap model
			) {
		try {
			 Subject subject = SecurityUtils.getSubject();
			 UsernamePasswordToken token = new UsernamePasswordToken(username, password);
			 subject.login(token);
			return redirect("/admin/index");
		} catch (AuthenticationException e) {
			model.put("message", e.getMessage());
		}
		return "admin/login";
	}
	
	@RequestMapping(value = { "/admin/logout" }, method = RequestMethod.GET)
	public String logout() {
		Subject subject = SecurityUtils.getSubject();
		subject.logout();
		return redirect("admin/login");
	}

}
