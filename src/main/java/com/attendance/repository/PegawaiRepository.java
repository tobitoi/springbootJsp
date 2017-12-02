package com.attendance.repository;

import com.attendance.model.Pegawai;
import org.springframework.data.jpa.repository.JpaRepository;


/**
 * Created by Tobitoi on 8/23/17.
 */
public interface PegawaiRepository extends JpaRepository<Pegawai, Long> {


}
