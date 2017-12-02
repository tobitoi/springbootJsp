package com.attendance.service;


import com.attendance.model.Departments;
import com.attendance.model.Pegawai;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * Created by Tobitoi on 8/23/17.
 */
public interface PegawaiService {
    List<Pegawai> pegawaiList();

    Page<Pegawai> findAll(Pageable pageable);

    Pegawai findOne(Long id);

    String addPegawai(Pegawai pegawai);

    String deletePegawai(Long id);

    List<Departments> department();

    void refreshCache();
}
