package com.code.java.cache.manager;

import org.apache.shiro.cache.AbstractCacheManager;
import org.apache.shiro.cache.Cache;
import org.apache.shiro.cache.CacheException;

/**
 * redis实现shiro缓存管理
 * Created by 刘长申 on 2017/7/19.
 */
public class RedisShiroCacheManager extends AbstractCacheManager{

    protected Cache createCache(String name) throws CacheException {
        return new RedisShiroCache(name);
    }
}
