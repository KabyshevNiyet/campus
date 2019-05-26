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


    public void addAnything(Object object){
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(object);
        transaction.commit();
        session.close();
    }
    public void updateAnyThing(Object onj){
        Session session =sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.update(onj);
        transaction.commit();
        session.close();
    }
    public List<Advisor> getAllAdvisors(){
        Session session = sessionFactory.openSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Advisor> criteriaQuery = builder.createQuery(Advisor.class);
        Root root = criteriaQuery.from(Advisor.class);
        List<Advisor> advisors = session.createQuery(criteriaQuery).list();
        session.close();
        return advisors;
    }

    public List<Student> getAllStudent(){
        Session session = sessionFactory.openSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Student> criteriaQuery = builder.createQuery(Student.class);
        Root root = criteriaQuery.from(Student.class);
        List<Student> students = session.createQuery(criteriaQuery).list();
        session.close();
        return students;
    }

    public List<ConnectorComment> getAllConnector(){
        Session session = sessionFactory.openSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<ConnectorComment> criteriaQuery = builder.createQuery(ConnectorComment.class);
        Root root = criteriaQuery.from(ConnectorComment.class);
        List<ConnectorComment> students = session.createQuery(criteriaQuery).list();
        session.close();
        return students;
    }

    public List<Practice> getAllPracticeByStudentId(Long id){
        Session session = sessionFactory.openSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Practice> criteriaQuery = builder.createQuery(Practice.class);
        Root root = criteriaQuery.from(Practice.class);
        List<Practice> students = session.createQuery(criteriaQuery.where(builder.equal(root.get("student_id"),id))).list();
        session.close();
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
    public Advisor getAdviserById(Long id){
        Session session = sessionFactory.openSession();
        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery<Advisor> query = criteriaBuilder.createQuery(Advisor.class);
        Root<Advisor> root = query.from(Advisor.class);
        Advisor student = session.createQuery(query.where(criteriaBuilder.equal(root.get("advisor_id"), id))).getSingleResult();
        session.close();
        return student;
    }


    public List<Company> getallCompany() {
        Session session = sessionFactory.openSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Company> criteriaQuery = builder.createQuery(Company.class);
        Root root = criteriaQuery.from(Company.class);
        List<Company> company = session.createQuery(criteriaQuery).list();
        session.close();
        return company;
    }


    public Company getCompanyById(Long companyID) {
        Session session = sessionFactory.openSession();
        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery<Company> query = criteriaBuilder.createQuery(Company.class);
        Root<Company> root = query.from(Company.class);
        Company student = session.createQuery(query.where(criteriaBuilder.equal(root.get("company_id"), companyID))).getSingleResult();
        session.close();
        return student;
    }

    public List<Group> getallGroupByAdviserID(Long adviserID) {
        Session session = sessionFactory.openSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Group> criteriaQuery = builder.createQuery(Group.class);
        Root root = criteriaQuery.from(Group.class);
        List<Group> students = session.createQuery(criteriaQuery.where(builder.equal(root.get("advisor_id"),adviserID))).list();
        session.close();
        return students;
    }

    public List<Group> getallGroups() {
        Session session = sessionFactory.openSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Group> criteriaQuery = builder.createQuery(Group.class);
        Root root = criteriaQuery.from(Group.class);
        List<Group> company = session.createQuery(criteriaQuery).list();
        session.close();
        return company;
    }

    public Group getGroupByID(Long groupId) {
        Session session = sessionFactory.openSession();
        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery<Group> query = criteriaBuilder.createQuery(Group.class);
        Root<Group> root = query.from(Group.class);
        Group group = session.createQuery(query.where(criteriaBuilder.equal(root.get("group_id"), groupId))).getSingleResult();
        session.close();
        return group;
    }

    public List<Student> getAllStudentByGroupId(Long groupId) {
        Session session = sessionFactory.openSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Student> criteriaQuery = builder.createQuery(Student.class);
        Root root = criteriaQuery.from(Student.class);
        List<Student> students = session.createQuery(criteriaQuery.where(builder.equal(root.get("group_id"),groupId))).list();
        session.close();
        return students;
    }
    
}
