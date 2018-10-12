package com.huhupa.basicdata.controller;

import com.huhupa.base.controller.BaseController;
import com.huhupa.basicdata.entity.Product;
import com.huhupa.basicdata.entity.ProductionType;
import com.huhupa.basicdata.service.ProductService;
import com.huhupa.basicdata.service.ProductionTypeService;
import com.huhupa.common.ResultObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/api/productionType")
public class ProductionTypeController extends BaseController {

	@Autowired
	private ProductionTypeService productionTypeService;

	@RequestMapping(value = { "/add" }, method = RequestMethod.POST)
	@ResponseBody
	public ResultObject add(ProductionType productionType) {
		return new ResultObject(productionTypeService.save(productionType));
	}

	@RequestMapping(value = { "/edit" }, method = RequestMethod.PUT)
	@ResponseBody
	public ResultObject edit(ProductionType productionType) {
		ProductionType update = productionTypeService.update(productionType);
		return new ResultObject(update);
	}

	@RequestMapping(value = { "/getById" }, method = RequestMethod.GET)
	@ResponseBody
	public ResultObject getById(Integer id) {
		ProductionType productionType = productionTypeService.findActiveById(id);
		return new ResultObject(productionType);
	}

	@RequestMapping(value = { "/delete" }, method = RequestMethod.DELETE)
	@ResponseBody
	public ResultObject delete(Integer id) {
		productionTypeService.deleteLogicById(id);
		return new ResultObject();
	}

	@RequestMapping(value = { "/getAll" }, method = RequestMethod.GET)
	@ResponseBody
	public ResultObject getAll() {
		List<ProductionType> all = productionTypeService.findAllActive();
		return new ResultObject(all);
	}
}
