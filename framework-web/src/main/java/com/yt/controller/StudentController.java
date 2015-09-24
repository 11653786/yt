package com.yt.controller;

import com.yt.base.BaseAction;
import com.yt.dao.mongo.dao.StudentDao;
import com.yt.entity.mongo.Student;
import com.yt.service.mongo.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Random;

/**
 * Created by user on 2015/9/24.
 */
@Controller
@RequestMapping(value="api/student")
public class StudentController extends BaseAction{


    @Autowired
    private StudentDao studentDao;
    @Autowired
    private StudentService studentService;

    @RequestMapping(value ="/save")
    public void save(){
        for(int a=0;a<10;a++){
            Student student=new Student();
            Long total=studentDao.getTotal();
            student.set_id(total.intValue());
            Random random=new Random();
            student.setAge(random.nextInt(20));
            student.setName("张三" + random.nextInt(10));
            if(a%2==0){
                student.setSex(Student.StudentSex.man.getSex());
            }else{
                student.setSex(Student.StudentSex.woman.getSex());
            }
            studentDao.insert(student);
        }
    }

    @RequestMapping(value ="/getlist")
    public void getlist(){
       List<Student> list= studentService.getMyList();
        for(Student s:list){
        System.out.println(s.toString());
        }
    }

}
