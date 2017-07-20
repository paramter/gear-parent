package com.code.java.security.listener;

import org.apache.shiro.session.Session;
import org.apache.shiro.session.SessionListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * shiro session会话监听
 * Created by 刘长申 on 2017/7/18.
 */
public class ShiroSessionListener implements SessionListener{

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public void onStart(Session session) {
        logger.debug("session会话创建:{}",session.getId());
    }

    @Override
    public void onStop(Session session) {
        logger.debug("session会话停止:{}",session.getId());
    }

    @Override
    public void onExpiration(Session session) {
        logger.debug("session会话过期:{}",session.getId());
    }
}
