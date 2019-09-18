package com.huhupa.core.license;

import java.util.Date;

import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSON;

@Component("licenseService")
public class LicenseServiceImpl implements LicenseService {

	@Override
	public void generateKey() throws Exception {
		// TODO Auto-generated method stub
		License license = new License();
		license.setExpiry(new Date(System.currentTimeMillis() + 60 * 60 * 24 * 1000));
		license.setMacAddress("FE-FC-FE-F7-DB-65");
		license.setModule(null);
		license.setProductName("huhupa erp");
		license.setSignature(null);
		license.setType("trial");
		license.setUserCountLimit(10);
		license.setVersion("1.0");
		
	}

	@Override
	public synchronized void sign(License license) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean validate(License license) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

}
