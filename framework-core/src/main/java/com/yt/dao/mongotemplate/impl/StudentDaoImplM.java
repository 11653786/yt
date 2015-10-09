package com.yt.dao.mongotemplate.impl;

import com.mongodb.BasicDBList;
import com.mongodb.BasicDBObject;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.yt.dao.mongo.impl.MongoTemplateDaoImpl;
import com.yt.dao.mongotemplate.StudentDaoM;
import com.yt.entity.mongo.Student;
import com.yt.util.mongoUtil.MongoUtils;
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

}
