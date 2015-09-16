package com.yt.dao.base.redis;

import java.util.Map;

/**
 * Created by user on 2015/8/13.
 */
public interface RedisDao {

    /**
     * ɾ��
     * ����string���������gsonת����json�ڴ�
     * @param keyValue
     * @return
     */
    public void redisSave(Map<String, String> keyValue);


    public boolean redisRemove(String key);

    /**
     * �жϵ�ǰ key�Ƿ����
     * @param key
     * @return
     */
    public boolean exists(String key);

    public void redisRemoveAll(String... objs);
}
