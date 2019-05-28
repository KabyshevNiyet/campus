package com.myspring.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;
@Entity
@Table(name = "commentarii")
public class Comment implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "comment_id")
    private Long comment_id;

    @Column(name = "comment")
    private String comment;

    @Column(name = "date")
    private Date commentDate;

    @Column(name = "login")
    private int login;

    @Column(name = "file")
    private byte[] file;

    public Comment() {
    }

    public Comment(String comment, Date commentDate, int login, byte[] file) {
        this.comment = comment;
        this.commentDate = commentDate;
        this.login = login;
        this.file = file;
    }

    public Long getComment_id() {
        return comment_id;
    }

    public void setComment_id(Long comment_id) {
        this.comment_id = comment_id;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Date getCommentDate() {
        return commentDate;
    }

    public void setCommentDate(Date commentDate) {
        this.commentDate = commentDate;
    }

    public int getLogin() {
        return login;
    }

    public void setLogin(int login) {
        this.login = login;
    }

    public byte[] getFile() {
        return file;
    }

    public void setFile(byte[] file) {
        this.file = file;
    }

    @Override
    public String toString() {
        return "Comment{" +
                "comment_id=" + comment_id +
                ", comment='" + comment + '\'' +
                ", commentDate=" + commentDate +
                ", login=" + login +
                '}';
    }
}
