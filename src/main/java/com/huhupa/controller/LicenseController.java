package com.huhupa.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.huhupa.core.license.LicenseService;

/**
 * 授权码
 * @author huhupa 朱勇军
 *
 */
@Controller
public class LicenseController {

	
	@Resource
	private LicenseService licenseService;
 
    @RequestMapping("/api/v1/test")
    @ResponseBody
    public Map<String, Object> test(@RequestBody Map<String, Object> params) {
    	Map<String, Object> resultMap = new HashMap<String, Object>();
    	String productName = params.get("productName").toString();
    	String version = params.get("version").toString();
    	String type = params.get("type").toString();
    	Integer days = Integer.parseInt(params.get("days").toString());
    	String macAddress = params.get("macAddress").toString();
    	List module = (List)params.get("module");
    	Integer userCountLimit = Integer.parseInt(params.get("userCountLimit").toString());
    	try {
    		resultMap.put("status", true);
    		resultMap.put("msg", "ok");
			String generateKey = licenseService.generateKey(productName, version, type, days, macAddress, module, userCountLimit);
			resultMap.put("license", generateKey);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			resultMap.put("status", false);
    		resultMap.put("msg", "error");
		}
    	return resultMap;
    }
    
 
    @RequestMapping("/api/v1/test1")
    @ResponseBody
    public Map<String, Object> test1(@RequestBody Map<String, Object> params) {
    	Map<String, Object> resultMap = new HashMap<String, Object>();
    	String license = params.get("license").toString();
    	try {
    		resultMap.put("status", true);
    		resultMap.put("msg", "ok");
			licenseService.checkLicense(license);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			resultMap.put("status", false);
    		resultMap.put("msg", "error");
		}
    	return resultMap;
    }
    
    @RequestMapping("/api/v1/license/register")
    @ResponseBody
    public Map<String, Object> registerLicense(@RequestBody Map<String, Object> params) {
    	Map<String, Object> resultMap = new HashMap<String, Object>();
    	String license = params.get("license").toString();
    	try {
    		resultMap.put("status", true);
    		resultMap.put("msg", "ok");
			licenseService.registerLicense(license);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			resultMap.put("status", false);
    		resultMap.put("msg", "error");
		}
    	return resultMap;
    }
}
