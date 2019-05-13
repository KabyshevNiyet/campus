package com.myspring.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;

@Entity
@Table(name = "student")
public class Student implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "student_id")
    private  Long   student_id;
    @Column(name = "name")
    private String  name;
    @Column(name = "surname")
    private String  surname;
    @Column(name = "date_of_birth")
    private Date date_of_birth;
    @ManyToOne
    @JoinColumn(name = "group_id")
    private Group    group_id;
    @Column(name = "login")
    private int     login;
    @Column(name = "password")
    private String  password;

    public Student() {
    }

    public Student(String name, String surname, Date date_of_birth, Group group_id, int login, String password) {
        this.name = name;
        this.surname = surname;
        this.date_of_birth = date_of_birth;
        this.group_id = group_id;
        this.login = login;
        this.password = password;
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

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Date getDate_of_birth() {
        return date_of_birth;
    }

    public void setDate_of_birth(Date date_of_birth) {
        this.date_of_birth = date_of_birth;
    }

    public Group getGroup_id() {
        return group_id;
    }

    public void setGroup_id(Group group_id) {
        this.group_id = group_id;
    }

    public int getLogin() {
        return login;
    }

    public void setLogin(int login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Student{" +
                "student_id=" + student_id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", date_of_birth=" + date_of_birth +
                ", group_id=" + group_id +
                ", login=" + login +
                ", password='" + password + '\'' +
                '}';
    }
}
