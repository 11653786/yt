package com.yt.dao;

import com.yt.dao.redis.RedisDao;

import java.util.List;

/**
 * http://www.runoob.com/bootstrap/bootstrap-v2-layout.html
 * Created by user on 2015/8/11.
 */
public interface BaseDao<T> extends RedisDao {

    public void save(T t);

    public T get(int id);

    public T getByEntityId(T t);

    public List<T> getPage();
}
