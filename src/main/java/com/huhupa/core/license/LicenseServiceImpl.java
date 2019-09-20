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
	
	private License erpLicense;
	
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
	public boolean validateErpLicense() throws Exception {
		License erpLicense2 = getErpLicense();
		if (null == erpLicense2) {
			SystemLicense existLicense = getExistLicense("ERP");
			if (null != existLicense) {
				erpLicense2 = decodeLicense(existLicense.getLicense());
				setErpLicense(erpLicense2);
			} else {
				return false;
			}
		}
		return !isExpire(erpLicense2);
	}
	
	
	/**
	 * 
	 * 返回 false 代表无效
	 * 
	 * return true 有效
	 */
	@Override
	public boolean checkLicense(String licenseCode) throws Exception {
		License decodeLicense = decodeLicense(licenseCode);
		if (!isExpire(decodeLicense)) {
			return true;
		}
		return false;
	}
	
	/**
	 * 过期了 返回true，没过期 返回false
	 * @param license
	 * @return true 过期 
	 */
	@Override
	public boolean isExpire(License license) {
		if (null != license) {
			Date expiry = license.getExpiry();
			Date now = new Date();
			if (expiry.after(now)) {
				System.out.println("未过期expiry： " + expiry);
				System.out.println("未过期 ");
				return false;
			}
		}
		return true;
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
	
	public License getErpLicense() {
		return erpLicense;
	}
	
	public void setErpLicense(License erpLicense) {
		this.erpLicense = erpLicense;
	}

}
