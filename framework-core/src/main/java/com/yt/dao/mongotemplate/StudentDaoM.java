package com.yt.dao.mongotemplate;

import com.yt.dao.mongo.MongoTemplateDao;
import com.yt.entity.mongo.Student;

/**
 * Created by user on 2015/9/25.
 */
public interface StudentDaoM extends MongoTemplateDao<Student>{

    public void groupBy1();

    public void findField();
}
