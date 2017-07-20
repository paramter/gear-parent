package com.code.java.security.realm;

import com.code.java.dao.user.UserDao;
import com.code.java.dao.role.UserRoleDao;
import com.code.java.entity.GearUserEntity;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 用户操作Realm
 * Created by 刘长申
 * on time 2017/6/22
 */
public class UserRealm extends AuthorizingRealm {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private UserDao userDao;

    @Autowired
    private UserRoleDao userRoleDao;

    /**
     * 校验权限
     * @param principalCollection
     * @return AuthorizationInfo
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        String userId = (String)principalCollection.getPrimaryPrincipal();
        logger.debug("开始查询userId:[{}]的权限",userId);
        //查询用户权限
        String roles = userRoleDao.getUserRoles(userId);
        Set<String> roleSet = new HashSet<String>(Arrays.asList(roles.split(",")));
        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        authorizationInfo.setRoles(roleSet);
        return authorizationInfo;
    }

    /**
     * 校验登陆信息
     * @param authenticationToken
     * @return AuthenticationInfo
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        //从令牌获取用户名
        String userId = (String)authenticationToken.getPrincipal();
        //获取密码
        String pwd = new String((char[])authenticationToken.getCredentials());

        //通过用户名查询用户信息
        GearUserEntity user = userDao.findUserByUserId(userId);
        //用户不存在
        if(user == null){
            throw new UnknownAccountException();
        }
        //放入用户基本信息，以用户ID作为盐值
        SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(userId,
                pwd, ByteSource.Util.bytes(userId), getName());
        return authenticationInfo;
    }
}
