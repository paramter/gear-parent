package com.code.java.common.server;

import java.io.Serializable;
import java.util.List;

/**
 * hibernate Dao层统一接口
 * Created by 刘长申 on 2017/7/2.
 */
public interface BaseDao<T> {
    /**
     * 新增实体内容
     * @param t
     */
    public void saveEntity(T t);

    /**
     * 修改实体内容
     * @param t
     */
    public void updateEntity(T t);

    /**
     * 删除实体内容
     * @param t
     */
    public void delEntity(T t);

    /**
     * 指定类名称及ID加载实体数据
     * @param cls
     * @param id
     * @return
     */
    public T loadEntity(final Class<T> cls, final Serializable id);

    /**
     * 使用当前调用类名称及ID加载实体数据
     * @param id
     * @return
     */
    public T loadEntityById(Serializable id);

    /**
     * 指定类名称加载全部数据
     * @param cls
     * @return
     */
    public List<T> findAll(final Class<T> cls);

    /**
     * 使用当前调用类名称加载全部数据
     * @return
     */
    public List<T> findAll();
}
