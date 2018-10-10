package com.huhupa.base.core.token.manager;

import com.huhupa.base.entity.User;
import org.apache.shiro.SecurityUtils;

public class TokenManager {

    //用户登录管理
   // public static final MyRealm realm = SpringContextUtil.getBean("myRealm",MyRealm.class);
    //用户session管理
    //public static final ShiroSessionRepository ShiroSessionRepository = SpringContextUtil.getBean("customSessionManager",CustomSessionManager.class);
    /**
     * 获取当前登录的用户User对象
     * @return
     */
    public static User getCurrentUser() {
        return getToken(true);
    }

    public static User getToken(Boolean isSimple){
        User principal = (User) SecurityUtils.getSubject().getPrincipal();
        User simpleUser = null;
        if (null == isSimple || isSimple) {
            simpleUser = getSimpleUser(principal);
        } else {
            simpleUser = principal;
        }
        return simpleUser ;
    }

    private static User getSimpleUser(User principal) {
        User user = new User();
        if (null != principal) {
            user.setAddress(principal.getAddress());
            user.setEmail(principal.getEmail());
            user.setNickName(principal.getNickName());
            user.setUserName(principal.getUserName());
            user.setId(principal.getId());
            user.setTelephone(principal.getTelephone());
        }
        return user;
    }
}
