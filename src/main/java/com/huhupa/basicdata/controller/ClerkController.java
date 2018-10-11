package com.huhupa.basicdata.controller;

import com.huhupa.base.controller.BaseController;
import com.huhupa.basicdata.entity.BasicMaterial;
import com.huhupa.basicdata.entity.Clerk;
import com.huhupa.basicdata.service.BasicMaterialService;
import com.huhupa.basicdata.service.ClerkService;
import com.huhupa.common.ResultObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/api/clerk")
public class ClerkController extends BaseController {

	@Autowired
	private ClerkService clerkService;

	@RequestMapping(value = { "/add" }, method = RequestMethod.POST)
	@ResponseBody
	public ResultObject add(Clerk clerk) {
		clerkService.save(clerk);
		return new ResultObject();
	}

	@RequestMapping(value = { "/edit" }, method = RequestMethod.PUT)
	@ResponseBody
	public ResultObject edit(Clerk clerk) {
		Clerk update = clerkService.update(clerk);
		return new ResultObject(update);
	}

	@RequestMapping(value = { "/getById" }, method = RequestMethod.GET)
	@ResponseBody
	public ResultObject getById(Integer id) {
		Clerk clerk = clerkService.find(id);
		return new ResultObject(clerk);
	}

	@RequestMapping(value = { "/delete" }, method = RequestMethod.DELETE)
	@ResponseBody
	public ResultObject delete(Integer id) {
		clerkService.delete(id);
		return new ResultObject();
	}

	@RequestMapping(value = { "/getAll" }, method = RequestMethod.GET)
	@ResponseBody
	public ResultObject getAll() {
		List<Clerk> all = clerkService.findAll();
		return new ResultObject(all);
	}
}
