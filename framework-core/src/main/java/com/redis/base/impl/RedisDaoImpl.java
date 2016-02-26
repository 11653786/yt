package com.redis.base.impl;

import com.redis.base.RedisDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.stereotype.Repository;

import java.util.Map;

/**
 * Created by user on 2015/8/13.
 */
@Repository
@Deprecated
public class RedisDaoImpl implements RedisDao {
    @Autowired
    private RedisTemplate redisTemplate;


    public RedisTemplate getRedisTemplate() {
        return redisTemplate;
    }

    public void setRedisTemplate(RedisTemplate redisTemplate) {
        this.redisTemplate = redisTemplate;
    }


    /**
     * 获取 key
     * <br>------------------------------<br>
     */
    protected RedisSerializer<String> getRedisSerializer() {
        return redisTemplate.getStringSerializer();
    }

    public void redisSave(Map<String,String> keyValue) {

        for (Map.Entry<String, String> entry : keyValue.entrySet()) {
            String key=entry.getKey();
            String value=entry.getValue();
            System.out.println("Key = " + entry.getKey() + ", Value = " + entry.getValue());
            byte[] bytekey= getRedisSerializer().serialize(key);
            byte[] bytevalue=getRedisSerializer().serialize(value);
        }

    }

    public boolean redisRemove(String key) {
        //如果存在
        if (exists(key)) {
            redisTemplate.delete(key);
            return true;
        }
        return false;
    }

    public boolean exists(String key) {
        return redisTemplate.hasKey(key);
    }

    public void redisRemoveAll(String... objs) {
        if (objs == null || objs.length == 0) {
            for (String str : objs) {
                redisRemove(str);
            }
        }
    }
}
