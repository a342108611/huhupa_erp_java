package com.huhupa.basicdata.entity;

import com.huhupa.base.entity.support.BaseEntity;

import javax.persistence.*;

/**
 * <p>
 * 收入类别
 * </p>
 *
 * @author huhupa
 * @since 2018-10-10
 */
@Entity
@Table(name = "incomeCategory")
public class IncomeCategory extends BaseEntity {

	private static final long serialVersionUID = 1L;

	/**
	 * 用户id
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", nullable = false)
	private Integer id;

	/**
	 * 名称
	 */
	private String name;

	/**
	 * 逻辑删除状态 1 未删除 0 删除
	 */
	private Integer valid = 1;

	@Override
	public String toString() {
		return "CustomerCategory{" +
				"id=" + id +
				", name='" + name + '\'' +
				", valid=" + valid +
				'}';
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getValid() {
		return valid;
	}

	public void setValid(Integer valid) {
		this.valid = valid;
	}
}
