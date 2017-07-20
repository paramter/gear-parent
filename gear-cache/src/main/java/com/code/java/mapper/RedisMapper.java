package com.code.java.mapper;

import com.code.java.client.RedisClient;
import com.code.java.redis.constants.RedisConstants;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/**
 * redis操作工具
 * Created by 刘长申 on 2017/7/19.
 */
public class RedisMapper {

    @Autowired
    private static RedisClient redisClient;

    /**
     * value类型存储
     * @param key key值
     * @param value value值
     */
    public static void putStr(String key,Object value){
        putStr(key,value, RedisConstants.DEFAULT_ZERO_EXPIRETIME,TimeUnit.SECONDS);
    }

    /**
     * value类型存储(带超时时间)
     * @param key key值
     * @param value value值
     * @param expireTime 超时时间
     */
    public static void putStr(String key, Object value, long expireTime, TimeUnit timeUnit){
        redisClient.getValueOperations().set(key, value, expireTime,timeUnit);
    }

    /**
     * value类型批量删除-String type
     * @param keys 批量删除的key值
     */
    public static void delStrs(String ... keys){
        for (String key:keys) {
            delStr(key);
        }
    }

    /**
     * value类型批量删除-List type
     * @param keys 批量删除的key值
     */
    public static void delStrs(List<String> keys){
        for (String key:keys) {
            delStr(key);
        }
    }

    /**
     * value类型批量删除-Set type
     * @param keys 批量删除的key值
     */
    public static void delStrs(Set<String> keys){
        for (String key:keys) {
            delStr(key);
        }
    }

    /**
     * value类型删除缓存
     * @param key
     */
    @SuppressWarnings("unchecked")
    public static void delStr(String key){
        redisClient.getRedisTemplate().delete(key);
    }

    /**
     * value类型取值
     * @param key
     * @return
     */
    public static Object getStr(String key){
        return redisClient.getValueOperations().get(key);
    }

    public void setRedisClient(RedisClient redisClient) {
        this.redisClient = redisClient;
    }
}
