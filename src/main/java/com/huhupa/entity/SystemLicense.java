package com.huhupa.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

/**
 * 系统授权码
 * @author huhupa 朱勇军
 *
 */
@Entity
@Table(name="t_system_license")
public class SystemLicense {
	
	
	@Id
	@GeneratedValue
	private Integer id; // 编号
	
	@Column(columnDefinition="text COMMENT '字典名'")
	private String license; // 授权码字符串
	

	public SystemLicense() {
		super();
		// TODO Auto-generated constructor stub
	}

	public SystemLicense(Integer id,String license) {
		super();
		this.id = id;
		this.license = license;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getLicense() {
		return license;
	}

	public void setLicense(String license) {
		this.license = license;
	}

	@Override
	public String toString() {
		return "SystemLicense [id=" + id + ", license=" + license + "]";
	}

}
