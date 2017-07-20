package com.code.java.util.redis;

import com.code.java.redis.constants.RedisConstants;
import org.apache.commons.lang3.StringUtils;

/**
 * redis对cache对缓存工具类
 * Created by 刘长申 on 2017/7/19.
 */
public class RedisCacheUtil {

    /**
     * 构建shiro缓存key
     * @param e
     * @return
     */
    public static String buildKey(String name,Object e){
        String key = String.valueOf(e);
        if(StringUtils.startsWith(key, RedisConstants.SHIRO_CACHE_KEY + name)){
            return key;
        }
        return RedisConstants.SHIRO_CACHE_KEY + name + ":" + key;
    }
}
