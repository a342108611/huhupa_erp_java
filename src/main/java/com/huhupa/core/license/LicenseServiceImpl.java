package com.huhupa.core.license;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.criterion.Example;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSON;
import com.huhupa.entity.SystemLicense;
import com.huhupa.repository.SystemLicenseRepository;
import com.huhupa.util.StringUtil;

import io.jsonwebtoken.Claims;

@Component("licenseService")
public class LicenseServiceImpl implements LicenseService {
	
	@Resource
	private JwtHelper jwtHelper;
	
	@Resource
	private SystemLicenseRepository systemLicenseRepository;

	@Override
	public String generateKey(String productName, String version, String type, Integer days,
			String macAddress, List module, Integer userCountLimit) throws Exception {
		// TODO Auto-generated method stub
		License license = new License();
		license.setProductName(productName);
		license.setVersion(version);
		license.setType(type);
		license.setMacAddress(macAddress);
		license.setModule(module);
		license.setUserCountLimit(userCountLimit);
		license.setExpiry(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 24 * days));
		return jwtHelper.generateToken(license);
	}

	@Override
	public synchronized void sign(License license) throws Exception {
		// 签名

	}

	@Override
	public boolean validate(License license) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}
	
	@Override
	public boolean checkLicense(String licenseCode) throws Exception {
		License decodeLicense = decodeLicense(licenseCode);
		System.out.println("decodeLicense:"+decodeLicense);
		return false;
	}
	
	private License decodeLicense(String token) {
		Claims claims = jwtHelper.parseToken(token);
		Object object = claims.get("license");
		License parseObject = JSON.parseObject(object.toString(), License.class);
		return parseObject;
	}

	@Override
	public SystemLicense getExistLicense(String productName) {
		List<SystemLicense> list = systemLicenseRepository.findByProductName(productName);
		return list.isEmpty()? null: list.get(0);
	}

	@Override
	public void registerLicense(String licenseString) {
		if (StringUtil.isEmpty(licenseString)) {
			throw new RuntimeException("授权码不能为空");
		}
		License license = decodeLicense(licenseString);
		if (null == license) {
			throw new RuntimeException("无效的授权码");
		}
		SystemLicense existLicense = getExistLicense(license.getType());
		if (existLicense == null) {
			SystemLicense systemLicense = new SystemLicense();
			systemLicense.setLicense(licenseString);
			systemLicense.setProductName(license.getProductName());
			systemLicenseRepository.save(systemLicense);
		} else {
			existLicense.setLicense(licenseString);
			systemLicenseRepository.saveAndFlush(existLicense);
		}
		
	}

}
