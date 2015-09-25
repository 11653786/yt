package com.yt.dao.mongo;

import com.mongodb.BasicDBObject;
import com.mongodb.DBCollection;
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

    public T saveOrUpdate(T bean);

    public T insert(T bean);


    public T getById(int _id);

    public  long getTotal();




    public void groupBy(String collectionname,DBObject...obj);


    /**
     * 前面是查询的条件,后面是要修改的数据
     * @param where
     * @param set
     */
    public void update(BasicDBObject where,BasicDBObject set);

    public List<T> getList(BasicDBObject where);

    public void remove(int _id);

    public List<T> getList2();

    public String getCollectionName();

    public DBCollection getDbCollection();


}
