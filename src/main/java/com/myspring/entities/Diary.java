package com.myspring.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
@Entity
@Table(name = "diary")
public class Diary implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "diary_id")
    private Long diary_id;
    @Column(name = "practice_id")
    private Long practice_id;
    @Column(name = "feedback")
    private String feedback;
    @Column(name = "date")
    private Date date;

    public Diary() {
    }

    public Diary(Long practice_id, String feedback, Date date) {
        this.practice_id = practice_id;
        this.feedback = feedback;
        this.date = date;
    }

    public Long getDiary_id() {
        return diary_id;
    }

    public void setDiary_id(Long diary_id) {
        this.diary_id = diary_id;
    }

    public Long getPractice_id() {
        return practice_id;
    }

    public void setPractice_id(Long practice_id) {
        this.practice_id = practice_id;
    }

    public String getFeedback() {
        return feedback;
    }

    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
