package com.code.java.dao.role;

import com.code.java.common.server.BaseDao;
import com.code.java.entity.GearRoleResEntity;

/**
 * Created by 刘长申 on 2017/7/11.
 */
public interface UserRoleDao extends BaseDao<GearRoleResEntity> {

    /**
     * 通过用户ID获取权限
     * @param userId
     * @return
     */
    public String getUserRoles(String userId);
}
