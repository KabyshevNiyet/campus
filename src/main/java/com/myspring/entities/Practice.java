package com.myspring.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "practice")
public class Practice implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "practice_id")
    private Long 	practice_id;
    @ManyToOne
    @JoinColumn(name = "student_id")
    private Student    student_id;
    @Column(name = "name")
    private String  name;

    @ManyToOne
    @JoinColumn(name = "advisor_id")
    private Advisor advisor_id;

    @ManyToOne
    @JoinColumn(name = "company_id")
    private Company    company_id;

    @Column(name = "date_start")
    private Date    date_start;
    @Column(name = "date_finish")
    private Date    date_finish;
    @Column(name = "score")
    private int     score;


    public Practice() {
    }

    public Practice(Student student_id, String name, Advisor advisor_id, Company company_id, Date date_start, Date date_finish, int score) {
        this.student_id = student_id;
        this.name = name;
        this.advisor_id = advisor_id;
        this.company_id = company_id;
        this.date_start = date_start;
        this.date_finish = date_finish;
        this.score = score;
    }

    public Long getPractice_id() {
        return practice_id;
    }

    public void setPractice_id(Long practice_id) {
        this.practice_id = practice_id;
    }

    public Student getStudent_id() {
        return student_id;
    }

    public void setStudent_id(Student student_id) {
        this.student_id = student_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Advisor getAdvisor_id() {
        return advisor_id;
    }

    public void setAdvisor_id(Advisor advisor_id) {
        this.advisor_id = advisor_id;
    }

    public Company getCompany_id() {
        return company_id;
    }

    public void setCompany_id(Company company_id) {
        this.company_id = company_id;
    }

    public Date getDate_start() {
        return date_start;
    }

    public void setDate_start(Date date_start) {
        this.date_start = date_start;
    }

    public Date getDate_finish() {
        return date_finish;
    }

    public void setDate_finish(Date date_finish) {
        this.date_finish = date_finish;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }


    @Override
    public String toString() {
        return "Practice{" +
                "practice_id=" + practice_id +
                ", student_id=" + student_id +
                ", name='" + name + '\'' +
                ", advisor_id=" + advisor_id +
                ", company_id=" + company_id +
                ", date_start=" + date_start +
                ", date_finish=" + date_finish +
                ", score=" + score +
                '}';
    }
}

