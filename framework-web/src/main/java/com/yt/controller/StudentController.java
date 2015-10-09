package com.yt.controller;

import com.yt.base.BaseAction;
import com.yt.dao.mongo.dao.StudentDao;
import com.yt.dao.mongotemplate.StudentDaoM;
import com.yt.entity.mongo.Student;
import com.yt.service.mongo.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
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
    @Autowired
    private StudentDaoM studentDaoM;

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
       List<Student> list= studentService.getMyList(15,Student.StudentSex.woman.getSex(),"张三6");
        try{
            for(int a=0;a<list.size();a++){
                System.out.println(list.get(a));
            }
        }catch (Exception e){
        System.out.println(e.getMessage());
        }
    }

    @RequestMapping(value ="/avg")
    public void avg(){
        try{
            studentService.getAvg("hehe");
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    @RequestMapping(value ="/getByIdM")
    public void getByIdM(int id){
        try{
           Student student= studentDaoM.getById(1);
            System.out.println(student);
            long count=studentDaoM.getCount();
            System.out.println(count);
         List<Student> students=  studentDaoM.getList();
            for(Student s:students){
                System.out.println(s);
            }
//            Criteria criteria=Criteria.where("_id").is(2);
//            Update update=Update.update("name","杨涛");
//            studentDaoM.update(criteria,update);
//            Student student1=studentDaoM.getById(id);
//            studentDaoM.remove(student1);
            studentDaoM.Aggreation(new Query());
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    @RequestMapping(value ="/groupby")
    public void groupby(){

        System.out.println("-----------------------");
        studentDaoM.groupBy();
        System.out.println("-----------------------");
    }

    @RequestMapping(value ="/findfield")
    public void findField(){
        studentDaoM.findField();
        System.out.println("-----------------------");
    }

    @RequestMapping(value ="/savesession")
    public void saveSession(HttpSession session,HttpServletRequest request){
        session.setAttribute("yt114", "heheeehehe");
        for(int a=0;a<=10;a++){
        session.setAttribute("lisi"+a,"li"+a);

        }
    }

    @RequestMapping(value ="/getsession")
    public void getSession(HttpSession session,HttpServletRequest request){
        for(int a=0;a<=10;a++){
            System.out.println(session.getAttribute("lisi" + a));
        }
    }

    @RequestMapping(value = "/removesession")
    public void removesession(HttpSession session){
        System.out.println(session.getAttribute("yt114"));
        session.removeAttribute("lisi1");
    }


    @RequestMapping(value ="/session")
    public void session(HttpServletRequest request,HttpSession session) {
        Random random=new Random();
        int int1= random.nextInt();
        System.out.println(int1);
        session.setAttribute("user","text"+int1);
    }

    @RequestMapping(value ="/session1")
    public String session1(HttpServletRequest request,HttpSession session,Model model) {
        model.addAttribute("user", session.getAttribute("user"));
        return "student/list";
    }


}
