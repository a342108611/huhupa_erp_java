package com.huhupa.basicdata.controller;

import com.huhupa.base.controller.BaseController;
import com.huhupa.basicdata.entity.Company;
import com.huhupa.basicdata.entity.CompanyAccount;
import com.huhupa.basicdata.service.CompanyAccountService;
import com.huhupa.basicdata.service.CompanyService;
import com.huhupa.common.ResultObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/api/companyAccount")
public class CompanyAccountController extends BaseController {

	@Autowired
	private CompanyAccountService companyAccountService;

	@RequestMapping(value = { "/add" }, method = RequestMethod.POST)
	@ResponseBody
	public ResultObject add(CompanyAccount companyAccount) {
		companyAccountService.save(companyAccount);
		return new ResultObject();
	}

	@RequestMapping(value = { "/edit" }, method = RequestMethod.PUT)
	@ResponseBody
	public ResultObject edit(CompanyAccount companyAccount) {
		CompanyAccount update = companyAccountService.update(companyAccount);
		return new ResultObject(update);
	}

	@RequestMapping(value = { "/getById" }, method = RequestMethod.GET)
	@ResponseBody
	public ResultObject getById(String id) {
		CompanyAccount companyAccount = companyAccountService.findActiveById(id);
		return new ResultObject(companyAccount);
	}

	@RequestMapping(value = { "/delete" }, method = RequestMethod.DELETE)
	@ResponseBody
	public ResultObject delete(String id) {
		companyAccountService.deleteLogicById(id);
		return new ResultObject();
	}

	@RequestMapping(value = { "/getAll" }, method = RequestMethod.GET)
	@ResponseBody
	public ResultObject getAll() {
		List<CompanyAccount> all = companyAccountService.findAllActive();
		return new ResultObject(all);
	}
}
