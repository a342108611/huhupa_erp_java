package com.huhupa.basicdata.entity;

import com.alibaba.fastjson.annotation.JSONField;
import com.huhupa.base.entity.support.BaseEntity;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

/**
 * <p>
 * 客户表
 * </p>
 *
 * @author huhupa
 * @since 2018-10-10
 */
@Entity
@Table(name = "company")
@GenericGenerator(name = "jpa-uuid", strategy = "uuid")
public class Company extends BaseEntity {

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
	private String shortName;

	/**
	 * 客户类别
	 */
	@ManyToOne
	private CompanyCategory companyCategory;

//	/**
//	 * 客户联系人
//	 */
//	private String contact;
//
//	private String phone;
//
//	private String email;

	/**
	 * 公司类型：1 为供应商，2 为客户
	 */
	private Integer type;

	/**
	 * 期初应收款
	 */
	private Double initialReceivables;
	/**
	 * 期初预收款
	 */
	private Double initialAdvanceCollection;
	/**
	 * 纳税人识别号
	 */
	private String taxpayerIdentificationNumber;

	/**
	 * 开户银行
	 */
	private String openAccountBank;

	/**
	 * 银行账号
	 */
	private String bankAccount;

	/**
	 * 销售人员
	 */
	@ManyToOne
	private Clerk salesStaff;

	/**
	 * 公司联系人
	 */
	@OneToMany
	private Set<CompanyContact> companyContacts;

	/**
	 * 地址
	 */
	private String address;

	@ManyToOne
	private PaymentMethod paymentMethod; // 结算方式

	/**
	 * 备注
	 */
	private String note;

	@ManyToMany(cascade = { CascadeType.REFRESH }, fetch = FetchType.LAZY)
	@JoinTable(name = "product_company", joinColumns = { @JoinColumn(name = "company_id") }, inverseJoinColumns = { @JoinColumn(name = "product_id") })
	private java.util.Set<Product> products;

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
		return "Company{" +
				"id='" + id + '\'' +
				", name='" + name + '\'' +
				", shortName='" + shortName + '\'' +
				", companyCategory=" + companyCategory +
				", type=" + type +
				", initialReceivables=" + initialReceivables +
				", initialAdvanceCollection=" + initialAdvanceCollection +
				", taxpayerIdentificationNumber='" + taxpayerIdentificationNumber + '\'' +
				", openAccountBank='" + openAccountBank + '\'' +
				", bankAccount='" + bankAccount + '\'' +
				", salesStaff=" + salesStaff +
				", address='" + address + '\'' +
				", paymentMethod=" + paymentMethod +
				", note='" + note + '\'' +
				", products=" + products +
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

	public String getShortName() {
		return shortName;
	}

	public void setShortName(String shortName) {
		this.shortName = shortName;
	}

	public CompanyCategory getCompanyCategory() {
		return companyCategory;
	}

	public void setCompanyCategory(CompanyCategory companyCategory) {
		this.companyCategory = companyCategory;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public Double getInitialReceivables() {
		return initialReceivables;
	}

	public void setInitialReceivables(Double initialReceivables) {
		this.initialReceivables = initialReceivables;
	}

	public Double getInitialAdvanceCollection() {
		return initialAdvanceCollection;
	}

	public void setInitialAdvanceCollection(Double initialAdvanceCollection) {
		this.initialAdvanceCollection = initialAdvanceCollection;
	}

	public String getTaxpayerIdentificationNumber() {
		return taxpayerIdentificationNumber;
	}

	public void setTaxpayerIdentificationNumber(String taxpayerIdentificationNumber) {
		this.taxpayerIdentificationNumber = taxpayerIdentificationNumber;
	}

	public String getOpenAccountBank() {
		return openAccountBank;
	}

	public void setOpenAccountBank(String openAccountBank) {
		this.openAccountBank = openAccountBank;
	}

	public String getBankAccount() {
		return bankAccount;
	}

	public void setBankAccount(String bankAccount) {
		this.bankAccount = bankAccount;
	}

	public Clerk getSalesStaff() {
		return salesStaff;
	}

	public void setSalesStaff(Clerk salesStaff) {
		this.salesStaff = salesStaff;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public PaymentMethod getPaymentMethod() {
		return paymentMethod;
	}

	public void setPaymentMethod(PaymentMethod paymentMethod) {
		this.paymentMethod = paymentMethod;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public Set<Product> getProducts() {
		return products;
	}

	public void setProducts(Set<Product> products) {
		this.products = products;
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
