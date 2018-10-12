package com.huhupa.basicdata.entity;

import com.alibaba.fastjson.annotation.JSONField;
import com.huhupa.base.entity.support.BaseEntity;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;

/**
 * <p>
 * 职员
 * </p>
 *
 * @author huhupa
 * @since 2018-10-10
 */
@Entity
@Table(name = "clerk")
@GenericGenerator(name = "jpa-uuid", strategy = "uuid")
public class Clerk extends BaseEntity {

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
	 * 工号
	 */
	private String workCode;

	private String phone;

	private String email;

	/**
	 * 性别 0 女 1 男
	 */
	private Integer sex;

	/**
	 * 身份证住址
	 */
	private String idAddress;

	/**
	 * 现居住住址
	 */
	private String nowLiveAddress;

	/**
	 * 入职日期
	 */
	@JSONField(format = "yyyy-MM-dd")
	private Date entryDate;

	/**
	 * 离职日期
	 */
	@JSONField(format = "yyyy-MM-dd")
	private Date quitDate;

	/**
	 * 生日
	 */
	@JSONField(format = "yyyy-MM-dd")
	private Date birthday;

	/**
	 * 毕业日期
	 */
	@JSONField(format = "yyyy-MM-dd")
	private Date graduationDate;

	/**
	 * 毕业院校
	 */
	private String  graduateInstitutions;

	/**
	 * 最高学历
	 */
	private String  highestDegreeEducation;

	/**
	 * 描述
	 */
	private String description;

	@ManyToOne
	private Department department; // 部门

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
		return "Clerk{" +
				"id='" + id + '\'' +
				", name='" + name + '\'' +
				", workCode='" + workCode + '\'' +
				", phone='" + phone + '\'' +
				", email='" + email + '\'' +
				", sex=" + sex +
				", idAddress='" + idAddress + '\'' +
				", nowLiveAddress='" + nowLiveAddress + '\'' +
				", entryDate=" + entryDate +
				", quitDate=" + quitDate +
				", birthday=" + birthday +
				", graduationDate=" + graduationDate +
				", graduateInstitutions='" + graduateInstitutions + '\'' +
				", highestDegreeEducation='" + highestDegreeEducation + '\'' +
				", description='" + description + '\'' +
				", department=" + department +
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

	public String getGraduateInstitutions() {
		return graduateInstitutions;
	}

	public void setGraduateInstitutions(String graduateInstitutions) {
		this.graduateInstitutions = graduateInstitutions;
	}

	public String getHighestDegreeEducation() {
		return highestDegreeEducation;
	}

	public void setHighestDegreeEducation(String highestDegreeEducation) {
		this.highestDegreeEducation = highestDegreeEducation;
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

	public String getWorkCode() {
		return workCode;
	}

	public void setWorkCode(String workCode) {
		this.workCode = workCode;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Integer getSex() {
		return sex;
	}

	public void setSex(Integer sex) {
		this.sex = sex;
	}

	public String getIdAddress() {
		return idAddress;
	}

	public void setIdAddress(String idAddress) {
		this.idAddress = idAddress;
	}

	public String getNowLiveAddress() {
		return nowLiveAddress;
	}

	public void setNowLiveAddress(String nowLiveAddress) {
		this.nowLiveAddress = nowLiveAddress;
	}

	public Date getEntryDate() {
		return entryDate;
	}

	public void setEntryDate(Date entryDate) {
		this.entryDate = entryDate;
	}

	public Date getQuitDate() {
		return quitDate;
	}

	public void setQuitDate(Date quitDate) {
		this.quitDate = quitDate;
	}

	public Date getGraduationDate() {
		return graduationDate;
	}

	public void setGraduationDate(Date graduationDate) {
		this.graduationDate = graduationDate;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
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
