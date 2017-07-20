package com.code.java.dao.user.impl;

import com.code.java.common.server.impl.BaseDaoImpl;
import com.code.java.dao.user.UserDao;
import com.code.java.entity.GearUserEntity;
import org.codehaus.plexus.util.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 用户信息dao层实现
 * Created by 刘长申 on 2017/7/5.
 */
@Component
public class UserDaoImpl extends BaseDaoImpl<GearUserEntity> implements UserDao {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Transactional
    @Override
    public GearUserEntity findUserByUserId(String userId) {
        logger.debug("使用userId:[{}]查询用户信息",userId);
        if(StringUtils.isBlank(userId)){
            return null;
        }
        List users = getHibernateTemplate().find("from GearUserEntity where userId = ?" , userId);
        logger.debug("用户查询结果条数:{}",users == null ? 0:users.size());
        if(users != null && users.size() > 0){
            return (GearUserEntity) users.get(0);
        }
        return null;
    }
}
