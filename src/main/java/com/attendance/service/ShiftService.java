package com.attendance.service;


import com.attendance.model.Shift;

import java.util.List;

/**
 * Created by Tobitoi on 11/23/17.
 */

public interface ShiftService {

    List<Shift> shiftList();

    Shift findOne(Long id);

}
