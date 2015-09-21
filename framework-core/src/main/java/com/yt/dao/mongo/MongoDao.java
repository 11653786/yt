package com.yt.dao.mongo;

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

    public List<T> getGroupList(String name);

    public void groupBy1(String collectionname);




}
