package com.code.java.cache.manager;

import com.code.java.mapper.RedisMapper;
import com.code.java.util.redis.RedisCacheUtil;
import org.apache.shiro.cache.Cache;
import org.apache.shiro.cache.CacheException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Collection;
import java.util.Set;

/**
 * redis实现shiro缓存操作
 * Created by 刘长申 on 2017/7/19.
 */
public class RedisShiroCache<K,V> implements Cache<K,V>{

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    private String realmName;

    public RedisShiroCache(String name) {
        this.realmName = name;
    }

    @SuppressWarnings("unchecked")
    public V get(K k) throws CacheException {
        Object value = RedisMapper.getStr(RedisCacheUtil.buildKey(realmName,String.valueOf(k)));
        if(logger.isDebugEnabled()){
            logger.debug("shiro cache get msg:{}",value);
        }
        return (V) value;
    }

    public V put(K k, V v) throws CacheException {
        return null;
    }

    public V remove(K k) throws CacheException {
        return null;
    }

    public void clear() throws CacheException {

    }

    public int size() {
        return 0;
    }

    public Set<K> keys() {
        return null;
    }

    public Collection<V> values() {
        return null;
    }
}
