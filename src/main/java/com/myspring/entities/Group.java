package com.myspring.entities;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "group")
public class Group implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "group_id")
    private Long group_id;
    @Column(name = "name")
    private String name;
    @Column(name = "specialty_id")
    private Long specialty_id;
    @Column(name = "advisor_id")
    private Long advisor_id;

    public Group() {
    }

    public Group(String name, Long specialty_id, Long advisor_id) {
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

    public Long getSpecialty_id() {
        return specialty_id;
    }

    public void setSpecialty_id(Long specialty_id) {
        this.specialty_id = specialty_id;
    }

    public Long getAdvisor_id() {
        return advisor_id;
    }

    public void setAdvisor_id(Long advisor_id) {
        this.advisor_id = advisor_id;
    }
}