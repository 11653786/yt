package com.yt.dao.mongo;

import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import com.yt.dao.base.redis.RedisDao;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;

import java.util.List;

/**
 * Created by user on 2015/9/14.
 */
public interface MongoDao<T>{

    /**
     * 保存一个对象到mongodb
     *
     * @param bean
     * @return
     */

    public T saveEntity(T bean);

    public T insertEntity(T bean);

    public void test();

    public T getById(int _id);

    public  Long getTotal(Query query);

    public List<T> getList(Query query,Integer page,Integer pageSize);

    public void update(Query query,Update update);

    public void remove(T bean,String collectionName);


    public void groupBy(String collectionname,DBObject...obj);

    public T getDboejctById(int id);

    /**
     * 前面是查询的条件,后面是要修改的数据
     * @param where
     * @param set
     */
    public void updateDBObject(BasicDBObject where,BasicDBObject set);

    public List<T> getListDbObject(BasicDBObject where);

    public void deleteByIdDB(int _id);

    public List<T> getList2();



}
