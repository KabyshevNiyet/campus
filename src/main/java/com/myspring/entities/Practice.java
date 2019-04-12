package com.myspring.entities;


import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "practice")
public class Practice {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "practice_id")
    private Long practice_id;

    @ManyToOne
    @JoinColumn(name = "student_id")
    private Long student_id;

    @Column(name = "name", length = 255)
    private String name;

    @ManyToOne
    @JoinColumn(name = "advisor_id")
    private Long advisor_id;

    @ManyToOne
    @JoinColumn(name = "company_id")
    private Long company_id;

    @Column(name = "date_start")
    private Date date_start;

    @Column(name = "date_finish")
    private Date date_finsh;

    @Column(name = "score")
    private int score;

    @Column(name = "comment", length = 255)
    private String comment;

    public Long getPractice_id() {
        return practice_id;
    }

    public void setPractice_id(Long practice_id) {
        this.practice_id = practice_id;
    }

    public Long getStudent_id() {
        return student_id;
    }

    public void setStudent_id(Long student_id) {
        this.student_id = student_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getAdvisor_id() {
        return advisor_id;
    }

    public void setAdvisor_id(Long advisor_id) {
        this.advisor_id = advisor_id;
    }

    public Long getCompany_id() {
        return company_id;
    }

    public void setCompany_id(Long company_id) {
        this.company_id = company_id;
    }

    public Date getDate_start() {
        return date_start;
    }

    public void setDate_start(Date date_start) {
        this.date_start = date_start;
    }

    public Date getDate_finsh() {
        return date_finsh;
    }

    public void setDate_finsh(Date date_finsh) {
        this.date_finsh = date_finsh;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
