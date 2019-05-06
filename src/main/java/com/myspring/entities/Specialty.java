package com.myspring.entities;

import javax.persistence.*;
import java.io.Serializable;


@Entity
@Table(name = "specialty")
public class Specialty implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "specialty_id")
    private Long specialty_id;
    @Column(name = "name")
    private String name;

    public Specialty(String name) {
        this.name = name;
    }

    public Specialty() {
    }

    public Long getSpecialty_id() {
        return specialty_id;
    }

    public void setSpecialty_id(Long specialty_id) {
        this.specialty_id = specialty_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
