package com.attendance.service.impl;


import com.attendance.model.Departments;
import com.attendance.repository.DepartmentRepository;
import com.attendance.service.DepartmentService;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Tobitoi on 8/30/17.
 */
@Service
public class DepartmentServiceImpl implements DepartmentService{

    @Autowired
    private DepartmentRepository departmentRepository;

    @Override
    public List<Departments> departmentList() {
        return departmentRepository.findAll();
    }

    @Override
    public Departments findOne(Long deptId) {
        return departmentRepository.findOne(deptId);
    }

    @Override
    public String addDepartment(Departments department) {
        String message = null;
        JSONObject jsonObject = new JSONObject();
        try {
            if(department.getId() == null) {
                message = "Added";
            } else {
                message = "Updated";
            }

            jsonObject.put("status", "success");
            jsonObject.put("title", message+" Confirmation");
            jsonObject.put("message", departmentRepository.save(department).getDeptName()+" "+message+" successfully.");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jsonObject.toString();
    }

    @Override
    public String deleteDepartment(Long deptId) {
        JSONObject jsonObject = new JSONObject();
        try {
            departmentRepository.delete(deptId);
            jsonObject.put("message", "User Deleted Successfully.");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jsonObject.toString();
    }
}
