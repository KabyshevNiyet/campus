package com.myspring.controllers;
import com.myspring.beans.CampusBean;
import com.myspring.entities.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Controller
public class MainController {

    @Autowired
    CampusBean campusBean;
    private static Long userID;
    private static Integer userLogin;




    @RequestMapping(value = {"index", "/","home"})
    public ModelAndView indexPage(){
        ModelAndView mw = new ModelAndView("index");
        userID=null;
        userLogin=null;
        return mw;
    }

    @RequestMapping(value = "/logining", method = RequestMethod.POST)
    public ModelAndView logining(@RequestParam(name = "login") String login,
                                 @RequestParam(name = "password") String password){
        ModelAndView mw = new ModelAndView("teachersPages/teachers_firstPage");
        ModelAndView studentMw = new ModelAndView("studentPages/studentFirstPage");
        List<Advisor> advisorList  =  campusBean.getAllAdvisors();
        int lLogin = Integer.parseInt(login);
        List<Student> studentList  =  campusBean.getAllStudent();

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
                    userID=advisor.getId();
                    userLogin=advisor.getLogin();

                    mw.addObject("advisor",advisor);
                    List<Group> arr = campusBean.getallGroupByAdviserID(advisor.getId());
                       for (Group group: arr) {
                        List<Student> array = new ArrayList<Student>();
                        for (Student stud: studentList) {
                            if (group.getGroup_id().equals(stud.getGroup_id().getGroup_id())){
                            array.add(stud);
                            }
                            group.setStudents(array);

                        }
                    }
                    mw.addObject("allGroups",arr);

                    return mw;
                } } }

        return indexPage();
    }

    @RequestMapping(value = "/teachersPage", method = RequestMethod.GET)
    public ModelAndView teachersPage() {
        ModelAndView mw = new ModelAndView("teachersPages/teachers_firstPage");
        Advisor advisor = getAdviser(userID);
        mw.addObject("advisor",advisor);
        List<Student> studentList  =  campusBean.getAllStudent();
        List<Group> arr = campusBean.getallGroupByAdviserID(advisor.getId());
        for (Group group: arr) {
            List<Student> array = new ArrayList<Student>();
            for (Student stud: studentList) {
                if (group.getGroup_id().equals(stud.getGroup_id().getGroup_id())){
                    array.add(stud);
                }
                group.setStudents(array);
            }
        }
        mw.addObject("allGroups",arr);

        return mw;
    }

    @RequestMapping(value = "/teachers_studentListPage", method = RequestMethod.GET)
    public ModelAndView teachersStudents(@RequestParam(name = "groupId") Long groupID) {
        ModelAndView mw = new ModelAndView("teachersPages/teachers_studentlistPage");
        Advisor advisor = getAdviser(userID);
        mw.addObject("advisor",advisor);
        List<Student> studentList  =  campusBean.getAllStudent();
        Group group = campusBean.getGroupByID(groupID);
        List<Student> arr1 = campusBean.getAllStudentByGroupId(groupID);
        group.setStudents(arr1);
        mw.addObject("group",group);

        return mw;
    }

    @RequestMapping(value = "/addStudent", method = RequestMethod.GET)
    public ModelAndView addStudent() {
        ModelAndView mw = new ModelAndView("teachersPages/teachers_addStudentPage");
        Advisor advisor = getAdviser(userID);
        mw.addObject("advisor",advisor);
        return mw;
    }

    @RequestMapping(value = "/studentPage", method = RequestMethod.GET)
    public ModelAndView studentPage(@RequestParam(name = "studentId") Long studID) {
        ModelAndView mw = new ModelAndView("teachersPages/individual_StudentPage");
        Advisor advisor = getAdviser(userID);
        Student student = campusBean.getStudentByID(studID);
        mw.addObject("student",student);
        mw.addObject("advisor",advisor);
        List<Practice> practiceList = campusBean.getAllPracticeByStudentId(studID);
        String stDate =getDate();
        Date date = java.sql.Date.valueOf(stDate);
        mw.addObject("allPractice",practiceList);
        Long practiceID = 0l;
        for (Practice prac:practiceList) {
            System.out.println("PRAPRRKJU");
            if (prac.getAdvisor_id().getId().equals(advisor.getId())
//                    && prac.getDate_finish().before(date)
//                    I dont know but its wrong
            ){
                mw.addObject("yourPractice",prac);
                practiceID=prac.getPractice_id();
            }
        }
        List<ConnectorComment> arraylist = campusBean.getAllConnector();
        System.out.println(arraylist.toString());
        List <ConnectorComment> arr = new ArrayList<ConnectorComment>();
        String curdate = getDate();
        for (ConnectorComment connect:arraylist) {
            if (connect.getPractice_id().getPractice_id().equals(practiceID)
            ){
                if (connect.getStudent_id().getStudent_id().equals(student.getStudent_id())){
                    arr.add(connect);
            }
            }
        }

        System.out.println(arr.size()+arr.toString());
        mw.addObject("commentarii",arr);
        mw.addObject("curdate",curdate);

        return mw;
    }

    @RequestMapping(value = "/tester", method = RequestMethod.GET)
    public ModelAndView testet() {
        ModelAndView mw = new ModelAndView("studentPages/PracticePage");
        Long practiceID  = 1L;
        Practice practice = campusBean.getPracticeByID(practiceID);
        Student currentStudent=campusBean.getStudentByID(userID);
        List<Practice> arr = campusBean.getAllPracticeByStudentId(currentStudent.getStudent_id());
        System.out.println("ARRAY "+arr.toString());
        String stDate =getDate();
        List<ConnectorComment> arraylist = campusBean.getAllConnector();
        List<ConnectorComment> array = check(arraylist,currentStudent,practice);

        mw.addObject("commentArray",array);
        mw.addObject("arrayPractice",arr);
        mw.addObject("usersPractice",practice);
        mw.addObject("student",currentStudent);
        mw.addObject("currentDate",stDate);
        mw.addObject("practiceID", practiceID);
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
    public ModelAndView studentPracticePage(@RequestParam (name = "practiceID") Long practiceID ) {
        ModelAndView mw = new ModelAndView("studentPages/PracticePage");
        Practice practice = campusBean.getPracticeByID(practiceID);
        Student currentStudent=campusBean.getStudentByID(userID);
        List<Practice> arr = campusBean.getAllPracticeByStudentId(currentStudent.getStudent_id());
        System.out.println("ARRAY "+arr.toString());
        String stDate =getDate();
        List<ConnectorComment> arraylist = campusBean.getAllConnector();
        List<ConnectorComment> array = check(arraylist,currentStudent,practice);

        mw.addObject("commentArray",array);
        mw.addObject("arrayPractice",arr);
        mw.addObject("usersPractice",practice);
        mw.addObject("student",currentStudent);
        mw.addObject("currentDate",stDate);
        mw.addObject("practiceID", practiceID);
        return mw;
    }

    public List<ConnectorComment> check(List<ConnectorComment> arraylist, Student currentStudent, Practice practice) {
        List<ConnectorComment> arr = new ArrayList<ConnectorComment>();
        System.out.println(currentStudent.toString());
        System.out.println(practice.toString());
        System.out.println(arraylist.toString());
        for (int i=0;i<arraylist.size();i++){
            if (arraylist.get(i).getPractice_id().getPractice_id().equals(practice.getPractice_id())){
                if (arraylist.get(i).getStudent_id().getStudent_id().equals(currentStudent.getStudent_id())){
                    System.out.println(arraylist.get(i));
                    arr.add(arraylist.get(i));
                }
            }
        }

        System.out.println(arr.toString());

        return arr;
    }

    @RequestMapping(value = "/studentAddPracticePage", method = RequestMethod.GET)
    public ModelAndView studentAddPracticePage() {
        ModelAndView mw = new ModelAndView("studentPages/add_Practice");
        List<Advisor> arr = campusBean.getAllAdvisors();
        List<Company> arrayCompany = campusBean.getallCompany();

        mw.addObject("adviserArray",arr);
        mw.addObject("companyArray",arrayCompany);
        return mw;
    }



    @RequestMapping(value = "/add_practice_toDB", method = RequestMethod.GET)
    public ModelAndView add_practice_toDB( @RequestParam(name = "name_of_practice") String nameOfPractice,
                                           @RequestParam(name = "adviserId") Long advisorID,
                                           @RequestParam(name = "companyId") Long companyID,
                                           @RequestParam(name = "dateOfStart") String startDay,
                                           @RequestParam(name = "dateOfFinish") String endDay) throws ParseException {
        ModelAndView mw = new ModelAndView("studentPages/studentFirstPage");
        System.out.println(nameOfPractice+" "+advisorID+" "+companyID+" "+startDay+" "+endDay);
        Advisor advisor = getAdviser(advisorID);
        Company company = campusBean.getCompanyById(companyID);
        Student student = campusBean.getStudentByID(userID);
        System.out.println(advisor.toString());
        Date date1=new SimpleDateFormat("dd-MM-yyyy").parse(startDay);
        Date date2=new SimpleDateFormat("dd-MM-yyyy").parse(endDay);

        Practice practice = new Practice(student,nameOfPractice,advisor,company,date1,date2,0);
        campusBean.addAnything(practice);
        List<Practice> arr = campusBean.getAllPracticeByStudentId(student.getStudent_id());
        mw.addObject("practiceArray",arr);
        mw.addObject("student",student);
        userID=student.getStudent_id();


        return mw;
    }
    @RequestMapping(value = "/add_real_practice", method = RequestMethod.GET)
    public ModelAndView add_practice(
            @RequestParam(name = "fullcomment") String fullcomment,
            @RequestParam (name = "userID")     int userlLogin,
            @RequestParam (name = "practiceID") Long practiceID,
            @RequestParam(name = "file") byte[] file
    ) throws ParseException {
        ModelAndView mw = new ModelAndView("studentPages/studentFirstPage");
        String stDate =getDate();

        Comment comment = new Comment();
        comment.setComment(fullcomment);
        comment.setLogin(userlLogin);
        comment.setCommentDate(java.sql.Date.valueOf(stDate));
        Practice practice = campusBean.getPracticeByID(practiceID);
        campusBean.addAnything(comment);
        ConnectorComment connectorComment = new ConnectorComment();
        connectorComment.setComment_id(comment);
        connectorComment.setPractice_id(practice);
        Student student = campusBean.getStudentByID(userID);
        connectorComment.setStudent_id(student);
        campusBean.addAnything(connectorComment);
        List<Practice> arr = campusBean.getAllPracticeByStudentId(student.getStudent_id());
        mw.addObject("practiceArray",arr);
        mw.addObject("student",student);

        return mw;
    }



    @RequestMapping(value = "/changeScoreForPractice", method = RequestMethod.POST)
    public ModelAndView add_practice(
            @RequestParam (name = "ScoreForScore")int score,
            @RequestParam(name = "studentId") Long studID){
        ModelAndView mw = new ModelAndView("teachersPages/individual_StudentPage");
        System.out.println(score);
        Advisor advisor = getAdviser(userID);
        Student student = campusBean.getStudentByID(studID);
        mw.addObject("student",student);
        mw.addObject("advisor",advisor);
        List<Practice> practiceList = campusBean.getAllPracticeByStudentId(studID);
        String stDate =getDate();
        Date date = java.sql.Date.valueOf(stDate);
        mw.addObject("allPractice",practiceList);
        Long practiceID = 0l;
        for (Practice prac:practiceList) {
            System.out.println("PRAPRRKJU");
            if (prac.getAdvisor_id().getId().equals(advisor.getId())
//                    && prac.getDate_finish().before(date)
//                    I dont know but its wrong
            ){
                practiceID=prac.getPractice_id();
                prac.setScore(score);
                campusBean.updateAnyThing(prac);
                mw.addObject("yourPractice",prac);

            }
        }
        List<ConnectorComment> arraylist = campusBean.getAllConnector();
        System.out.println(arraylist.toString());
        List <ConnectorComment> arr = new ArrayList<ConnectorComment>();
        String curdate = getDate();
        for (ConnectorComment connect:arraylist) {
            if (connect.getPractice_id().getPractice_id().equals(practiceID)
            ){
                if (connect.getStudent_id().getStudent_id().equals(student.getStudent_id())){
                    arr.add(connect);
                }
            }
        }


        System.out.println(arr.size()+arr.toString());
        mw.addObject("commentarii",arr);
        mw.addObject("curdate",curdate);


        return mw;
    }

    public String getDate(){
        Calendar cal = Calendar. getInstance();
        Date date = cal.getTime();
        DateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd");
        String stDate =dateFormat.format(date);
        return stDate;
    }

    public Advisor getAdviser(Long id){
        List<Advisor> arr = campusBean.getAllAdvisors();
        for (Advisor ad: arr) {
            if (ad.getId().equals(id)){
                return ad;            }
        }
        return null;
    }
}
