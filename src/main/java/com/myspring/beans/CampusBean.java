package com.myspring.beans;

import com.myspring.entities.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class CampusBean {
    private SessionFactory sessionFactory;

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void addAdvisor(Advisor advisor){
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(advisor);
        transaction.commit();
        session.close();
    }

    public void addComment(Comment comment){
        Session session =sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(comment);
        transaction.commit();
        session.close();
    }

    public void addCommentConnector(ConnectorComment connectorComment){

    }
    public List<Advisor> getAllAdvisors(){
        Session session = sessionFactory.openSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Advisor> criteriaQuery = builder.createQuery(Advisor.class);
        Root root = criteriaQuery.from(Advisor.class);
        List<Advisor> advisors = session.createQuery(criteriaQuery).list();
        return advisors;
    }

    public List<Student> getAllStudent(){
        Session session = sessionFactory.openSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Student> criteriaQuery = builder.createQuery(Student.class);
        Root root = criteriaQuery.from(Student.class);
        List<Student> students = session.createQuery(criteriaQuery).list();
        return students;
    }

    public List<Practice> getAllPracticeByStudentId(Long id){
        Session session = sessionFactory.openSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Practice> criteriaQuery = builder.createQuery(Practice.class);
        Root root = criteriaQuery.from(Practice.class);
        List<Practice> students = session.createQuery(criteriaQuery.where(builder.equal(root.get("student_id"),id))).list();
        return students;
    }

    public Practice getPracticeByID(Long ID){
        Session session = sessionFactory.openSession();
        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery<Practice> query = criteriaBuilder.createQuery(Practice.class);
        Root<Practice> root = query.from(Practice.class);
        Practice prac = session.createQuery(query.where(criteriaBuilder.equal(root.get("practice_id"), ID))).getSingleResult();
        session.close();
        return prac;
    }

    public Student getStudentByID(Long ID){
        Session session = sessionFactory.openSession();
        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery<Student> query = criteriaBuilder.createQuery(Student.class);
        Root<Student> root = query.from(Student.class);
        Student student = session.createQuery(query.where(criteriaBuilder.equal(root.get("student_id"), ID))).getSingleResult();
        session.close();
        return student;
    }

//    Session session = sessionFactory.openSession();
//    CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
//    CriteriaQuery<Users> query = criteriaBuilder.createQuery(Users.class);
//    Root<Users> root = query.from(Users.class);
//    Users users = session.createQuery(query.where(criteriaBuilder.equal(root.get("login"), login))).getSingleResult();
//        session.close();
//        return users;
}
