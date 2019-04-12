package com.myspring.entities;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "userRole")
public class UserRole {
    @ManyToOne
    @JoinColumn(name = "student_id")
    private Long student_id;

    @ManyToOne
    @JoinColumn(name = "role_id")
    private Long role_id;

    public Long getStudent_id() {
        return student_id;
    }

    public void setStudent_id(Long student_id) {
        this.student_id = student_id;
    }

    public Long getRole_id() {
        return role_id;
    }

    public void setRole_id(Long role_id) {
        this.role_id = role_id;
    }
}
