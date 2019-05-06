package com.myspring.controllers;
import com.myspring.beans.CampusBean;
import com.myspring.entities.Advisor;
import com.myspring.entities.Comment;
import com.myspring.entities.Practice;
import com.myspring.entities.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Controller
public class MainController {

    @Autowired
    CampusBean campusBean;
    public static Long userID;

    @RequestMapping(value = {"index", "/","home"})
    public ModelAndView indexPage(){
        ModelAndView mw = new ModelAndView("index");
        return mw;
    }

    @RequestMapping(value = "/logining", method = RequestMethod.POST)
    public ModelAndView logining(@RequestParam(name = "login") String login,
                                 @RequestParam(name = "password") String password){
        ModelAndView mw = new ModelAndView("teachersPages/teachers_firstPage");
        ModelAndView studentMw = new ModelAndView("studentPages/studentFirstPage");
        List<Advisor> advisorList  =  campusBean.getAllAdvisors();
        List<Student> studentList  =  campusBean.getAllStudent();
        int lLogin = Integer.parseInt(login);

        for (Student student:studentList) {
            if (student.getLogin()==lLogin){
                if (student.getPassword().equals(password)){
                    List<Practice> arr = campusBean.getAllPracticeByStudentId(student.getStudent_id());
                    studentMw.addObject("practiceArray",arr);
                    studentMw.addObject("student",student);
                    userID=student.getStudent_id();
                    return studentMw;
                } } }

        for (Advisor advisor:advisorList) {
            if (advisor.getLogin()==lLogin){
                if (advisor.getPassword().equals(password)){
                    mw.addObject("advisor",advisor);
                    return mw;
                } } }

        return indexPage();
    }

    @RequestMapping(value = "/teachersPage", method = RequestMethod.GET)
    public ModelAndView teachersPage() {
        ModelAndView mw = new ModelAndView("teachersPages/teachers_firstPage");
        return mw;
    }

    @RequestMapping(value = "/teachers_studentListPage", method = RequestMethod.GET)
    public ModelAndView teachersStudents() {
        ModelAndView mw = new ModelAndView("teachersPages/teachers_studentlistPage");
        return mw;
    }

    @RequestMapping(value = "/addStudent", method = RequestMethod.GET)
    public ModelAndView addStudent() {
        ModelAndView mw = new ModelAndView("teachersPages/teachers_addStudentPage");
        return mw;
    }

    @RequestMapping(value = "/studentPage", method = RequestMethod.GET)
    public ModelAndView studentPage() {
        ModelAndView mw = new ModelAndView("teachersPages/individual_StudentPage");
        return mw;
    }

    @RequestMapping(value = "/studentFirstPage", method = RequestMethod.GET)
    public ModelAndView studentFirstPage() {
        ModelAndView mw = new ModelAndView("studentPages/studentFirstPage");
        Student student = campusBean.getStudentByID(userID);
        List<Practice> arr = campusBean.getAllPracticeByStudentId(student.getStudent_id());
        mw.addObject("practiceArray",arr);
        mw.addObject("student",student);

        return mw;
    }

    @RequestMapping(value = "/studentPracticePage", method = RequestMethod.GET)
    public ModelAndView studentPracticePage(@RequestParam (name = "practiceID") Long practiceID ) throws ParseException {
        ModelAndView mw = new ModelAndView("studentPages/PracticePage");
        Practice practice = campusBean.getPracticeByID(practiceID);
        Student currentStudent=campusBean.getStudentByID(userID);
        List<Practice> arr = campusBean.getAllPracticeByStudentId(userID);
        String stDate =getDate();

        mw.addObject("practiceArray",arr);
        mw.addObject("practice",practice);
        mw.addObject("student",currentStudent);
        mw.addObject("currentDate",stDate);
        return mw;
    }
    @RequestMapping(value = "/studentAddPracticePage", method = RequestMethod.GET)
    public ModelAndView studentAddPracticePage() {
        ModelAndView mw = new ModelAndView("studentPages/add_Practice");
        return mw;
    }


    @RequestMapping(value = "/add_real_practice", method = RequestMethod.GET)
    public ModelAndView add_practice(
            @RequestParam(name = "fullcomment") String fullcomment,
            @RequestParam (name = "userID")     int userlLogin,
            @RequestParam (name = "practiceID") Long practiceID
    ) throws ParseException {
        ModelAndView mw = new ModelAndView("studentPages/studentFirstPage");
        String stDate =getDate();

        Comment comment = new Comment();
        comment.setComment(fullcomment);
        comment.setLogin(userlLogin);
        comment.setCommentDate(java.sql.Date.valueOf(stDate));
        Practice practice = campusBean.getPracticeByID(practiceID);
        campusBean.addComment(comment);
        System.out.println(practice.toString());
        System.out.println(comment.toString());
        return mw;
    }

    public String getDate(){
        Calendar cal = Calendar. getInstance();
        Date date = cal.getTime();
        DateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd");
        String stDate =dateFormat.format(date);
        return stDate;
    }
}
