package com.attendance.model;

import org.springframework.data.jpa.domain.AbstractPersistable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import java.sql.Time;
import java.util.Set;

/**
 * Created by Tobitoi on 11/23/17.
 */
@Entity
public class Shift extends AbstractPersistable<Long> {

    private static final long serialVersionUID = -2716348754532601761L;
    private transient Long id;
    private String name;
    private Time timeIn;
    private Time timeOut;

    @OneToMany(targetEntity = CheckInOut.class, mappedBy = "shift", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<CheckInOut> checkInOuts;


    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<CheckInOut> getCheckInOuts() {
        return checkInOuts;
    }

    public void setCheckInOuts(Set<CheckInOut> checkInOuts) {
        this.checkInOuts = checkInOuts;
    }

    public Time getTimeIn() {
        return timeIn;
    }

    public void setTimeIn(Time timeIn) {
        this.timeIn = timeIn;
    }

    public Time getTimeOut() {
        return timeOut;
    }

    public void setTimeOut(Time timeOut) {
        this.timeOut = timeOut;
    }
}

