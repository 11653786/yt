package com.yt.dao;

import com.yt.dao.redis.RedisDao;
import com.yt.util.Page;

import java.util.List;
import java.util.Map;

/**
 * http://www.runoob.com/bootstrap/bootstrap-v2-layout.html
 * Created by user on 2015/8/11.
 */
public interface BaseDao<T> extends RedisDao {

    public void save(T t);

    public T get(int id);

    public T getByEntityId(T t);

    public List<T> getPage();

    public Page getPage1(Map<String,String> map);
}
