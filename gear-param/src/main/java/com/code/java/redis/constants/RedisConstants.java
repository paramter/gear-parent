package com.code.java.redis.constants;

/**
 * redis常量
 * Created by 刘长申 on 2017/7/19.
 */
public interface RedisConstants {

    /**
     *  默认redis超时时间-0
     */
    long DEFAULT_ZERO_EXPIRETIME = 0;

    /**
     * 超时时间10min
     */
    long DEFAULT_TENMIN_EXPIRETIME = 10;

    /**
     * 超时时间1h
     */
    long DEFAULT_ONEHOUR_EXPIRETIME = 1;

    /**
     * shiro缓存名称前缀
     */
    String SHIRO_CACHE_KEY = "shiro-redis-cache:";
}
