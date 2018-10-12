package com.huhupa.basicdata.controller;

import com.huhupa.base.controller.BaseController;
import com.huhupa.basicdata.entity.Company;
import com.huhupa.basicdata.entity.CompanyCategory;
import com.huhupa.basicdata.service.CompanyCategoryService;
import com.huhupa.basicdata.service.CompanyService;
import com.huhupa.common.ResultObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/api/companyCategory")
public class CompanyCategoryController extends BaseController {

	@Autowired
	private CompanyCategoryService companyCategoryService;

	@RequestMapping(value = { "/add" }, method = RequestMethod.POST)
	@ResponseBody
	public ResultObject add(@RequestBody CompanyCategory companyCategory) {
		return new ResultObject(companyCategoryService.save(companyCategory));
	}

	@RequestMapping(value = { "/edit" }, method = RequestMethod.PUT)
	@ResponseBody
	public ResultObject edit(@RequestBody CompanyCategory companyCategory) {
		CompanyCategory update = companyCategoryService.update(companyCategory);
		return new ResultObject(update);
	}

	@RequestMapping(value = { "/getById" }, method = RequestMethod.GET)
	@ResponseBody
	public ResultObject getById(Integer id) {
		CompanyCategory companyCategory = companyCategoryService.findActiveById(id);
		return new ResultObject(companyCategory);
	}

	@RequestMapping(value = { "/delete" }, method = RequestMethod.DELETE)
	@ResponseBody
	public ResultObject delete(Integer id) {
		companyCategoryService.deleteLogicById(id);
		return new ResultObject();
	}

	@RequestMapping(value = { "/getAll" }, method = RequestMethod.GET)
	@ResponseBody
	public ResultObject getAll() {
		List<CompanyCategory> all = companyCategoryService.findAllActive();
		return new ResultObject(all);
	}
}
