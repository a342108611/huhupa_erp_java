package com.huhupa.sso.service;

import com.huhupa.base.service.support.IBaseService;
import com.huhupa.sso.entity.AccessToken;

import javax.servlet.http.HttpSession;

/**
 * <p>
 * 应用服务类
 * </p>
 *
 * @author SPPan
 * @since 2016-12-28
 */
public interface AccessTokenService extends IBaseService<AccessToken,Integer> {

	/**
	 * 添加
	 * @param accessToken
	 */
	AccessToken saveOrUpdate(AccessToken accessToken);

	/**
	 * 获取
	 * @param accessToken 应用token
	 */
	AccessToken getAccessToken(String accessToken);

	AccessToken getAccessToken(HttpSession session, String appId, String secret);

	/**
	 * 删除应用
	 * @param accessToken 数据库的应用id
	 * @return
	 */
	int deleteAccessToken(AccessToken accessToken);
	
}
