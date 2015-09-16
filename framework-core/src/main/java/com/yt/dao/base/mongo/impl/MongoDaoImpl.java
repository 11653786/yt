package com.yt.dao.base.mongo.impl;

import com.mongodb.DB;
import com.yt.dao.base.mongo.MongoDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.lang.reflect.ParameterizedType;
import java.util.Map;
import java.util.Set;

@Repository
@Transactional
public class MongoDaoImpl<T> implements MongoDao<T> {

    private Class<T> entityClass;


    @Autowired
    protected MongoTemplate mongoTemplate;



    public Class<T> getEntityClass() {
        this.entityClass = (Class<T>) ((ParameterizedType) this.getClass().getGenericSuperclass()).getActualTypeArguments()[0];
        System.out.println("className: " + this.entityClass.getSimpleName());
        return entityClass;
    }






    /**
     * 保存一个对象到mongodb
     *
     * @param bean
     * @return
     */
    public T save(T bean) {
        mongoTemplate.save(bean);
        return bean;
    }

    public void test() {
        Set<String> colls = this.mongoTemplate.getCollectionNames();
        for (String coll : colls) {
            System.out.println("CollectionName=" + coll);
        }
        DB db = this.mongoTemplate.getDb();
        System.out.println("db=" + db.toString());
    }


    public T findOneByWhere(Map<String,Object> map){
        Query mongodbQuery = new Query();
        T t=null;
        try{
            mongodbQuery.addCriteria(Criteria.where("name").is("mongo1啊啊"));
            Class<T> clazz=getEntityClass();
            t=  mongoTemplate.findOne(mongodbQuery,clazz);
        }
        catch(Exception e){
        System.out.println(e.getStackTrace()+","+e.getMessage());
        }
        return t;
    }



}
