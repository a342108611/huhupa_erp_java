package com.huhupa.sso.entity;

import com.alibaba.fastjson.annotation.JSONField;
import com.huhupa.base.entity.User;
import com.huhupa.base.entity.support.BaseEntity;

import javax.persistence.*;
import java.util.Date;

/**
 * <p>
 * 认证记录表
 * </p>
 *
 * @author SPPan
 * @since 2016-12-28
 */
@Entity
@Table(name = "certification_records")
public class CertificationRecords extends BaseEntity {

	private static final long serialVersionUID = 1L;

	/**
	 * 用户id
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", nullable = false)
	private Integer id;

	/**
	 * 访问令牌 access_token
	 */
	private String accessToken;

	/**
	 * access_token对应的用户
	 */
	@ManyToOne
	private User user;
	/**
	 * 令牌认证时间
	 */
	@JSONField(format = "yyyy-MM-dd HH:mm:ss")
	private Date certificationTime;

	@ManyToOne
	private App app;

	public App getApp() {
		return app;
	}

	@Override
	public String toString() {
		return "CertificationRecords{" +
				"id=" + id +
				", accessToken='" + accessToken + '\'' +
				", user=" + user +
				", certificationTime=" + certificationTime +
				", app=" + app +
				'}';
	}

	public void setApp(App app) {
		this.app = app;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getAccessToken() {
		return accessToken;
	}

	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Date getCertificationTime() {
		return certificationTime;
	}

	public void setCertificationTime(Date certificationTime) {
		this.certificationTime = certificationTime;
	}
}
