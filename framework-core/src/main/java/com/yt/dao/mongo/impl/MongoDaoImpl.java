package com.yt.dao.mongo.impl;

import com.mongodb.DB;
import com.yt.dao.mongo.MongoDao;
import com.yt.util.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.ProjectionOperation;
import org.springframework.data.mongodb.core.aggregation.UnwindOperation;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.lang.reflect.ParameterizedType;
import java.util.List;
import java.util.Set;

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

    public List<T> getGroupList(String name) {
        return null;
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

    public void groupBy1(String collectionname){
        //project("name", "netPrice") // will generate {$project: {name: 1, netPrice: 1}}
        //选择所需要的字段
        ProjectionOperation project=Aggregation.project("");
        UnwindOperation project1=Aggregation.unwind("");
        Aggregation agg=Aggregation.newAggregation(Aggregation.project(""));



//        Aggregation agg;
//        agg = newAggregation(
//                project("frags","cat1","publishdate"),//挑选所需的字段
//                match(Criteria.where("frags.isnew").is(Boolean.TRUE).and("cat1")),//筛选符合条件的记录
//                unwind("frags"),//如果有MASTER-ITEM关系的表，需同时JOIN这两张表的，展开子项LIST，且是内链接，即如果父和子的关联ID没有的就不会输出
//
//                match(Criteria.where("frags.isnew").is(Boolean.TRUE)), group("cat1").count().as("updateCount")//增加COUNT为分组后输出的字段
//                        .last("publishdate").as("publishDate"),//增加publishDate为分组后输出的字段
//                project("publishDate","cat1","updateCount")//重新挑选字段
//                        .and("cat1").previousOperation()//为前一操作所产生的ID FIELD建立别名
//        );

    }






}
