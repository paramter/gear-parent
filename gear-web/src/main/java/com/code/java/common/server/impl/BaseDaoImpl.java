package com.code.java.common.server.impl;

import com.code.java.common.server.BaseDao;
import org.apache.log4j.Logger;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.List;

/**
 * hiberante通用接口实现
 * Created by 刘长申 on 2017/7/2.
 */
@Component
public class BaseDaoImpl<T> extends HibernateDaoSupport implements BaseDao<T>{

    private Logger logger  =  Logger.getLogger(BaseDaoImpl.class);

    @Autowired
    public void setSessionFactory0(SessionFactory sessionFactory){
        super.setSessionFactory(sessionFactory);
    }

    //实体对象
    private Class objCls;

    public BaseDaoImpl(){
        //获取数据实体类型
      /*  this.objCls = (Class<T>)((ParameterizedType)this.getClass().getGenericSuperclass()).getActualTypeArguments()[0];
        logger.debug("当前请求类实现类:"+ objCls.getName());*/
    }

    public void saveEntity(T t) {
        this.getHibernateTemplate().save(t);
    }

    public void updateEntity(T t) {
        this.getHibernateTemplate().update(t);
    }

    public void delEntity(T t) {
        this.getHibernateTemplate().delete(t);
    }

    public T loadEntity(Class<T> cls, Serializable id) {
        return this.getHibernateTemplate().get(cls, id);
    }

    public T loadEntityById(Serializable id) {
        return loadEntity(objCls, id);
    }

    public List<T> findAll(Class<T> cls) {
        return this.getHibernateTemplate().loadAll(cls);
    }

    public List<T> findAll() {
        return findAll(objCls);
    }
}
