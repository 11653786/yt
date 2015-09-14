package com.yt.dao.mongo;

import org.apache.poi.ss.formula.functions.T;

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

    public void test();
}
