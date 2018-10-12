package com.huhupa.basicdata.controller;

import com.huhupa.base.controller.BaseController;
import com.huhupa.basicdata.entity.Clerk;
import com.huhupa.basicdata.entity.PaymentMethod;
import com.huhupa.basicdata.service.ClerkService;
import com.huhupa.basicdata.service.PaymentMethodService;
import com.huhupa.common.ResultObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/api/paymentMethod")
public class PaymentMethodController extends BaseController {

	@Autowired
	private PaymentMethodService paymentMethodService;

	@RequestMapping(value = { "/add" }, method = RequestMethod.POST)
	@ResponseBody
	public ResultObject add(PaymentMethod paymentMethod) {
		paymentMethodService.save(paymentMethod);
		return new ResultObject();
	}

	@RequestMapping(value = { "/edit" }, method = RequestMethod.PUT)
	@ResponseBody
	public ResultObject edit(PaymentMethod paymentMethod) {
		PaymentMethod update = paymentMethodService.update(paymentMethod);
		return new ResultObject(update);
	}

	@RequestMapping(value = { "/getById" }, method = RequestMethod.GET)
	@ResponseBody
	public ResultObject getById(Integer id) {
		PaymentMethod paymentMethod = paymentMethodService.findActiveById(id);
		return new ResultObject(paymentMethod);
	}

	@RequestMapping(value = { "/delete" }, method = RequestMethod.DELETE)
	@ResponseBody
	public ResultObject delete(Integer id) {
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
