package com.myspring.entities;


import javax.persistence.*;

@Entity
@Table(name = "company")
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "company_id")
    private long company_id;

    @Column(name = "name", length = 255)
    private String name;

    @Column(name = "director", length = 255)
    private String director;

    @Column(name = "ces")
    private Long ces;

    @Column(name = "status")
    private Long status;

    public long getCompany_id() {
        return company_id;
    }

    public void setCompany_id(long company_id) {
        this.company_id = company_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public Long getCes() {
        return ces;
    }

    public void setCes(Long ces) {
        this.ces = ces;
    }

    public Long getStatus() {
        return status;
    }

    public void setStatus(Long status) {
        this.status = status;
    }
}
