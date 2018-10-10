package com.huhupa.base.controller.user;

import com.huhupa.base.controller.BaseController;
import com.huhupa.base.core.shiro.session.CustomSessionManager;
import com.huhupa.base.core.token.manager.TokenManager;
import com.huhupa.base.entity.User;
import com.huhupa.base.entity.bo.UserOnlineBo;
import com.huhupa.common.ResultObject;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

//import com.huhupa.base.core.shiro.session.CustomSessionManager;

/**
 * 用户会员管理
 *
 */
@Controller
@Scope(value="prototype")
@RequestMapping("/api/session")
public class SessionController extends BaseController {
	/***
	 * 用户手动操作Session
	 * */
	@Autowired
	private CustomSessionManager customSessionManager;
//	@Autowired
//	UUserService userService;
	
	/**
	 * 在线用户管理
	 * @return
	 */
	@RequestMapping(value="getOnlineUser")
	@ResponseBody
	public Map<String, Object> online(){
		List<UserOnlineBo> list = customSessionManager.getAllUser();
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("total", list.size());
		map.put("rows", list);
		return map;
	}
	@RequestMapping(value="online")
	public ModelAndView onlinepage(){
		return new ModelAndView("pages/system/member/onlineuser");
	}
	/**
	 * 在线用户详情
	 * @return
	 */
	@RequestMapping(value="onlineDetails/{sessionId}",method=RequestMethod.GET)
	public ModelAndView onlineDetails(@PathVariable("sessionId")String sessionId){
//		UserOnlineBo bo = customSessionManager.getSession(sessionId);
//		return new ModelAndView("member/onlineDetails","bo",bo);
		return null;
	}
	/**
	 * 改变Session状态
	 * @param status
	 * @param sessionIds
	 * @return
	 */
	@RequestMapping(value="changeSessionStatus",method=RequestMethod.POST)
	@ResponseBody
	public Map<String,Object> changeSessionStatus(Boolean status,String sessionIds){
//		return customSessionManager.changeSessionStatus(status,sessionIds);
		return null;
	}

	@RequestMapping(value="getCurrentUser",method=RequestMethod.GET)
	@ResponseBody
	public ResultObject getCurrentUser(Boolean isSimple){
		if (null == isSimple) {
			isSimple = true;
		}
		User token = TokenManager.getToken(isSimple);
		System.out.println("当前用户:" + token);
		return new ResultObject(token);
	}

	@RequestMapping(value = { "/login" }, method = RequestMethod.POST)
	@ResponseBody
	public ResultObject apiLogin(@RequestParam("username") String username,
								 @RequestParam("password") String password, ModelMap model
	) {
		try {
			Subject subject = SecurityUtils.getSubject();
			UsernamePasswordToken token = new UsernamePasswordToken(username, password);
			subject.login(token);
			return new ResultObject(TokenManager.getCurrentUser());
		} catch (AuthenticationException e) {
			throw new RuntimeException("认证失败");
		}
	}
}
