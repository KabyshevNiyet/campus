package com.myspring.beans;

import com.myspring.entities.Advisor;
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
    public List<Advisor> getAllAdvisors(){
        Session session = sessionFactory.openSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Advisor> criteriaQuery = builder.createQuery(Advisor.class);
        Root root = criteriaQuery.from(Advisor.class);
        List<Advisor> advisors = session.createQuery(criteriaQuery).list();
        return advisors;
    }

}
