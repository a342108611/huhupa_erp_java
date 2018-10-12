package com.huhupa.basicdata.controller;

import com.huhupa.base.controller.BaseController;
import com.huhupa.basicdata.entity.Clerk;
import com.huhupa.basicdata.entity.SpendingCategory;
import com.huhupa.basicdata.service.ClerkService;
import com.huhupa.basicdata.service.SpendingCategoryService;
import com.huhupa.common.ResultObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/api/spendingCategory")
public class SpendingCategoryController extends BaseController {

	@Autowired
	private SpendingCategoryService spendingCategoryService;

	@RequestMapping(value = { "/add" }, method = RequestMethod.POST)
	@ResponseBody
	public ResultObject add(@RequestBody SpendingCategory spendingCategory) {
		return new ResultObject(spendingCategoryService.save(spendingCategory));
	}

	@RequestMapping(value = { "/edit" }, method = RequestMethod.PUT)
	@ResponseBody
	public ResultObject edit(@RequestBody SpendingCategory spendingCategory) {
		SpendingCategory update = spendingCategoryService.update(spendingCategory);
		return new ResultObject(update);
	}

	@RequestMapping(value = { "/getById/{id}" }, method = RequestMethod.GET)
	@ResponseBody
	public ResultObject getById(@PathVariable Integer id) {
		SpendingCategory spendingCategory = spendingCategoryService.findActiveById(id);
		return new ResultObject(spendingCategory);
	}

	@RequestMapping(value = { "/delete/{id}" }, method = RequestMethod.DELETE)
	@ResponseBody
	public ResultObject delete(@PathVariable Integer id) {
		spendingCategoryService.deleteLogicById(id);
		return new ResultObject();
	}

	@RequestMapping(value = { "/getAll" }, method = RequestMethod.GET)
	@ResponseBody
	public ResultObject getAll() {
		List<SpendingCategory> all = spendingCategoryService.findAllActive();
		return new ResultObject(all);
	}
}
