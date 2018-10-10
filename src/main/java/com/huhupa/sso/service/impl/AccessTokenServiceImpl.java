package com.huhupa.sso.service.impl;

import com.huhupa.base.core.token.manager.TokenManager;
import com.huhupa.base.dao.support.IBaseDao;
import com.huhupa.base.entity.User;
import com.huhupa.base.service.support.impl.BaseServiceImpl;
import com.huhupa.sso.dao.AccessTokenDao;
import com.huhupa.sso.dao.AppDao;
import com.huhupa.sso.entity.AccessToken;
import com.huhupa.sso.entity.App;
import com.huhupa.sso.entity.CertificationRecords;
import com.huhupa.sso.service.AccessTokenService;
import com.huhupa.sso.service.CertificationRecordsService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.UUID;

/**
 * <p>
 * 资源表 服务实现类
 * </p>
 *
 * @author SPPan
 * @since 2016-12-28
 */
@Service
public class AccessTokenServiceImpl extends BaseServiceImpl<AccessToken, Integer> implements AccessTokenService {

	@Autowired
	private AccessTokenDao accessTokenDao;

	@Autowired
	private AppDao appDao;

	@Autowired
	private CertificationRecordsService certificationRecordsService;

	@Override
	public IBaseDao<AccessToken, Integer> getBaseDao() {
		return this.accessTokenDao;
	}

	@Override
	public AccessToken saveOrUpdate(AccessToken accessToken) {
		if (null == accessToken) {
			throw new RuntimeException("需要保存的token不能为空");
		}
		try {
			AccessToken save = accessTokenDao.save(accessToken);
			return save;
		}catch (Exception e) {
			this.logger.error("数据库连接异常：" + e);
			throw new RuntimeException("系统繁忙，请稍后重试");
		}
	}

	@Override
	public AccessToken getAccessToken(HttpSession session, String appId, String secret) {
		if (StringUtils.isBlank(appId) || StringUtils.isBlank(secret)) {
			throw new RuntimeException("获取失败，应用id或秘钥不能为空");
		}
		App app = new App();
		app.setSecret(secret);
		app.setAppId(appId);
		System.out.println("app:"+app);
		App one = appDao.findOne(Example.of(app));
		if (null == one) {
			throw new RuntimeException("此应用尚未被授权，请联系认证中心系统管理员授权");
		}
		AccessToken accessToken = (AccessToken) session.getAttribute("accessToken");
		if (null == accessToken){
			accessToken = new AccessToken();
			accessToken.setAccessToken(UUID.randomUUID().toString());
			session.setAttribute("accessToken", accessToken);
			this.logger.info("新token:" + accessToken);
			accessTokenDao.save(accessToken);
			CertificationRecords certificationRecords = new CertificationRecords();
			certificationRecords.setApp(one);
			User currentUser = TokenManager.getToken(true);
			certificationRecords.setUser(currentUser);
			certificationRecords.setAccessToken(accessToken.getAccessToken());
			certificationRecords.setCertificationTime(new Date());
			certificationRecordsService.saveOrUpdate(certificationRecords);
		}
		return accessToken;
	}

	@Override
	public AccessToken getAccessToken(String token) {
		if (StringUtils.isBlank(token)){
			throw new RuntimeException("token不能为空");
		}
		AccessToken accessToken = new AccessToken();
		accessToken.setAccessToken(token);
		Example<AccessToken> example = Example.of(accessToken);
		AccessToken one;
		try {
			one = accessTokenDao.findOne(example);
		}catch (Exception e) {
			this.logger.error("数据库连接异常：" + e);
			throw new RuntimeException("系统繁忙，请稍后重试");
		}
		if (null == one) {
			throw new RuntimeException("无效的访问令牌");
		}
		return one;
	}

	@Override
	public int deleteAccessToken(AccessToken accessToken) {
		if (null == accessToken){
			throw new RuntimeException("token不能为空");
		}
		try {
			accessTokenDao.delete(accessToken);
			return 1;
		}catch (Exception e) {
			this.logger.error("数据库连接异常：" + e);
			throw new RuntimeException("系统繁忙，请稍后重试");
		}
	}
}
