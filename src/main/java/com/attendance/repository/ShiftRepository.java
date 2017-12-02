package com.attendance.repository;


import com.attendance.model.Shift;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Tobitoi on 11/23/17.
 */
public interface ShiftRepository extends JpaRepository<Shift, Long> {
}
