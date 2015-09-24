package com.yt.dao.mongo.dao.impl;

import com.yt.dao.mongo.dao.StudentDao;
import com.yt.dao.mongo.impl.MongoDaoImpl;
import com.yt.entity.mongo.Student;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by user on 2015/9/24.
 */
@Repository
@Transactional
public class StudentDaoImpl extends MongoDaoImpl<Student> implements StudentDao{

}
