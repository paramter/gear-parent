package com.code.java.util.serializa;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * json序列化工具类
 * Created by 刘长申 on 2017/7/20.
 */
public class SerializableJsonUtil {
    private static Logger logger = LoggerFactory.getLogger(SerializableJsonUtil.class);

    private final static ObjectMapper objectMapper = new ObjectMapper();

    static {
        objectMapper.configure(JsonParser.Feature.ALLOW_COMMENTS, true);
        objectMapper.configure(JsonParser.Feature.ALLOW_UNQUOTED_FIELD_NAMES, true);
        objectMapper.configure(JsonParser.Feature.ALLOW_SINGLE_QUOTES, true);
        objectMapper.configure(JsonParser.Feature.ALLOW_UNQUOTED_CONTROL_CHARS, true);
    }

    /**
     * 转换javaBean为json
     * @param t
     * @param <T>
     * @return
     */
    public static <T> String serialize2Json(T t){
        String json = null;
        try {
            json = objectMapper.writeValueAsString(t);
        } catch (JsonProcessingException pe){
            logger.error("生成json数据异常，errMsg:{}", pe.getMessage());
            pe.printStackTrace();
        } catch (Exception e){
            logger.error("生成json数据未知异常,errMsg:{}",e.getMessage());
            e.printStackTrace();
        }
        return json;
    }

    /**
     * 将json string反序列化成对象
     * @param json
     * @param valueType
     * @return
     */
    public static <T> T serializa2Bean(String json, Class<T> valueType) {
        try {
            return objectMapper.readValue(json, valueType);
        } catch (JsonProcessingException pe) {
            logger.error("生成json数据异常，errMsg:{}", pe.getMessage());
            pe.printStackTrace();
        } catch (Exception e){
            logger.error("生成json数据未知异常,errMsg:{}",e.getMessage());
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 将json array反序列化为对象
     * @param json
     * @param typeReference
     * @return
     */
    @SuppressWarnings("unchecked")
    public static <T> T serializa2Bean(String json, TypeReference<T> typeReference) {
        try {
            return (T) objectMapper.readValue(json, typeReference);
        } catch (JsonProcessingException pe) {
            logger.error("生成json数据异常，errMsg:{}", pe.getMessage());
            pe.printStackTrace();
        } catch (Exception e){
            logger.error("生成json数据未知异常,errMsg:{}",e.getMessage());
            e.printStackTrace();
        }
        return null;
    }
}
