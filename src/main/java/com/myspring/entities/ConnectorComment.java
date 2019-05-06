package com.myspring.entities;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "commentConector")
public class ConnectorComment {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;
    @ManyToOne
    @JoinColumn(name = "comment_id")
    private Comment comment_id;
    @ManyToOne
    @JoinColumn(name = "student_id")
    private Student student_id;
    @ManyToOne
    @JoinColumn(name = "practice_id")
    private Practice practice_id;

    public ConnectorComment() {
    }

    public ConnectorComment(Comment comment_id, Student student_id, Practice practice_id) {
        this.comment_id = comment_id;
        this.student_id = student_id;
        this.practice_id = practice_id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Comment getComment_id() {
        return comment_id;
    }

    public void setComment_id(Comment comment_id) {
        this.comment_id = comment_id;
    }

    public Student getStudent_id() {
        return student_id;
    }

    public void setStudent_id(Student student_id) {
        this.student_id = student_id;
    }

    public Practice getPractice_id() {
        return practice_id;
    }

    public void setPractice_id(Practice practice_id) {
        this.practice_id = practice_id;
    }
}
