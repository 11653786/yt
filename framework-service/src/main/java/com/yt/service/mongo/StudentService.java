package com.yt.service.mongo;

import com.yt.dao.mongo.dao.StudentDao;
import com.yt.entity.mongo.Student;

import java.util.List;

/**
 * Created by user on 2015/9/24.
 */
public interface StudentService{

    public List<Student> getMyList(Integer age,String sex,String name);

    public void getAvg(String fieldName);
}
