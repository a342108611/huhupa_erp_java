package com.huhupa.basicdata.controller;

import com.huhupa.base.controller.BaseController;
import com.huhupa.basicdata.entity.Clerk;
import com.huhupa.basicdata.entity.IncomeCategory;
import com.huhupa.basicdata.service.ClerkService;
import com.huhupa.basicdata.service.IncomeCategoryService;
import com.huhupa.common.ResultObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/api/incomeCategory")
public class IncomeCategoryController extends BaseController {

	@Autowired
	private IncomeCategoryService incomeCategoryService;

	@RequestMapping(value = { "/add" }, method = RequestMethod.POST)
	@ResponseBody
	public ResultObject add(IncomeCategory incomeCategory) {
		incomeCategoryService.save(incomeCategory);
		return new ResultObject();
	}

	@RequestMapping(value = { "/edit" }, method = RequestMethod.PUT)
	@ResponseBody
	public ResultObject edit(IncomeCategory incomeCategory) {
		IncomeCategory update = incomeCategoryService.update(incomeCategory);
		return new ResultObject(update);
	}

	@RequestMapping(value = { "/getById" }, method = RequestMethod.GET)
	@ResponseBody
	public ResultObject getById(Integer id) {
		IncomeCategory incomeCategory = incomeCategoryService.find(id);
		return new ResultObject(incomeCategory);
	}

	@RequestMapping(value = { "/delete" }, method = RequestMethod.DELETE)
	@ResponseBody
	public ResultObject delete(Integer id) {
		incomeCategoryService.delete(id);
		return new ResultObject();
	}

	@RequestMapping(value = { "/getAll" }, method = RequestMethod.GET)
	@ResponseBody
	public ResultObject getAll() {
		List<IncomeCategory> all = incomeCategoryService.findAll();
		return new ResultObject(all);
	}
}