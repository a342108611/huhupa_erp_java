package com.huhupa.basicdata.controller;

import com.huhupa.base.controller.BaseController;
import com.huhupa.basicdata.entity.Clerk;
import com.huhupa.basicdata.entity.ProductCategory;
import com.huhupa.basicdata.service.ClerkService;
import com.huhupa.basicdata.service.ProductCategoryService;
import com.huhupa.common.ResultObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/api/productCategory")
public class ProductCategoryController extends BaseController {

	@Autowired
	private ProductCategoryService productCategoryService;

	@RequestMapping(value = { "/add" }, method = RequestMethod.POST)
	@ResponseBody
	public ResultObject add(ProductCategory productCategory) {
		return new ResultObject(productCategoryService.save(productCategory));
	}

	@RequestMapping(value = { "/edit" }, method = RequestMethod.PUT)
	@ResponseBody
	public ResultObject edit(ProductCategory productCategory) {
		ProductCategory update = productCategoryService.update(productCategory);
		return new ResultObject(update);
	}

	@RequestMapping(value = { "/getById" }, method = RequestMethod.GET)
	@ResponseBody
	public ResultObject getById(Integer id) {
		ProductCategory productCategory = productCategoryService.findActiveById(id);
		return new ResultObject(productCategory);
	}

	@RequestMapping(value = { "/delete" }, method = RequestMethod.DELETE)
	@ResponseBody
	public ResultObject delete(Integer id) {
		productCategoryService.deleteLogicById(id);
		return new ResultObject();
	}

	@RequestMapping(value = { "/getAll" }, method = RequestMethod.GET)
	@ResponseBody
	public ResultObject getAll() {
		List<ProductCategory> all = productCategoryService.findAllActive();
		return new ResultObject(all);
	}
}
