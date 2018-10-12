package com.huhupa.basicdata.entity;

import com.alibaba.fastjson.annotation.JSONField;
import com.huhupa.base.entity.support.BaseEntity;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;

/**
 * <p>
 * 公司账户
 * </p>
 *
 * @author huhupa
 * @since 2018-10-10
 */
@Entity
@Table(name = "companyAccount")
@GenericGenerator(name = "jpa-uuid", strategy = "uuid")
public class CompanyAccount extends BaseEntity {

	private static final long serialVersionUID = 1L;

	/**
	 * id
	 */
	@Id
	@GeneratedValue(generator = "jpa-uuid")
	@Column(name = "id", nullable = false, length = 32)
	private String id;

	/**
	 * 名称
	 */
	private String name;

	/**
	 * 简称
	 */
	private String code;

	/**
	 * 当前余额
	 */
	private Double balance;

	/**
	 * 期初余额
	 */
	private Double beginBalance;

	/**
	 * 建账日期
	 */
	private Date buildZhangDate;

	/**
	 * 账户类别，分为，现金，银行存款，银行承兑
	 */
	private Integer accountType;

	/**
	 * 备注
	 */
	private String note;

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
		return "CompanyAccount{" +
				"id='" + id + '\'' +
				", name='" + name + '\'' +
				", code='" + code + '\'' +
				", balance=" + balance +
				", beginBalance=" + beginBalance +
				", buildZhangDate=" + buildZhangDate +
				", accountType=" + accountType +
				", note='" + note + '\'' +
				", valid=" + valid +
				", createdtime=" + createdtime +
				", modifiedtime=" + modifiedtime +
				", createduser='" + createduser + '\'' +
				", modifieduser='" + modifieduser + '\'' +
				'}';
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

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Double getBalance() {
		return balance;
	}

	public void setBalance(Double balance) {
		this.balance = balance;
	}

	public Double getBeginBalance() {
		return beginBalance;
	}

	public void setBeginBalance(Double beginBalance) {
		this.beginBalance = beginBalance;
	}

	public Date getBuildZhangDate() {
		return buildZhangDate;
	}

	public void setBuildZhangDate(Date buildZhangDate) {
		this.buildZhangDate = buildZhangDate;
	}

	public Integer getAccountType() {
		return accountType;
	}

	public void setAccountType(Integer accountType) {
		this.accountType = accountType;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
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
