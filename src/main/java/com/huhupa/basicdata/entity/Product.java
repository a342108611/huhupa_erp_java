package com.huhupa.basicdata.entity;

import com.alibaba.fastjson.annotation.JSONField;
import com.huhupa.base.entity.support.BaseEntity;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

/**
 * <p>
 * 产品
 * </p>
 *
 * @author huhupa
 * @since 2018-10-10
 */
@Entity
@Table(name = "product")
@GenericGenerator(name = "jpa-uuid", strategy = "uuid")
public class Product extends BaseEntity {

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
	 * 所属客户 （供应商，客户，二选一）
	 */
	@ManyToMany(cascade = { CascadeType.REFRESH }, fetch = FetchType.LAZY)
	@JoinTable(name = "product_company", joinColumns = { @JoinColumn(name = "product_id") }, inverseJoinColumns = { @JoinColumn(name = "company_id") })
	private java.util.Set<Company> companys;

	@ManyToOne
	private Unit unit; // 计量单位
	@ManyToOne
	private BasicMaterial basicMaterial; // 基材

	private ProductionType productionType; // 生产加工类型

	private Double price; // 基础单价

	private Double inventory;  // 库存

	private String note; // 备注

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
		return "Product{" +
				"id='" + id + '\'' +
				", name='" + name + '\'' +
				", companys=" + companys +
				", unit=" + unit +
				", basicMaterial=" + basicMaterial +
				", productionType=" + productionType +
				", price=" + price +
				", inventory=" + inventory +
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

	public Unit getUnit() {
		return unit;
	}

	public void setUnit(Unit unit) {
		this.unit = unit;
	}

	public BasicMaterial getBasicMaterial() {
		return basicMaterial;
	}

	public void setBasicMaterial(BasicMaterial basicMaterial) {
		this.basicMaterial = basicMaterial;
	}

	public Set<Company> getCompanys() {
		return companys;
	}

	public void setCompanys(Set<Company> companys) {
		this.companys = companys;
	}

	public ProductionType getProductionType() {
		return productionType;
	}

	public void setProductionType(ProductionType productionType) {
		this.productionType = productionType;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Double getInventory() {
		return inventory;
	}

	public void setInventory(Double inventory) {
		this.inventory = inventory;
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