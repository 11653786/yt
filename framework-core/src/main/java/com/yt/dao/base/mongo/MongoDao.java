package com.yt.dao.base.mongo;

import com.yt.entity.mongodb.ModelMongo;
import org.apache.poi.ss.formula.functions.T;

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

    public T findOneByWhere(Map<String,Object> map);
}
