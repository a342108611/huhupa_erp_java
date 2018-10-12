package com.huhupa.basicdata.controller;

import com.huhupa.base.controller.BaseController;
import com.huhupa.base.core.shiro.session.ShiroSessionRepository;
import com.huhupa.base.core.token.manager.TokenManager;
import com.huhupa.base.entity.User;
import com.huhupa.basicdata.entity.BasicMaterial;
import com.huhupa.basicdata.service.BasicMaterialService;
import com.huhupa.common.ResultObject;
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
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/api/basicMaterial")
public class BasicMaterialController extends BaseController {

	@Autowired
	private BasicMaterialService basicMaterialService;

	@RequestMapping(value = { "/add" }, method = RequestMethod.POST)
	@ResponseBody
	public ResultObject add(BasicMaterial basicMaterial) {
		return new ResultObject(basicMaterialService.save(basicMaterial));
	}

	@RequestMapping(value = { "/edit" }, method = RequestMethod.PUT)
	@ResponseBody
	public ResultObject edit(BasicMaterial basicMaterial) {
		BasicMaterial update = basicMaterialService.update(basicMaterial);
		return new ResultObject(update);
	}

	@RequestMapping(value = { "/getById" }, method = RequestMethod.GET)
	@ResponseBody
	public ResultObject getById(Integer id) {
		BasicMaterial basicMaterial = basicMaterialService.findActiveById(id);
		return new ResultObject(basicMaterial);
	}

	@RequestMapping(value = { "/delete" }, method = RequestMethod.DELETE)
	@ResponseBody
	public ResultObject delete(Integer id) {
		basicMaterialService.deleteLogicById(id);
		return new ResultObject();
	}

	@RequestMapping(value = { "/getAll" }, method = RequestMethod.GET)
	@ResponseBody
	public ResultObject getAll() {
		List<BasicMaterial> all = basicMaterialService.findAllActive();
		return new ResultObject(all);
	}
}
