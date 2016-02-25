package com.yt.dao.base.mybatis;

import com.yt.dao.redis.RedisDao;

import java.util.List;
import java.util.Map;

/**
 * http://www.runoob.com/bootstrap/bootstrap-v2-layout.html
 * Created by user on 2015/8/11.
 */
public interface BaseDao<T>{

    public void save(T t);

    public T get(int id);

    public T getByEntityId(T t);

    public List<T> getPage(Map<String,Object> map);


}
