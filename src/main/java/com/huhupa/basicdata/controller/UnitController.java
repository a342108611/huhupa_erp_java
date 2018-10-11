package com.huhupa.basicdata.controller;

import com.huhupa.base.controller.BaseController;
import com.huhupa.basicdata.entity.Clerk;
import com.huhupa.basicdata.entity.Unit;
import com.huhupa.basicdata.service.ClerkService;
import com.huhupa.basicdata.service.UnitService;
import com.huhupa.common.ResultObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/api/unit")
public class UnitController extends BaseController {

	@Autowired
	private UnitService unitService;

	@RequestMapping(value = { "/add" }, method = RequestMethod.POST)
	@ResponseBody
	public ResultObject add(Unit unit) {
		unitService.save(unit);
		return new ResultObject();
	}

	@RequestMapping(value = { "/edit" }, method = RequestMethod.PUT)
	@ResponseBody
	public ResultObject edit(Unit unit) {
		Unit update = unitService.update(unit);
		return new ResultObject(update);
	}

	@RequestMapping(value = { "/getById" }, method = RequestMethod.GET)
	@ResponseBody
	public ResultObject getById(Integer id) {
		Unit unit = unitService.find(id);
		return new ResultObject(unit);
	}

	@RequestMapping(value = { "/delete" }, method = RequestMethod.DELETE)
	@ResponseBody
	public ResultObject delete(Integer id) {
		unitService.delete(id);
		return new ResultObject();
	}

	@RequestMapping(value = { "/getAll" }, method = RequestMethod.GET)
	@ResponseBody
	public ResultObject getAll() {
		List<Unit> all = unitService.findAll();
		return new ResultObject(all);
	}
}
