package com.yt.dao.base.mybatis;

import com.yt.dao.redis.RedisDao;

import java.util.List;
import java.util.Map;

/**
 * http://www.runoob.com/bootstrap/bootstrap-v2-layout.html
 * Created by user on 2015/8/11.
 */
public interface BaseDao<T> {

    public int insert(T t);

    public int insertSelective(T t);

    public T selectByPrimaryKey(int id);

    public int deleteByPrimaryKey(int id);

    public int updateByPrimaryKeySelective(T t);


}
