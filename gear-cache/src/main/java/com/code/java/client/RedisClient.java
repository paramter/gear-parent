package com.code.java.client;

import org.springframework.data.redis.core.*;

/**
 * redis客户端
 * Created by 刘长申
 * on time 2017/5/18
 */
public class RedisClient {

    private RedisTemplate redisTemplate;

    //普通K-V操作
    private ValueOperations<String,Object> valueOperations;

    //set类型操作
    private SetOperations setOperations;

    //针对Map类型操作
    private HashOperations hashOperations;

    //list类型操作
    private ListOperations listOperations;

    public RedisClient() {
        //普通类型
        valueOperations = redisTemplate.opsForValue();
        setOperations = redisTemplate.opsForSet();
        hashOperations = redisTemplate.opsForHash();
        listOperations = redisTemplate.opsForList();
    }

    public ValueOperations<String,Object> getValueOperations() {
        return valueOperations;
    }

    public SetOperations getSetOperations() {
        return setOperations;
    }

    public HashOperations getHashOperations() {
        return hashOperations;
    }

    public ListOperations getListOperations() {
        return listOperations;
    }

    public RedisTemplate getRedisTemplate() {
        return redisTemplate;
    }

    public void setRedisTemplate(RedisTemplate redisTemplate) {
        this.redisTemplate = redisTemplate;
    }
}
