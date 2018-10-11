package com.huhupa.base.core.listener;

import com.huhupa.base.common.utils.LoggerUtils;
import com.huhupa.base.common.utils.SpringUtil;
import com.huhupa.base.core.shiro.session.ShiroSessionRepository;
import org.apache.shiro.session.Session;
import org.apache.shiro.session.SessionListener;
import org.springframework.stereotype.Component;

import javax.servlet.annotation.WebListener;

@Component
@WebListener
public class ShiroSessionListener implements SessionListener {

    private ShiroSessionRepository shiroSessionRepository;

    @Override
    public void onStart(Session session) {
        //System.out.println("创建shiroSessionRepository:" + getShiroSessionRepository());
        LoggerUtils.error(getClass(), "session创建：" + session.getId());
    }

    @Override
    public void onStop(Session session) {
        //System.out.println("停止shiroSessionRepository:" + getShiroSessionRepository());
        LoggerUtils.error(getClass(), "session停止：" + session.getId());
    }

    @Override
    public void onExpiration(Session session) {
        LoggerUtils.error(getClass(), "session过期：" + session.getId());
    }

    public ShiroSessionRepository getShiroSessionRepository() {
        shiroSessionRepository = (ShiroSessionRepository)SpringUtil.getBean("shiroSessionRepository");
        return shiroSessionRepository;
    }
}
