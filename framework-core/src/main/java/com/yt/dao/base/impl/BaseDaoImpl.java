package com.yt.dao.base.impl;

import com.google.gson.reflect.TypeToken;
import com.yt.dao.base.BaseDao;
import com.yt.dao.redis.impl.RedisDaoImpl;
import com.yt.util.JsonUtil;
import org.apache.ibatis.session.SqlSession;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.lang.reflect.ParameterizedType;
import java.util.List;
import java.util.Map;

/**
 * Created by user on 2015/8/11.
 */
@Repository
@Transactional
public class BaseDaoImpl<T> extends RedisDaoImpl implements BaseDao<T> {


    private String packageName="com.yt.entity.";
    private String houzhuiMapper="Mapper";

    long redisSaveTime=1000;

    @Resource
    private SqlSession session;


    private Class<T> entityClass;


    private String mapperNamespace;



    public BaseDaoImpl() {

    }

    public String getEntityClass() {
        this.entityClass = (Class<T>) ((ParameterizedType) this.getClass().getGenericSuperclass()).getActualTypeArguments()[0];
        System.out.println("className: " + this.entityClass.getSimpleName());
        return entityClass.getSimpleName();
    }

    public String setNameSpace(){
        this.mapperNamespace=packageName+getEntityClass()+houzhuiMapper;
        return mapperNamespace;
    }

    public void save(T t) {
        //这里是名空间加上方法民称就行了
        session.insert(setNameSpace()+".save",t);
    }

    public T get(int id) {
        return  session.selectOne(setNameSpace()+".get",id);
    }

    public T getByEntityId(T t) {
        return  session.selectOne(setNameSpace()+".getByEntityId",t);
    }

    public List<T> getPage() {
        List<T> list= (List<T>) super.getRedisTemplate().execute(new RedisCallback<List<T>>() {
            public List<T> doInRedis(RedisConnection redisConnection) throws DataAccessException {

                RedisSerializer<String> serializer = getRedisSerializer();
                byte[] key  = serializer.serialize("name1s");
                byte[] value = redisConnection.get(key);
                // redisConnection.exists(key);
                if(value==null){
                    //从数据中查询
                    List<T>  sessionList= session.selectList(setNameSpace() + ".getPage");
                    System.out.println("session....");
                    //用谷歌的gson包转换成tring,在把string序列化成byte[]
                    String sessionListStr=JsonUtil.toJson(sessionList);
                    byte[] values=serializer.serialize(sessionListStr);
                    //redis保存
                    redisConnection.set(key,values);
                    //redis设置超时时间,这里经典的话可以,计算距离每天凌晨12点的时候然后进行计算保存时间
                    redisConnection.expire(key,redisSaveTime); //单位秒
                    return sessionList;
                }else{      //如果缓存中有的话
                    byte[] redisbyte=value;
                    System.out.println("redis....");
                    String redisListStr=serializer.deserialize(redisbyte);
                    List<T> redisList = JsonUtil.fromJson(redisListStr, new TypeToken<List<T>>() {}.getType());
                    return  redisList;
                }
            }
        });
        return list;
    }



    public List<T> getPage(Map<String, Object> map) {
        List<T>  sessionList= session.selectList(setNameSpace() + ".getPage",map);
        return sessionList;
    }


}
