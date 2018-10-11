package com.huhupa.basicdata.controller;

import com.huhupa.base.controller.BaseController;
import com.huhupa.basicdata.entity.Clerk;
import com.huhupa.basicdata.entity.DeliveryAddress;
import com.huhupa.basicdata.service.ClerkService;
import com.huhupa.basicdata.service.DeliveryAddressService;
import com.huhupa.common.ResultObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/api/deliveryAddress")
public class DeliveryAddressController extends BaseController {

	@Autowired
	private DeliveryAddressService deliveryAddressService;

	@RequestMapping(value = { "/add" }, method = RequestMethod.POST)
	@ResponseBody
	public ResultObject add(DeliveryAddress deliveryAddress) {
		deliveryAddressService.save(deliveryAddress);
		return new ResultObject();
	}

	@RequestMapping(value = { "/edit" }, method = RequestMethod.PUT)
	@ResponseBody
	public ResultObject edit(DeliveryAddress deliveryAddress) {
		DeliveryAddress update = deliveryAddressService.update(deliveryAddress);
		return new ResultObject(update);
	}

	@RequestMapping(value = { "/getById" }, method = RequestMethod.GET)
	@ResponseBody
	public ResultObject getById(Integer id) {
		DeliveryAddress deliveryAddress = deliveryAddressService.find(id);
		return new ResultObject(deliveryAddress);
	}

	@RequestMapping(value = { "/delete" }, method = RequestMethod.DELETE)
	@ResponseBody
	public ResultObject delete(Integer id) {
		deliveryAddressService.delete(id);
		return new ResultObject();
	}

	@RequestMapping(value = { "/getAll" }, method = RequestMethod.GET)
	@ResponseBody
	public ResultObject getAll() {
		List<DeliveryAddress> all = deliveryAddressService.findAll();
		return new ResultObject(all);
	}
}
