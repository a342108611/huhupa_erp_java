package com.huhupa.sso.service.impl;

import com.huhupa.base.dao.support.IBaseDao;
import com.huhupa.base.service.support.impl.BaseServiceImpl;
import com.huhupa.common.Constats;
import com.huhupa.sso.dao.AppDao;
import com.huhupa.sso.entity.App;
import com.huhupa.sso.service.AppService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 资源表 服务实现类
 * </p>
 *
 * @author SPPan
 * @since 2016-12-28
 */
@Service
public class AppServiceImpl extends BaseServiceImpl<App, Integer> implements AppService {

	@Autowired
	private AppDao appDao;

	@Override
	public IBaseDao<App, Integer> getBaseDao() {
		return this.appDao;
	}

	@Override
	public App saveOrUpdate(App app) {
		if (null == app) {
			throw new RuntimeException("需要保存的应用不可为空");
		}
		try {
			App save = appDao.save(app);
			return save;
		}catch (Exception e) {
			throw new RuntimeException("系统繁忙，请稍后重试");
		}
	}

	@Override
	@Cacheable(value = Constats.APPCACHE, key = "'app_' + #appId + #secret")
	public App getAppByAppIdAndSecrets(String appId, String secret) {
		if (StringUtils.isBlank(appId) || StringUtils.isBlank(secret)) {
			throw new RuntimeException("应用id或秘钥不能为空");
		}
		App app  = new App();
		app.setAppId(appId);
		app.setSecret(secret);
		Example<App> example = Example.of(app);
		try {
			App one = appDao.findOne(example);
			return one;
		}catch (Exception e) {
			throw new RuntimeException("系统繁忙，请稍后重试");
		}
	}

	@Override
	@CacheEvict(value = Constats.APPCACHE,key = "'app_'+#app.getAppId() + #app.getSecret()")//这是清除缓存
	public int deleteApp(App app) {
		if (null == app) {
			throw new RuntimeException("请传入要删除的应用");
		}
		try {
			appDao.delete(app);
			return 0;
		}catch (Exception e) {
			throw new RuntimeException("系统繁忙，请稍后重试");
		}
	}

}
