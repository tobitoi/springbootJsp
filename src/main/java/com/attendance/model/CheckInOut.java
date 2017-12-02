package com.attendance.model;


import org.springframework.data.jpa.domain.AbstractPersistable;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * Created by Tobitoi on 8/24/17.
 */
@Entity
public class CheckInOut extends AbstractPersistable<Long> {

    private transient Long id;
    private transient Long pegawaiId;
    @ManyToOne
    @JoinColumn(name = "user_Id")
    private Pegawai pegawai;

    private transient Long shiftId;
    @ManyToOne
    @JoinColumn (name = "shift_Id")
    private Shift shift;

    @NotNull
    private String checkInTime;

    @NotNull
    private String checkOutTime;

    @NotNull
    private String checkType;

    @NotNull
    private String verifyCode;

    private String sensorId;

    @NotNull
    private int workCode;

    private String sn;

    private String late;

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    public Pegawai getPegawai() {
        return pegawai;
    }

    public void setPegawai(Pegawai pegawai) {
        this.pegawai = pegawai;
    }

    public String getCheckInTime() {
        return checkInTime;
    }

    public void setCheckInTime(String checkInTime) {
        this.checkInTime = checkInTime;
    }

    public String getCheckOutTime() {
        return checkOutTime;
    }

    public void setCheckOutTime(String checkOutTime) {
        this.checkOutTime = checkOutTime;
    }

    public String getCheckType() {
        return checkType;
    }

    public void setCheckType(String checkType) {
        this.checkType = checkType;
    }

    public String getVerifyCode() {
        return verifyCode;
    }

    public void setVerifyCode(String verifyCode) {
        this.verifyCode = verifyCode;
    }

    public String getSensorId() {
        return sensorId;
    }

    public void setSensorId(String sensorId) {
        this.sensorId = sensorId;
    }

    public int getWorkKode() {
        return workCode;
    }

    public void setWorkKode(int workKode) {
        this.workCode = workKode;
    }

    public String getSn() {
        return sn;
    }

    public void setSn(String sn) {
        this.sn = sn;
    }

    public int getWorkCode() {
        return workCode;
    }

    public void setWorkCode(int workCode) {
        this.workCode = workCode;
    }

    public String getLate() {
        return late;
    }

    public void setLate(String late) {
        this.late = late;
    }

    public Long getPegawaiId() {
        return pegawaiId;
    }

    public void setPegawaiId(Long pegawaiId) {
        this.pegawaiId = pegawaiId;
    }

    public int getColumnCount(){
        return getClass().getDeclaredFields().length;
    }

    public Shift getShift() {
        return shift;
    }

    public void setShift(Shift shift) {
        this.shift = shift;
    }

    public Long getShiftId() {
        return shiftId;
    }

    public void setShiftId(Long shiftId) {
        this.shiftId = shiftId;
    }
}
