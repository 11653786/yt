package com.yt.dao.impl;

import com.google.gson.reflect.TypeToken;
import com.yt.dao.BaseDao;
import com.yt.dao.redis.impl.RedisDaoImpl;
import com.yt.util.JsonUtil;
import com.yt.util.Page;
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
public class BaseDaoImpl<T> extends RedisDaoImpl implements BaseDao<T>{


    private String packageName="com.yt.entity.";
    private String houzhuiMapper="Mapper";

    long redisSaveTime=10;

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
        //���������ռ���Ϸ�����ƾ�����
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
                    //�������в�ѯ
                    List<T>  sessionList= session.selectList(setNameSpace() + ".getPage");
                    System.out.println("session....");
                    //�ùȸ��gson��ת����tring,�ڰ�string���л���byte[]
                    String sessionListStr=JsonUtil.toJson(sessionList);
                    byte[] values=serializer.serialize(sessionListStr);
                    //redis����
                    redisConnection.set(key,values);
                    //redis���ó�ʱʱ��,���ﾭ��Ļ�����,�������ÿ���賿12���ʱ��Ȼ����м��㱣��ʱ��
                    redisConnection.expire(key,redisSaveTime); //��λ��
                    return sessionList;
                }else{      //����������еĻ�
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

    public Page getPage1(Map<String,String> map){
        List<T>  list= session.selectList(setNameSpace() + ".getPage1",map);
        Page pages=new Page();
        pages.setPage(Integer.valueOf(map.get("page")));
        pages.setPageSize(Integer.valueOf(map.get("pageSize")));
        pages.setList(list);
        return pages;
    }



}
