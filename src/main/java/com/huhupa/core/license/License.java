package com.huhupa.core.license;

import java.util.Date;
import java.util.List;


public class License {

	private String productName;  // 产品名称 
	private String version; // 授权码版本
	private String type;  // 授权码类型 : 试用 ：try 购买：buy
	private Date expiry;  // 到期时间
	private String macAddress; // 电脑mac地址
	private String signature; // 签名
	private List module;  // 被授权模块
	private Integer userCountLimit; // 用户数限制
	private String stringLicense; // 授权码串
	
	@Override
	public String toString() {
		return "License [productName=" + productName + ", version=" + version + ", type=" + type + ", expiry=" + expiry
				+ ", macAddress=" + macAddress + ", signature=" + signature + ", module=" + module + ", userCountLimit="
				+ userCountLimit + ", stringLicense=" + stringLicense + "]";
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getVersion() {
		return version;
	}
	public void setVersion(String version) {
		this.version = version;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Date getExpiry() {
		return expiry;
	}
	public void setExpiry(Date expiry) {
		this.expiry = expiry;
	}
	public String getMacAddress() {
		return macAddress;
	}
	public void setMacAddress(String macAddress) {
		this.macAddress = macAddress;
	}
	public String getSignature() {
		return signature;
	}
	public void setSignature(String signature) {
		this.signature = signature;
	}
	public List getModule() {
		return module;
	}
	public void setModule(List module) {
		this.module = module;
	}
	public Integer getUserCountLimit() {
		return userCountLimit;
	}
	public void setUserCountLimit(Integer userCountLimit) {
		this.userCountLimit = userCountLimit;
	}
	public String getStringLicense() {
		return stringLicense;
	}
	public void setStringLicense(String stringLicense) {
		this.stringLicense = stringLicense;
	}
	
	
}
