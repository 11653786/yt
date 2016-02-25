package com.yt.dao.base.mybatis.impl;

import com.yt.dao.base.mybatis.BaseDao;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.lang.reflect.ParameterizedType;
import java.util.List;
import java.util.Map;

/**
 * Created by user on 2015/8/11.
 */
@Repository
@Transactional
public class BaseDaoImpl<T> implements BaseDao<T> {


    private String packageName="com.yt.entity.";
    private String houzhuiMapper="Mapper";


    @Resource
    private SqlSession session;


    private Class<T> entityClass;


    private String mapperNamespace;



    public BaseDaoImpl() {

    }

    public String getEntityClass() {
        this.entityClass = (Class<T>) ((ParameterizedType) this.getClass().getGenericSuperclass()).getActualTypeArguments()[0];
        System.out.println("className: " + this.entityClass.getSimpleName());
        return entityClass.getSimpleName();
    }

    public String setNameSpace(){
        this.mapperNamespace=packageName+getEntityClass()+houzhuiMapper;
        return mapperNamespace;
    }

    public void save(T t) {
        //这里是名空间加上方法民称就行了
        session.insert(setNameSpace()+".save",t);
    }

    public T get(int id) {
        return  session.selectOne(setNameSpace()+".get",id);
    }

    public T getByEntityId(T t) {
        return  session.selectOne(setNameSpace()+".getByEntityId",t);
    }

    public List<T> getPage() {
        return  session.selectList(setNameSpace() + ".getPage");
    }

    public List<T> getPage(Map<String, Object> map) {
        List<T>  sessionList= session.selectList(setNameSpace() + ".getPage",map);
        return sessionList;
    }


}
