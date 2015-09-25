package com.yt.dao.mongo.impl;

import com.mongodb.BasicDBObject;
import com.mongodb.DBCollection;
import com.mongodb.DBObject;
import com.yt.dao.mongo.MongoTemplateDao;
import com.yt.entity.mongo.Student;
import com.yt.util.Utils;
import org.apache.poi.ss.formula.functions.T;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.lang.reflect.ParameterizedType;
import java.util.List;

/**
 * Created by user on 2015/9/25.
 */
@Repository
@Transactional
public class MongoTemplateDaoImpl<T> implements MongoTemplateDao<T> {

    private Class<T> entityClass;
    private int _id;
    @Autowired
    protected MongoTemplate mongoTemplate;


    public Class<T> getEntityClass() {
        this.entityClass = (Class<T>) ((ParameterizedType) this.getClass().getGenericSuperclass()).getActualTypeArguments()[0];
        // System.out.println("className: " + this.entityClass.getSimpleName());
        return entityClass;
    }


    public T saveOrUpdate(T bean) {
        mongoTemplate.save(bean);
        return bean;
    }

    public T insert(T bean) {
        mongoTemplate.insert(bean);
        return bean;
    }

    public T getById(int _id) {
        Query query=new Query();
        Criteria where=new Criteria();
        where.where("_id").is(_id);
        query.addCriteria(where);
      return mongoTemplate.findOne(query, getEntityClass());
    }

    public long getCount() {
     return mongoTemplate.count(new Query(),getEntityClass());
    }

    public void groupBy(String collectionname, DBObject... obj) {

    }

    public void update(Criteria criteria,Update update) {
        mongoTemplate.updateMulti(new Query(criteria) ,update,getEntityClass());
    }

    public List<T> getList() {
        Query query=new Query();
       List<T> list= mongoTemplate.find(query,getEntityClass());
        return list;
    }

    public void remove() {

    }
}
