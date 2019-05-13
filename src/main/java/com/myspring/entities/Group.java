package com.myspring.entities;

import jdk.nashorn.internal.ir.annotations.Ignore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "groups")
public class Group implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "group_id")
    private Long group_id;

    @Column(name = "nameOfGroup")
    private String name;

    @ManyToOne
    @JoinColumn(name = "specialty_id")
    private Specialty specialty_id;

    @ManyToOne
    @JoinColumn(name = "advisor_id")
    private Advisor advisor_id;



    @ManyToMany(fetch = FetchType.LAZY)
    @Ignore
    private List<Student> arr;

    public Group() {
    }

    public Group(String name, Specialty specialty_id, Advisor advisor_id) {
        this.name = name;
        this.specialty_id = specialty_id;
        this.advisor_id = advisor_id;
    }

    public Long getGroup_id() {
        return group_id;
    }

    public void setGroup_id(Long group_id) {
        this.group_id = group_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Specialty getSpecialty_id() {
        return specialty_id;
    }

    public void setSpecialty_id(Specialty specialty_id) {
        this.specialty_id = specialty_id;
    }

    public Advisor getAdvisor_id() {
        return advisor_id;
    }

    public void setAdvisor_id(Advisor advisor_id) {
        this.advisor_id = advisor_id;
    }

    public List<Student> getStudents() {
        return arr;
    }

    public void setStudents(List<Student> arr) {
        this.arr = arr;
    }

    @Override
    public String toString() {
        return "Group{" +
                "group_id=" + group_id +
                ", name='" + name + '\'' +
                ", specialty_id=" + specialty_id +
                ", advisor_id=" + advisor_id +
                '}';
    }
}