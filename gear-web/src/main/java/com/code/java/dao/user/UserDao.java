package com.code.java.dao.user;

import com.code.java.common.server.BaseDao;
import com.code.java.entity.GearUserEntity;

/**
 * Created by 刘长申 on 2017/7/5.
 */
public interface UserDao extends BaseDao<GearUserEntity>{

    /**
     * 通过用户ID查询用户信息
     * @param userId
     * @return
     */
    public GearUserEntity findUserByUserId(String userId);
}
