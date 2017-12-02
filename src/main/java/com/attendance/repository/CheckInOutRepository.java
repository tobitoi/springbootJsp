package com.attendance.repository;

import com.attendance.model.CheckInOut;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Tobitoi on 8/24/17.
 */
public interface CheckInOutRepository extends JpaRepository<CheckInOut, Long> {


}
