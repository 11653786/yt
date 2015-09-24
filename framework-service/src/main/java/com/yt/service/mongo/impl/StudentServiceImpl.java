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
        dbObject.put(MongoUtils.$and,list1);


        BasicDBList list2=new BasicDBList();
        if(Utils.CheckNotNull(name)){

        BasicDBObject basic=new BasicDBObject("name",new BasicDBObject(MongoUtils.$ne,name));
            list2.add(basic);
        }

        BasicDBList list3=new BasicDBList();
        list3.add(dbObject);
        list3.add(list2);
        BasicDBObject finals=new BasicDBObject();
        finals.put(MongoUtils.$and,list3);
        return  studentDao.getList(finals);

    }

}
