package com.myspring.entities;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "company")
public class Company implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "company_id")
    private Long  company_id;

    @Column(name = "name")
    private String name;

    @Column(name = "companyName")
    private String compName;

    @Column(name = "ces")
    private Long ces;

    @Column(name = "status")
    private int status;

    public Company(String name, String compName, Long ces, int status) {
        this.name = name;
        this.compName = compName;
        this.ces = ces;
        this.status = status;
    }

    public Company() {
    }

    public Long getCompany_id() {
        return company_id;
    }

    public void setCompany_id(Long company_id) {
        this.company_id = company_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCompName() {
        return compName;
    }

    public void setCompName(String compName) {
        this.compName = compName;
    }

    public Long getCes() {
        return ces;
    }

    public void setCes(Long ces) {
        this.ces = ces;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
