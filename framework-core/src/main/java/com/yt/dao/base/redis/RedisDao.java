package com.yt.dao.base.redis;

import java.util.Map;

/**
 * Created by user on 2015/8/13.
 */
public interface RedisDao {

    /**
     * 删除
     * 存入string类型最好用gson转换成json在存
     * @param keyValue
     * @return
     */
    public void redisSave(Map<String, String> keyValue);


    public boolean redisRemove(String key);

    /**
     * 判断当前 key是否存在
     * @param key
     * @return
     */
    public boolean exists(String key);

    public void redisRemoveAll(String... objs);
}
