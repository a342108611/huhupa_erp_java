package com.huhupa.basicdata.controller;

import com.huhupa.base.controller.BaseController;
import com.huhupa.basicdata.entity.Clerk;
import com.huhupa.basicdata.entity.Education;
import com.huhupa.basicdata.service.ClerkService;
import com.huhupa.basicdata.service.EducationService;
import com.huhupa.common.ResultObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/api/education")
public class EducationController extends BaseController {

	@Autowired
	private EducationService educationService;

	@RequestMapping(value = { "/add" }, method = RequestMethod.POST)
	@ResponseBody
	public ResultObject add(@RequestBody Education education) {
		return new ResultObject(educationService.save(education));
	}

	@RequestMapping(value = { "/edit" }, method = RequestMethod.PUT)
	@ResponseBody
	public ResultObject edit(@RequestBody Education education) {
		Education update = educationService.update(education);
		return new ResultObject(update);
	}

	@RequestMapping(value = { "/getById/{id}" }, method = RequestMethod.GET)
	@ResponseBody
	public ResultObject getById(@PathVariable Integer id) {
		Education education = educationService.findActiveById(id);
		return new ResultObject(education);
	}

	@RequestMapping(value = { "/delete/{id}" }, method = RequestMethod.DELETE)
	@ResponseBody
	public ResultObject delete(@PathVariable Integer id) {
		educationService.deleteLogicById(id);
		return new ResultObject();
	}

	@RequestMapping(value = { "/getAll" }, method = RequestMethod.GET)
	@ResponseBody
	public ResultObject getAll() {
		List<Education> all = educationService.findAllActive();
		return new ResultObject(all);
	}
}
