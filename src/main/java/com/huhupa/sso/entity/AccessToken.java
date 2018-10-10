package com.huhupa.sso.entity;

import com.alibaba.fastjson.annotation.JSONField;
import com.huhupa.base.entity.support.BaseEntity;

import javax.persistence.*;
import java.util.Date;

/**
 * <p>
 * 保存访问令牌
 * </p>
 *
 * @author SPPan
 * @since 2016-12-28
 */
@Entity
@Table(name = "access_token")
public class AccessToken extends BaseEntity {

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
	 * token有效截止时间
	 */
	@JSONField(format = "yyyy-MM-dd HH:mm:ss")
	private Date expire;

	@Override
	public String toString() {
		return "AccessToken{" +
				"id=" + id +
				", accessToken='" + accessToken + '\'' +
				", expire=" + expire +
				'}';
	}

	public Date getExpire() {
		return expire;
	}

	public void setExpire(Date expire) {
		this.expire = expire;
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

}
