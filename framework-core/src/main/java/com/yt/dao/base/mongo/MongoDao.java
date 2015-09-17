package com.yt.dao.base.mongo;

import com.yt.entity.mongodb.ModelMongo;
import org.apache.poi.ss.formula.functions.T;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;

import java.util.List;
import java.util.Map;

/**
 * Created by user on 2015/9/14.
 */
public interface MongoDao<T> {

    /**
     * 保存一个对象到mongodb
     *
     * @param bean
     * @return
     */

    public T save(T bean);

    public T insertEntity(T bean);

    public void test();

    public T getById(int _id);

    public  Long getTotal(Query query);

    public List<T> getList(Query query);

    public void update(Query query,Update update);

    public void remove(T bean,String collectionName);





}
