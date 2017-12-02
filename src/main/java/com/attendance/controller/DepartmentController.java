package com.attendance.controller;

import com.attendance.model.Departments;
import com.attendance.service.DepartmentService;
import com.attendance.utils.ErrorUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * Created by Tobitoi on 8/30/17.
 */
@Controller
@RequestMapping("/department")
public class DepartmentController {

    private DepartmentService departmentService;

    @Autowired
    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;

    }

    @GetMapping("/form")
    public String departmentForm(Model model) {
        model.addAttribute("isNew", true);
        model.addAttribute("departmentForm", new Departments());
//        model.addAttribute("users", userService.userList());
        return "department/form";
    }

    @GetMapping("/edit/{id}")
    public String departmentOne(@PathVariable Long deptId, Model model) {
        model.addAttribute("isNew", false);
        model.addAttribute("departmentForm", departmentService.findOne(deptId));
//        model.addAttribute("users", userService.userList());
        return "department/form";
    }

    @GetMapping(value = "/delete/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public @ResponseBody
    String departmentDelete(@PathVariable Long deptId) {
        return departmentService.deleteDepartment(deptId);
    }

    @PostMapping(value = "/add", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    String departmentAdd(@Valid @RequestBody Departments department, BindingResult result) {
        if (result.hasErrors()) {
            return ErrorUtils.customErrors(result.getAllErrors());
        } else {
            return departmentService.addDepartment(department);
        }
    }

    @GetMapping("/list/{id}")
    public Departments findOne(@PathVariable Long deptId) {
        return departmentService.findOne(deptId);
    }

    @GetMapping("/list")
    public String departmentList(Model model) {
        model.addAttribute("departments", departmentService.departmentList());
        return "department/list";
    }
}
