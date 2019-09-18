package com.huhupa.core.license;

import org.springframework.stereotype.Component;

@Component("licenseService")
public class LicenseServiceImpl implements LicenseService {

	@Override
	public void generateKey() throws Exception {
		// TODO Auto-generated method stub

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
