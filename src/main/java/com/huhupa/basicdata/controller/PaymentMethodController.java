package com.huhupa.basicdata.controller;

import com.huhupa.base.controller.BaseController;
import com.huhupa.basicdata.entity.Clerk;
import com.huhupa.basicdata.entity.PaymentMethod;
import com.huhupa.basicdata.service.ClerkService;
import com.huhupa.basicdata.service.PaymentMethodService;
import com.huhupa.common.ResultObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/api/paymentMethod")
public class PaymentMethodController extends BaseController {

	@Autowired
	private PaymentMethodService paymentMethodService;

	@RequestMapping(value = { "/add" }, method = RequestMethod.POST)
	@ResponseBody
	public ResultObject add(@RequestBody PaymentMethod paymentMethod) {
		return new ResultObject(paymentMethodService.save(paymentMethod));
	}

	@RequestMapping(value = { "/edit" }, method = RequestMethod.PUT)
	@ResponseBody
	public ResultObject edit(@RequestBody PaymentMethod paymentMethod) {
		PaymentMethod update = paymentMethodService.update(paymentMethod);
		return new ResultObject(update);
	}

	@RequestMapping(value = { "/getById/{id}" }, method = RequestMethod.GET)
	@ResponseBody
	public ResultObject getById(@PathVariable Integer id) {
		PaymentMethod paymentMethod = paymentMethodService.findActiveById(id);
		return new ResultObject(paymentMethod);
	}

	@RequestMapping(value = { "/delete/{id}" }, method = RequestMethod.DELETE)
	@ResponseBody
	public ResultObject delete(@PathVariable Integer id) {
		paymentMethodService.deleteLogicById(id);
		return new ResultObject();
	}

	@RequestMapping(value = { "/getAll" }, method = RequestMethod.GET)
	@ResponseBody
	public ResultObject getAll() {
		List<PaymentMethod> all = paymentMethodService.findAllActive();
		return new ResultObject(all);
	}
}
