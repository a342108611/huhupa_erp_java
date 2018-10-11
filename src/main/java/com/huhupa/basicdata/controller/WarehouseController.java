package com.huhupa.basicdata.controller;

import com.huhupa.base.controller.BaseController;
import com.huhupa.basicdata.entity.Clerk;
import com.huhupa.basicdata.entity.Warehouse;
import com.huhupa.basicdata.service.ClerkService;
import com.huhupa.basicdata.service.WarehouseService;
import com.huhupa.common.ResultObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/api/warehouse")
public class WarehouseController extends BaseController {

	@Autowired
	private WarehouseService warehouseService;

	@RequestMapping(value = { "/add" }, method = RequestMethod.POST)
	@ResponseBody
	public ResultObject add(Warehouse warehouse) {
		warehouseService.save(warehouse);
		return new ResultObject();
	}

	@RequestMapping(value = { "/edit" }, method = RequestMethod.PUT)
	@ResponseBody
	public ResultObject edit(Warehouse warehouse) {
		Warehouse update = warehouseService.update(warehouse);
		return new ResultObject(update);
	}

	@RequestMapping(value = { "/getById" }, method = RequestMethod.GET)
	@ResponseBody
	public ResultObject getById(Integer id) {
		Warehouse warehouse = warehouseService.find(id);
		return new ResultObject(warehouse);
	}

	@RequestMapping(value = { "/delete" }, method = RequestMethod.DELETE)
	@ResponseBody
	public ResultObject delete(Integer id) {
		warehouseService.delete(id);
		return new ResultObject();
	}

	@RequestMapping(value = { "/getAll" }, method = RequestMethod.GET)
	@ResponseBody
	public ResultObject getAll() {
		List<Warehouse> all = warehouseService.findAll();
		return new ResultObject(all);
	}
}
