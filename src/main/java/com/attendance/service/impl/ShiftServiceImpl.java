package com.attendance.service.impl;

import com.attendance.model.Shift;
import com.attendance.repository.ShiftRepository;
import com.attendance.service.ShiftService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Tobitoi on 11/23/17.
 */
@Service
public class ShiftServiceImpl implements ShiftService {
    @Autowired
    private ShiftRepository shiftRepository;

    @Override
    public List<Shift> shiftList() {
        return shiftRepository.findAll();
    }

    @Override
    public Shift findOne(Long id) {
        return shiftRepository.findOne(id);
    }
}
