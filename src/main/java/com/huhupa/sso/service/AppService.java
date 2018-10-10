package com.huhupa.sso.service;

import com.huhupa.base.service.support.IBaseService;
import com.huhupa.sso.entity.App;

/**
 * <p>
 * 应用服务类
 * </p>
 *
 * @author SPPan
 * @since 2016-12-28
 */
public interface AppService extends IBaseService<App,Integer> {

	/**
	 * 添加应用
	 * @param app
	 */
	App saveOrUpdate(App app);

	/**
	 * 获取应用
	 * @param appId 应用id
	 * @param secret 应用秘钥
	 */
	App getAppByAppIdAndSecrets(String appId, String secret);

	/**
	 * 删除应用
	 * @param app 数据库的应用id
	 * @return
	 */
	int deleteApp(App app);
	
}
