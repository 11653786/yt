package com.yt.dao.base.mongo.impl;

import com.mongodb.DB;
import com.yt.dao.base.mongo.MongoDao;
import com.yt.entity.mongodb.ModelMongo;
import com.yt.util.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;

import javax.persistence.PrePersist;
import javax.transaction.Transactional;
import java.lang.reflect.ParameterizedType;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Repository
@Transactional
public class MongoDaoImpl<T> implements MongoDao<T> {

    private Class<T> entityClass;

    private int _id;


    @Autowired
    protected MongoTemplate mongoTemplate;

    public Class<T> getEntityClass() {
        this.entityClass = (Class<T>) ((ParameterizedType) this.getClass().getGenericSuperclass()).getActualTypeArguments()[0];
        System.out.println("className: " + this.entityClass.getSimpleName());
        return entityClass;
    }

    /**
     * 保存一个对象到mongodb
     * mongodb 的 insert()、save()  ，区别主要是：若存在主键，insert()  不做操作，而save() 则更改原来的内容为新内容。
     * @param bean
     * @return
     */
    public T save(T bean) {
        mongoTemplate.save(bean);
        return bean;
    }

    public T insertEntity(T bean) {

        try{
            mongoTemplate.insert(bean);
        }
        catch(Exception e){
            System.out.println(e.getStackTrace()+","+e.getMessage());
        }
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




    public T getById(int _id) {
        Query query=new Query();
        Criteria criteria=new Criteria();
        criteria.where("_id").is(_id);
        query.addCriteria(criteria);
      return   mongoTemplate.findOne(query,getEntityClass());
    }

    public  Long getTotal(Query query){
        long total= mongoTemplate.count(query,getEntityClass());
        System.out.println(total);
        return total;
    }

    public void update(Query query,Update update){
        mongoTemplate.updateFirst(query,update,getEntityClass());

    }

    public void remove(T bean,String collectionName) {
        if(!Utils.CheckNotNull(collectionName)){
            mongoTemplate.remove(bean);
        }else{
            mongoTemplate.getDb().getName();
          //  mongoTemplate.remove();
        }
    }


    public List<T> getList(Query query) {
        return mongoTemplate.find(query,getEntityClass());
    }


}
