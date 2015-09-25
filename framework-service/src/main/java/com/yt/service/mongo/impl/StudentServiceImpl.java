package com.yt.service.mongo.impl;

import com.mongodb.BasicDBList;
import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import com.yt.dao.mongo.dao.StudentDao;
import com.yt.dao.mongo.dao.impl.StudentDaoImpl;
import com.yt.entity.mongo.Student;
import com.yt.service.mongo.StudentService;
import com.yt.util.Utils;
import com.yt.util.mongoUtil.MongoUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by user on 2015/9/24.
 */
@Service
@Transactional
public class StudentServiceImpl  implements StudentService{

    @Resource
    private StudentDao studentDao;

    public List<Student> getMyList(Integer age,String sex,String name){
        BasicDBObject dbObject=new BasicDBObject();
        BasicDBList list1=new BasicDBList();
        if(Utils.CheckNotNull(age)){
            list1.add(new BasicDBObject("age",new BasicDBObject(MongoUtils.$gt,age)));

        }
        if(Utils.CheckNotNull(sex)){
            list1.add(new BasicDBObject("sex",new BasicDBObject(MongoUtils.$eq,sex)));
        }
        dbObject.put(MongoUtils.$and, list1);

        BasicDBList list2=new BasicDBList();
        list2.add(new BasicDBObject("name", new BasicDBObject(MongoUtils.$ne, "张三6")));
        list2.add(new BasicDBObject("name", new BasicDBObject(MongoUtils.$ne, "张三3")));
        BasicDBObject dbObject2=new BasicDBObject();
        dbObject2.put(MongoUtils.$and, list2);

        //in查询
        BasicDBList inList=new BasicDBList();
        inList.add(24);
        inList.add(15);
        //in的条件
        BasicDBObject in=new BasicDBObject();
        in.put("age", new BasicDBObject(MongoUtils.$in, inList));
        BasicDBList finalList=new BasicDBList();
        finalList.add(dbObject);
        finalList.add(dbObject2);
        BasicDBObject finalObject=new BasicDBObject();
        finalObject.put(MongoUtils.$and, finalList);

        //in的查询and where 4个条件
        BasicDBList list4=new BasicDBList();
        list4.add(finalObject);
        list4.add(in);
        BasicDBObject finals=new BasicDBObject();
        finals.put(MongoUtils.$and,list4);

        return  studentDao.getList(finals);

    }

}
