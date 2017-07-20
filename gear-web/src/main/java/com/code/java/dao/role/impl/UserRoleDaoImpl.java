package com.code.java.dao.role.impl;

import com.code.java.common.server.impl.BaseDaoImpl;
import com.code.java.dao.role.UserRoleDao;
import com.code.java.entity.GearRoleResEntity;
import org.codehaus.plexus.util.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 用户权限查询dao
 * Created by 刘长申 on 2017/7/11.
 */
@Component
public class UserRoleDaoImpl extends BaseDaoImpl<GearRoleResEntity> implements UserRoleDao {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Transactional
    @Override
    public String getUserRoles(String userId) {
        logger.debug("查询用户:[{}]的权限信息",userId);
        if(StringUtils.isBlank(userId)){
            return null;
        }
        List roles = getHibernateTemplate().find("from GearRoleResEntity where userId = ?" , userId);
        logger.debug("用户查询结果条数:{}",roles == null ? 0:roles.size());
        if(roles != null && roles.size() > 0){
            GearRoleResEntity userRole = (GearRoleResEntity)roles.get(0);
            return userRole.getRoleSets();
        }
        return null;
    }
}
