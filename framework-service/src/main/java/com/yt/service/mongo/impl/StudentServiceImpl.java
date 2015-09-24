package com.yt.service.mongo.impl;

import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import com.yt.dao.mongo.dao.impl.StudentDaoImpl;
import com.yt.entity.mongo.Student;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by user on 2015/9/24.
 */
@Service
@Transactional
public class StudentServiceImpl extends StudentDaoImpl{

    public List<Student> getMyList(){
        BasicDBObject dbObject=new BasicDBObject();

       return  super.getList(dbObject);
    }

}
