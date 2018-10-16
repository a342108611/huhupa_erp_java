package com.huhupa.basicdata.entity;

import com.alibaba.fastjson.annotation.JSONField;
import com.huhupa.base.entity.support.BaseEntity;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;

/**
 * <p>
 * 公司联系人
 * </p>
 *
 * @author huhupa
 * @since 2018-10-10
 */
@Entity
@Table(name = "companyContact")
//@GenericGenerator(name = "jpa-uuid", strategy = "uuid")
public class CompanyContact extends BaseEntity {

	private static final long serialVersionUID = 1L;

	/**
	 * id
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", nullable = false)
	private String id;

	/**
	 * 姓名
	 */
	private String name;

	/**
	 * 座机
	 */
	private String phone;

	/**
	 * 手机
	 */
	private String mobilePhone;

	/**
	 * 邮箱
	 */
	private String email;

	/**
	 * 联系地址
	 */
	private String address;

	/**
	 * 是否为首要联系人
	 */
	private Integer isDefaultContact = 0;

	/**
	 * 公司
	 */
	@ManyToOne
	private Company company;

	/**
	 * 逻辑删除状态 1 未删除 0 删除
	 */
	private Integer valid = 1;

	@JSONField(format = "yyyy-MM-dd")
	private Date createdtime;

	@JSONField(format = "yyyy-MM-dd")
	private Date modifiedtime;

	private String createduser;

	private String modifieduser;

	@Override
	public String toString() {
		return "CompanyContact{" +
				"id='" + id + '\'' +
				", name='" + name + '\'' +
				", phone='" + phone + '\'' +
				", mobilePhone='" + mobilePhone + '\'' +
				", email='" + email + '\'' +
				", address='" + address + '\'' +
				", isDefaultContact=" + isDefaultContact +
				", company=" + company +
				", valid=" + valid +
				", createdtime=" + createdtime +
				", modifiedtime=" + modifiedtime +
				", createduser='" + createduser + '\'' +
				", modifieduser='" + modifieduser + '\'' +
				'}';
	}

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getMobilePhone() {
		return mobilePhone;
	}

	public void setMobilePhone(String mobilePhone) {
		this.mobilePhone = mobilePhone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Integer getIsDefaultContact() {
		return isDefaultContact;
	}

	public void setIsDefaultContact(Integer isDefaultContact) {
		this.isDefaultContact = isDefaultContact;
	}

	public Integer getValid() {
		return valid;
	}

	public void setValid(Integer valid) {
		this.valid = valid;
	}

	public Date getCreatedtime() {
		return createdtime;
	}

	public void setCreatedtime(Date createdtime) {
		this.createdtime = createdtime;
	}

	public Date getModifiedtime() {
		return modifiedtime;
	}

	public void setModifiedtime(Date modifiedtime) {
		this.modifiedtime = modifiedtime;
	}

	public String getCreateduser() {
		return createduser;
	}

	public void setCreateduser(String createduser) {
		this.createduser = createduser;
	}

	public String getModifieduser() {
		return modifieduser;
	}

	public void setModifieduser(String modifieduser) {
		this.modifieduser = modifieduser;
	}
}
