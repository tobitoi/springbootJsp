package com.attendance.model;


import org.springframework.data.jpa.domain.AbstractPersistable;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import java.util.Set;

/**
 * Created by Tobitoi on 8/23/17.
 */
@Entity
public class Pegawai extends AbstractPersistable<Long> {
    private transient Long id;

    @NotNull
    @OrderBy("user_id")
    private int userId;
    @NotNull
    private String name;
    @NotNull
    private String gender;
    @NotNull
    private String street;
    @NotNull
    private String badgeNumber;

    private transient Long deptId;

    @ManyToOne
    @JoinColumn(name = "dept_id")
    private Departments departments;


    @OneToMany(targetEntity = CheckInOut.class, mappedBy = "pegawai", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<CheckInOut> checkInOut;


    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getBadgeNumber() {
        return badgeNumber;
    }

    public void setBadgeNumber(String badgeNumber) {
        this.badgeNumber = badgeNumber;
    }


    public Set<CheckInOut> getCheckInOut() {
        return checkInOut;
    }

    public void setCheckInOut(Set<CheckInOut> checkInOut) {
        this.checkInOut = checkInOut;
    }

    public Departments getDepartments() {
        return departments;
    }

    public void setDepartments(Departments departments) {
        this.departments = departments;
    }

    public Long getDeptId() {
        return deptId;
    }

    public void setDeptId(Long deptId) {
        this.deptId = deptId;
    }


}
