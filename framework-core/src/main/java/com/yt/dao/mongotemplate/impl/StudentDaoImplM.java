package com.yt.dao.mongotemplate.impl;

import com.yt.dao.mongo.impl.MongoTemplateDaoImpl;
import com.yt.dao.mongotemplate.StudentDaoM;
import com.yt.entity.mongo.Student;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by user on 2015/9/25.
 */
@Repository
@Transactional
public class StudentDaoImplM extends MongoTemplateDaoImpl<Student> implements StudentDaoM {
}
