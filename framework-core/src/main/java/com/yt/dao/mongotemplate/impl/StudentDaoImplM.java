package com.yt.dao.mongotemplate.impl;

import com.mongodb.BasicDBList;
import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import com.yt.dao.mongo.impl.MongoTemplateDaoImpl;
import com.yt.dao.mongotemplate.StudentDaoM;
import com.yt.entity.mongo.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.mapreduce.GroupBy;
import org.springframework.data.mongodb.core.mapreduce.GroupByResults;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * Created by user on 2015/9/25.
 */
@Repository
@Transactional
public class StudentDaoImplM extends MongoTemplateDaoImpl<Student> implements StudentDaoM {


    @Autowired
    private MongoTemplate mongoTemplate;

    public void groupBy1() {
        String reduce = "function(doc, aggr){aggr.count += 1;}";
        Query query = Query.query(Criteria.where("age").exists(true));
        //显示age字段,,查询的条件是query,重新组建count字段,初始值为0，递增规则
        DBObject result = mongoTemplate.getCollection("student").group(new BasicDBObject("age", 1), query.getQueryObject(),new BasicDBObject("count", 0), reduce);
        Map map = result.toMap();
        System.out.println(map);
    }

    public void findField() {
        Query query=new Query();
        query.with(new Sort(new Sort.Order(Sort.Direction.ASC, "_id")));
        query.skip(0);
        query.limit(10);
        Criteria criteria=Criteria.where("name").is("张三");
        query.addCriteria(criteria);
       List<Student> list= mongoTemplate.find(query, Student.class);

        for(int a=0;a<list.size();a++){
            System.out.println(list.get(a));
        }
    }
}
