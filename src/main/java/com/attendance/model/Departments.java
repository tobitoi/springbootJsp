package com.attendance.model;

import org.springframework.data.jpa.domain.AbstractPersistable;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Set;

/**
 * Created by Tobitoi on 8/30/17.
 */
@Entity
public class Departments extends AbstractPersistable<Long> {
    private transient Long id;

    private  Long dept_Id;

    @OneToMany(targetEntity = Pegawai.class, mappedBy = "departments", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Pegawai> pegawai;

    @NotNull
    private String deptName;

    @NotNull
    private int supDeptId;

    @NotNull
    private int inheritParentSch;

    private  int inheritDeptSch;

    private  int inheritDeptSchClass;

    private int autoSchPlan;

    private int inLate;

    private int outEarly;

    private int inheritDeptRule;

    private Integer minAutoSchInterval;

    private int registerOt;

    private Integer defaultSchId;

    private int att;

    private int holiday;

    private int overTime;

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public int getSupDeptId() {
        return supDeptId;
    }

    public void setSupDeptId(int subDeptId) {
        this.supDeptId = subDeptId;
    }

    public int getInheritParentSch() {
        return inheritParentSch;
    }

    public void setInheritParentSch(int inheritParentSch) {
        this.inheritParentSch = inheritParentSch;
    }

    public int getInheritDeptSch() {
        return inheritDeptSch;
    }

    public void setIntheritDeptSch(int intheritDeptSch) {
        this.inheritDeptSch = intheritDeptSch;
    }

    public int getIntheritDeptSchClass() {
        return inheritDeptSchClass;
    }

    public void setIntheritDeptSchClass(int intheritDeptSchClass) {
        this.inheritDeptSchClass = intheritDeptSchClass;
    }

    public int getAutoSchPlan() {
        return autoSchPlan;
    }

    public void setAutoSchPlan(int autoSchPlan) {
        this.autoSchPlan = autoSchPlan;
    }

    public int getInLate() {
        return inLate;
    }

    public void setInLate(int inLate) {
        this.inLate = inLate;
    }

    public int getOutEarly() {
        return outEarly;
    }

    public void setOutEarly(int outEarly) {
        this.outEarly = outEarly;
    }

    public int getIntheritDeptRule() {
        return inheritDeptRule;
    }

    public void setIntheritDeptRule(int intheritDeptRule) {
        this.inheritDeptRule = intheritDeptRule;
    }

    public Integer getMinAutoSchInterval() {
        return minAutoSchInterval;
    }

    public void setMinAutoSchInterval(Integer minAutoSchInterval) {
        this.minAutoSchInterval = minAutoSchInterval;
    }

    public int getRegisterOt() {
        return registerOt;
    }

    public void setRegisterOt(int registerOt) {
        this.registerOt = registerOt;
    }

    public Integer getDefaultSchld() {
        return defaultSchId;
    }

    public void setDefaultSchld(Integer defaultSchld) {
        this.defaultSchId = defaultSchld;
    }

    public int getAtt() {
        return att;
    }

    public void setAtt(int att) {
        this.att = att;
    }

    public int getHoliday() {
        return holiday;
    }

    public void setHoliday(int holiday) {
        this.holiday = holiday;
    }

    public int getOverTime() {
        return overTime;
    }

    public void setOverTime(int overTime) {
        this.overTime = overTime;
    }

    public Set<Pegawai> getPegawai() {
        return pegawai;
    }

    public void setPegawai(Set<Pegawai> pegawai) {
        this.pegawai = pegawai;
    }

    public void setInheritDeptSch(int inheritDeptSch) {
        this.inheritDeptSch = inheritDeptSch;
    }

    public int getInheritDeptSchClass() {
        return inheritDeptSchClass;
    }

    public void setInheritDeptSchClass(int inheritDeptSchClass) {
        this.inheritDeptSchClass = inheritDeptSchClass;
    }

    public int getInheritDeptRule() {
        return inheritDeptRule;
    }

    public void setInheritDeptRule(int inheritDeptRule) {
        this.inheritDeptRule = inheritDeptRule;
    }

    public Integer getDefaultSchId() {
        return defaultSchId;
    }

    public void setDefaultSchId(Integer defaultSchId) {
        this.defaultSchId = defaultSchId;
    }

    public Long getDept_Id() {
        return dept_Id;
    }

    public void setDept_Id(Long dept_Id) {
        this.dept_Id = dept_Id;
    }


}
