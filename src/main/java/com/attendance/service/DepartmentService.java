package com.attendance.service;

import com.attendance.model.Departments;

import java.util.List;

/**
 * Created by Tobitoi on 8/30/17.
 */
public interface DepartmentService {

    List<Departments> departmentList();

    Departments findOne(Long deptId);

    String addDepartment(Departments department);

    String deleteDepartment(Long deptId);
}
