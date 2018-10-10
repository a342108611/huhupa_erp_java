package com.huhupa.base.config.shiro;

import com.huhupa.base.core.listener.ShiroSessionListener;
import com.huhupa.base.service.IResourceService;
import org.apache.shiro.cache.CacheManager;
import org.apache.shiro.cache.MemoryConstrainedCacheManager;
import org.apache.shiro.mgt.DefaultSecurityManager;
import org.apache.shiro.realm.Realm;
import org.apache.shiro.session.SessionListener;
import org.apache.shiro.session.mgt.SessionManager;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.apache.shiro.web.session.mgt.DefaultWebSessionManager;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.springframework.context.annotation.Import;

import javax.annotation.Resource;
import java.util.*;

@Configuration
@Import(ShiroManagerConfig.class)
public class ShiroConfig {

	@Resource
	private IResourceService resourceService;

//	@Resource
//	private CacheManager customShiroCacheManager;

	@Bean(name = "realm")
	@DependsOn("lifecycleBeanPostProcessor")
	@ConditionalOnMissingBean
	public Realm realm() {
		return new MyRealm();
	}
	
	 /**
     * 用户授权信息Cache
     */
    @Bean(name = "shiroCacheManager")
    @ConditionalOnMissingBean
    public CacheManager cacheManager() {
        return new MemoryConstrainedCacheManager();
//		return customShiroCacheManager;
    }

	@Bean(name = "sessionManager")
	public SessionManager sessionManager() {
		DefaultWebSessionManager sessionManager = new DefaultWebSessionManager();
//		sessionManager.setSessionDAO(redisSessionDAO());
		//设置session失效时间
		sessionManager.setGlobalSessionTimeout(30*60*1000L);
		//删除过期的session
		sessionManager.setDeleteInvalidSessions(true);
		//注册自定义session监听
		Collection<SessionListener> listeners = new ArrayList<SessionListener>();
		listeners.add(new ShiroSessionListener());
		sessionManager.setSessionListeners(listeners);
		return sessionManager;
	}

    @Bean(name = "securityManager")
    @ConditionalOnMissingBean
    public DefaultSecurityManager securityManager() {
        DefaultSecurityManager sm = new DefaultWebSecurityManager();
        sm.setCacheManager(cacheManager());
        sm.setSessionManager(sessionManager());
        return sm;
    }

	@Bean(name = "shiroFilter")
	@DependsOn("securityManager")
	@ConditionalOnMissingBean
	public ShiroFilterFactoryBean getShiroFilterFactoryBean(DefaultSecurityManager securityManager, Realm realm) {
		securityManager.setRealm(realm);

		ShiroFilterFactoryBean shiroFilter = new ShiroFilterFactoryBean();
		shiroFilter.setSecurityManager(securityManager);
		shiroFilter.setLoginUrl("/admin/login");
		shiroFilter.setSuccessUrl("/admin/index");
		shiroFilter.setUnauthorizedUrl("/previlige/no");
		Map<String, String> filterChainDefinitionMap = new HashMap<String, String>();
		filterChainDefinitionMap.put("/assets/**", "anon");
		filterChainDefinitionMap.put("/sso/**", "anon");
		
		filterChainDefinitionMap.put("/admin/login", "anon");
		
		List<com.huhupa.base.entity.Resource> list = resourceService.findAll();
		for (com.huhupa.base.entity.Resource resource : list) {
			filterChainDefinitionMap.put(resource.getSourceUrl(), "perms[" + resource.getSourceKey() + "]");
		}
		
//		filterChainDefinitionMap.put("/admin/user/index", "perms[system:user:index]");
//		filterChainDefinitionMap.put("/admin/user/add", "perms[system:user:add]");
//		filterChainDefinitionMap.put("/admin/user/edit*", "perms[system:user:edit]");
//		filterChainDefinitionMap.put("/admin/user/deleteBatch", "perms[system:user:deleteBatch]");
//		filterChainDefinitionMap.put("/admin/user/grant/**", "perms[system:user:grant]");
		
//		filterChainDefinitionMap.put("/admin/role/index", "perms[system:role:index]");
//		filterChainDefinitionMap.put("/admin/role/add", "perms[system:role:add]");
//		filterChainDefinitionMap.put("/admin/role/edit*", "perms[system:role:edit]");
//		filterChainDefinitionMap.put("/admin/role/deleteBatch", "perms[system:role:deleteBatch]");
//		filterChainDefinitionMap.put("/admin/role/grant/**", "perms[system:role:grant]");
		
//		filterChainDefinitionMap.put("/admin/resource/index", "perms[system:resource:index]");
//		filterChainDefinitionMap.put("/admin/resource/add", "perms[system:resource:add]");
//		filterChainDefinitionMap.put("/admin/resource/edit*", "perms[system:resource:edit]");
//		filterChainDefinitionMap.put("/admin/resource/deleteBatch", "perms[system:resource:deleteBatch]");
		
		filterChainDefinitionMap.put("/admin/**", "authc");
		shiroFilter.setFilterChainDefinitionMap(filterChainDefinitionMap);
		return shiroFilter;
	}
}
