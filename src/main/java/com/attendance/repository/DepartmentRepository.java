package com.attendance.repository;


import com.attendance.model.Departments;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Tobitoi on 8/30/17.
 */
public interface DepartmentRepository extends JpaRepository<Departments, Long> {
}
