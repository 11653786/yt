package com.yt.service.mongotemplate.impl;

import com.yt.dao.student.StudentDaoM;
import com.yt.service.mongotemplate.StudentServiceM;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by user on 2015/9/25.
 */

@Service
@Transactional
public class StudentServiceImplM implements StudentServiceM {

    @Autowired
    private StudentDaoM studentDao;
}
