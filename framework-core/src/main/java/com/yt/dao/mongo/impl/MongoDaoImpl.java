package com.yt.dao.mongo.impl;

import com.mongodb.*;
import com.yt.dao.mongo.MongoDao;
import com.yt.util.Utils;
import com.yt.util.mongoUtil.MongoUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.*;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.lang.reflect.ParameterizedType;
import java.rmi.UnknownHostException;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import static org.springframework.data.mongodb.core.aggregation.Aggregation.*;

@Repository
@Transactional
public class MongoDaoImpl<T> implements MongoDao<T> {

    private Class<T> entityClass;

    private int _id;


    @Autowired
    protected MongoTemplate mongoTemplate;

    public Class<T> getEntityClass() {
        this.entityClass = (Class<T>) ((ParameterizedType) this.getClass().getGenericSuperclass()).getActualTypeArguments()[0];
        System.out.println("className: " + this.entityClass.getSimpleName());
        return entityClass;
    }

    /**
     * 保存一个对象到mongodb
     * mongo 的 insert()、save()  ，区别主要是：若存在主键，insert()  不做操作，而save() 则更改原来的内容为新内容。
     * @param bean
     * @return
     */
    public T saveEntity(T bean) {
        mongoTemplate.save(bean);
        return bean;
    }

    public T insertEntity(T bean) {

        try{
            mongoTemplate.insert(bean);
        }
        catch(Exception e){
            System.out.println(e.getStackTrace()+","+e.getMessage());
        }
        return bean;

    }

    public void test() {
        Set<String> colls = this.mongoTemplate.getCollectionNames();
        for (String coll : colls) {
            System.out.println("CollectionName=" + coll);
        }
        DB db = this.mongoTemplate.getDb();
        System.out.println("db=" + db.toString());
    }




    public T getById(int _id) {
        Query query=new Query();
        Criteria criteria=new Criteria();
        criteria.where("_id").is(_id);
        query.addCriteria(criteria);
      return   mongoTemplate.findOne(query,getEntityClass());
    }

    public  Long getTotal(Query query){
        long total= mongoTemplate.count(query,getEntityClass());
        System.out.println(total);
        return total;
    }

    public void update(Query query,Update update){
        mongoTemplate.updateFirst(query, update, getEntityClass());
    }

    public void remove(T bean,String collectionName) {
        if(!Utils.CheckNotNull(collectionName)){
            mongoTemplate.remove(bean);
        }else{
            mongoTemplate.remove(bean, collectionName);
        }
    }


    public List<T> getList(Query query,Integer page,Integer pageSize) {

        if(Utils.CheckNotNull(page) && Utils.CheckNotNull(pageSize)){
            //从第page跳开始查
            query.skip(page);
            //每页pageSize条
            query.limit(pageSize);
        }
        return mongoTemplate.find(query,getEntityClass());
    }

    public void groupBy(String collectionname,DBObject...objs){
        try{
            //$match，使用where去查询,查询字段name,￥eq等于,"hehe"的
            BasicDBObject where=new BasicDBObject(MongoUtils.$match,new BasicDBObject("name",new BasicDBObject(MongoUtils.$eq,"hehe")));
            //sql:select max(*),name from rb_user where name="hehe";
            //这个_id不是id字段,而是重新把$_id这个id字段武装成主键,mongodb
            //groupby以后会重新分表没有了主键,要重新设置主键,设置name字段为主键
            BasicDBObject groupby=new BasicDBObject(MongoUtils.$group,new BasicDBObject("_id","$name").append("count", new BasicDBObject("$sum",1)));   //递增为1
            //大于0,这个必须放在groupby最后
            BasicDBObject having=new BasicDBObject(MongoUtils.$match,new BasicDBObject("count",new BasicDBObject(MongoUtils.$gt,0)));
            //sort,1表示升序,-1表示降序
            BasicDBObject orderBy=new BasicDBObject(MongoUtils.$orderBy,new BasicDBObject("count",-1));
            //从第0页开始
            BasicDBObject skin=new BasicDBObject(MongoUtils.$skip,0);
            //每页显示2条
            BasicDBObject limit=new BasicDBObject(MongoUtils.$limit,2);


           // 2. {'$group':{'Id:''$author','count':{'$sum':1}}} 这样就会将作者按照名字排序，某个作者名字每出现一次，就会对每个作者的count加一。
            //注意使用了group语句以后显示字段的字段就失效了
            AggregationOutput output=mongoTemplate.getDb().getCollection("rb_user").aggregate(groupby,having,orderBy,skin,limit);
            Iterable<DBObject> result =output.results();
            Iterator<DBObject> results=result.iterator();
            while(results.hasNext()){
                System.out.println(results.next());
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }






}
