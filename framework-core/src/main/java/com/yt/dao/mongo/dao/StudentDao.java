package com.yt.dao.mongo.dao;

import com.mongodb.BasicDBList;
import com.mongodb.BasicDBObject;
import com.yt.dao.mongo.MongoDao;
import com.yt.entity.mongo.Student;
import org.springframework.data.mongodb.core.mapreduce.GroupBy;
import org.springframework.data.mongodb.core.mapreduce.GroupByResults;

/**
 * Created by user on 2015/9/24.
 */
public interface StudentDao extends MongoDao<Student>{



}
