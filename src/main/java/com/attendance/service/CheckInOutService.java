package com.attendance.service;


import com.attendance.model.CheckInOut;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;


/**
 * Created by Tobitoi on 8/25/17.
 */
public interface CheckInOutService {
    List<CheckInOut> checkInOutList();

    Page<CheckInOut> findAll(Pageable pageable);

    CheckInOut findOne(Long id);

    String addCheckInOut(CheckInOut checkInOut);

    String deleteCheckInOut(Long id);

    List<CheckInOut> findAll();

    void refreshCache();

}
