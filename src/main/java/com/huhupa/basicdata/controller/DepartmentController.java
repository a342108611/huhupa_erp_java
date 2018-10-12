package com.huhupa.basicdata.controller;

import com.huhupa.base.controller.BaseController;
import com.huhupa.basicdata.entity.Clerk;
import com.huhupa.basicdata.entity.Department;
import com.huhupa.basicdata.service.ClerkService;
import com.huhupa.basicdata.service.DepartmentService;
import com.huhupa.common.ResultObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/api/department")
public class DepartmentController extends BaseController {

	@Autowired
	private DepartmentService departmentService;

	@RequestMapping(value = { "/add" }, method = RequestMethod.POST)
	@ResponseBody
	public ResultObject add(@RequestBody Department department) {
		return new ResultObject(departmentService.save(department));
	}

	@RequestMapping(value = { "/edit" }, method = RequestMethod.PUT)
	@ResponseBody
	public ResultObject edit(@RequestBody Department department) {
		Department update = departmentService.update(department);
		return new ResultObject(update);
	}

	@RequestMapping(value = { "/getById/{id}" }, method = RequestMethod.GET)
	@ResponseBody
	public ResultObject getById(@PathVariable Integer id) {
		Department department = departmentService.findActiveById(id);
		return new ResultObject(department);
	}

	@RequestMapping(value = { "/delete/{id}" }, method = RequestMethod.DELETE)
	@ResponseBody
	public ResultObject delete(@PathVariable Integer id) {
		departmentService.deleteLogicById(id);
		return new ResultObject();
	}

	@RequestMapping(value = { "/getAll" }, method = RequestMethod.GET)
	@ResponseBody
	public ResultObject getAll() {
		List<Department> all = departmentService.findAllActive();
		return new ResultObject(all);
	}
}
