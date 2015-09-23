package com.yt.dao.mongo.impl;

import com.mongodb.*;
import com.yt.dao.mongo.MongoDao;
import com.yt.util.JsonUtil;
import com.yt.util.Utils;
import com.yt.util.mongoUtil.MongoUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import javax.persistence.Basic;
import javax.transaction.Transactional;
import java.lang.reflect.*;
import java.util.Iterator;
import java.util.List;

@Repository
@Transactional
public class MongoDaoImpl<T> implements MongoDao<T> {

    private Class<T> entityClass;

    private int _id;


    @Autowired
    protected MongoTemplate mongoTemplate;

    public Class<T> getEntityClass() {
        this.entityClass = (Class<T>) ((ParameterizedType) this.getClass().getGenericSuperclass()).getActualTypeArguments()[0];
        // System.out.println("className: " + this.entityClass.getSimpleName());
        return entityClass;
    }

    /**
     * 保存一个对象到mongodb
     * mongo 的 insert()、save()  ，区别主要是：若存在主键，insert()  不做操作，而save() 则更改原来的内容为新内容。
     *
     * @param bean
     * @return
     */
    public T saveOrUpdate(T bean) {
        mongoTemplate.save(bean);
        return bean;
    }

    public T insert(T bean) {
            mongoTemplate.insert(bean);
        return bean;

    }






    public Long getTotal() {
        return  getDbCollection().count();
    }



    public void groupBy(String collectionname, DBObject... objs) {
        try {
            //$match，使用where去查询,查询字段name,￥eq等于,"hehe"的
            BasicDBObject where = new BasicDBObject(MongoUtils.$match, new BasicDBObject("name", new BasicDBObject(MongoUtils.$eq, "hehe")));
            //sql:select max(*),name from rb_user where name="hehe";
            //这个_id不是id字段,而是重新把$_id这个id字段武装成主键,mongodb
            //groupby以后会重新分表没有了主键,要重新设置主键,设置name字段为主键
            BasicDBObject groupby = new BasicDBObject(MongoUtils.$group, new BasicDBObject("_id", "$name").append("count1", new BasicDBObject("$sum", 1)));   //递增为1
            //大于0,这个必须放在groupby最后
            BasicDBObject having = new BasicDBObject(MongoUtils.$match, new BasicDBObject("count1", new BasicDBObject(MongoUtils.$gt, 0)));
            //sort,1表示升序,-1表示降序
            BasicDBObject orderBy = new BasicDBObject(MongoUtils.$orderBy, new BasicDBObject("count1", -1));
            //从第0页开始
            BasicDBObject skin = new BasicDBObject(MongoUtils.$skip, 0);
            //每页显示2条
            BasicDBObject limit = new BasicDBObject(MongoUtils.$limit, 2);
            // 2. {'$group':{'Id:''$author','count':{'$sum':1}}} 这样就会将作者按照名字排序，某个作者名字每出现一次，就会对每个作者的count加一。
            //注意使用了group语句以后显示字段的字段就失效了
            AggregationOutput output = mongoTemplate.getDb().getCollection("rb_user").aggregate(groupby, having, orderBy, skin, limit);
            Iterable<DBObject> result = output.results();
            Iterator<DBObject> results = result.iterator();
            while (results.hasNext()) {
                System.out.println(results.next());
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * 看看哥哥的方法写的巧不巧哈哈
     *
     * @param id
     * @return
     */
    public T getById(int id) {
            BasicDBObject where = new BasicDBObject(new BasicDBObject("_id", id));
            DBObject db= getDbCollection().findOne(where);
            String jsonStr=JsonUtil.toJson(db);
            T t=JsonUtil.fromJson(jsonStr,getEntityClass());
        return t;
    }

    /**
     * 批量修改
     * @param where
     * @param set
     */
    public void update(BasicDBObject where,BasicDBObject set) {
            getDbCollection().updateMulti(where,set);
    }


    /**
     * 分页查询
     * @param where
     * @return
     */
    public List<T> getList(BasicDBObject where) {
        try{
            DBCursor cursor = getDbCollection().find(where).skip(0).limit(10).sort(new BasicDBObject("age", -1));
            List<DBObject> list = cursor.toArray();
            for(DBObject db:list){
                System.out.println(db);
            }
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }

        return null;
    }


    public List<T> getList2(){
        BasicDBObject where = new BasicDBObject(MongoUtils.$match, new BasicDBObject("name", new BasicDBObject(MongoUtils.$eq, "hehe3")));
        AggregationOutput output = getDbCollection().aggregate(where);
        Iterable<DBObject> result = output.results();
        Iterator<DBObject> results = result.iterator();
        while (results.hasNext()) {
            System.out.println(results.next());
        }
        return null;
    }


    public void remove(int _id){
        BasicDBObject where=new BasicDBObject("_id",_id);
       getDbCollection().remove(where);
    }

    /**
     * 哥哥的代码写的很巧妙啊...
     * 获取mongo实体的名称
     *
     * @return
     */
    public String getCollectionName() {
        Document document = getEntityClass().getAnnotation(Document.class);
        String collectionName = null;
        if (Utils.CheckNotNull(document)) {
            collectionName = document.collection();
            if (!Utils.CheckNotNull(collectionName)) collectionName = getEntityClass().getName();
        } else {
            collectionName = getEntityClass().getName();
        }
        return collectionName;
    }

    public DBCollection getDbCollection() {
        return mongoTemplate.getDb().getCollection(getCollectionName());
    }


}
