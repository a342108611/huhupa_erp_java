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
@Table(name = "app")
public class App extends BaseEntity {

	private static final long serialVersionUID = 1L;

	/**
	 * 用户id
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", nullable = false)
	private Integer id;

	/**
	 * 应用id
	 */
	private String appId;

	/**
	 * 应用秘钥 secret
	 */
	private String secret;
	/**
	 * 应用创建时间
	 */
	@JSONField(format = "yyyy-MM-dd HH:mm:ss")
	private Date createTime;

	/**
	 * 应用创建者
	 */
	@ManyToOne
	private User createdUser;

	@Override
	public String toString() {
		return "App{" +
				"id=" + id +
				", appId='" + appId + '\'' +
				", secret='" + secret + '\'' +
				", createTime=" + createTime +
				", createdUser=" + createdUser +
				'}';
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getAppId() {
		return appId;
	}

	public void setAppId(String appId) {
		this.appId = appId;
	}

	public String getSecret() {
		return secret;
	}

	public void setSecret(String secret) {
		this.secret = secret;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public User getCreatedUser() {
		return createdUser;
	}

	public void setCreatedUser(User createdUser) {
		this.createdUser = createdUser;
	}
}
