package com.huhupa.basicdata.controller;

import com.huhupa.base.controller.BaseController;
import com.huhupa.basicdata.entity.Clerk;
import com.huhupa.basicdata.entity.Company;
import com.huhupa.basicdata.entity.CompanyCategory;
import com.huhupa.basicdata.entity.PaymentMethod;
import com.huhupa.basicdata.service.ClerkService;
import com.huhupa.basicdata.service.CompanyService;
import com.huhupa.common.ResultObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.persistence.ManyToOne;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/api/company")
public class CompanyController extends BaseController {

	@Autowired
	private CompanyService companyService;

	@RequestMapping("/add")
	@ResponseBody
	public ResultObject add(@RequestBody Map<String, Object> map) {
		Company save = companyService.save(parameterTransformation(map), (Integer) map.get("companyCategoryId"),
				(Integer) map.get("paymentMethodId"));
		return new ResultObject(save);
	}

	private Company parameterTransformation(Map<String, Object> map) {
		Company company = new Company();
		company.setId((String) map.get("id"));
		company.setName((String) map.get("name"));
		company.setShortName((String) map.get("shortName"));
		company.setContact((String) map.get("contact"));
		company.setPhone((String) map.get("phone"));
		company.setEmail((String) map.get("email"));
		company.setAddress((String) map.get("address"));
		company.setNote((String) map.get("note"));
		company.setType((Integer) map.get("type"));
		return company;
	}

	@RequestMapping(value = { "/edit" }, method = RequestMethod.PUT)
	@ResponseBody
	public ResultObject edit(@RequestBody Company company) {
		Company update = companyService.update(company);
		return new ResultObject(update);
	}

	@RequestMapping(value = { "/getById" }, method = RequestMethod.GET)
	@ResponseBody
	public ResultObject getById(String id) {
		Company company = companyService.findByUUID(id);
		return new ResultObject(company);
	}

	@RequestMapping(value = { "/delete" }, method = RequestMethod.DELETE)
	@ResponseBody
	public ResultObject delete(@RequestBody String id) {
		companyService.deleteLogicByUUID(id);
		return new ResultObject();
	}

	@RequestMapping(value = { "/getAll" }, method = RequestMethod.GET)
	@ResponseBody
	public ResultObject getAll() {
		List<Company> all = companyService.findAllActive();
		return new ResultObject(all);
	}
}
