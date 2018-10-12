package com.huhupa.basicdata.controller;

import com.huhupa.base.controller.BaseController;
import com.huhupa.basicdata.entity.Clerk;
import com.huhupa.basicdata.entity.IncomeCategory;
import com.huhupa.basicdata.service.ClerkService;
import com.huhupa.basicdata.service.IncomeCategoryService;
import com.huhupa.common.ResultObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/api/incomeCategory")
public class IncomeCategoryController extends BaseController {

	@Autowired
	private IncomeCategoryService incomeCategoryService;

	@RequestMapping(value = { "/add" }, method = RequestMethod.POST)
	@ResponseBody
	public ResultObject add(@RequestBody IncomeCategory incomeCategory) {
		return new ResultObject(incomeCategoryService.save(incomeCategory));
	}

	@RequestMapping(value = { "/edit" }, method = RequestMethod.PUT)
	@ResponseBody
	public ResultObject edit(@RequestBody IncomeCategory incomeCategory) {
		IncomeCategory update = incomeCategoryService.update(incomeCategory);
		return new ResultObject(update);
	}

	@RequestMapping(value = { "/getById/{id}" }, method = RequestMethod.GET)
	@ResponseBody
	public ResultObject getById(@PathVariable Integer id) {
		IncomeCategory incomeCategory = incomeCategoryService.findActiveById(id);
		return new ResultObject(incomeCategory);
	}

	@RequestMapping(value = { "/delete/{id}" }, method = RequestMethod.DELETE)
	@ResponseBody
	public ResultObject delete(@PathVariable Integer id) {
		incomeCategoryService.deleteLogicById(id);
		return new ResultObject();
	}

	@RequestMapping(value = { "/getAll" }, method = RequestMethod.GET)
	@ResponseBody
	public ResultObject getAll() {
		List<IncomeCategory> all = incomeCategoryService.findAllActive();
		return new ResultObject(all);
	}
}
