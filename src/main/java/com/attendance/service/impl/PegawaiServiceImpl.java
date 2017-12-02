package com.attendance.service.impl;

import com.attendance.model.Departments;
import com.attendance.model.Pegawai;
import com.attendance.repository.DepartmentRepository;
import com.attendance.repository.PegawaiRepository;
import com.attendance.service.PegawaiService;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Caching;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.jdo.annotations.Cacheable;
import java.util.List;

/**
 * Created by Tobitoi on 8/23/17.
 */
@Service
public class PegawaiServiceImpl implements PegawaiService {

    @Autowired
    private PegawaiRepository pegawaiRepository;
    private DepartmentRepository departmentRepository;

    @Autowired
    public PegawaiServiceImpl(DepartmentRepository departmentRepository, PegawaiRepository pegawaiRepository) {
        this.pegawaiRepository = pegawaiRepository;
        this.departmentRepository = departmentRepository;
    }

    @Override
    @Cacheable("pegawaiCache")
    public List<Pegawai> pegawaiList() {
        return pegawaiRepository.findAll();
    }

    @Override
    @Cacheable("pegawaiCache")
    public Page<Pegawai> findAll(Pageable pageable) {
        return pegawaiRepository.findAll(new PageRequest(pageable.getPageNumber() - 1, 10));
    }

    @Override
    public Pegawai findOne(Long id) {
        return pegawaiRepository.findOne(id);
    }

    @Override
    @Caching(put = {
            @CachePut(value = "pegawaiCache", key = "#pegawai")
    })
    public String addPegawai(Pegawai pegawai) {
        String message = null;
        JSONObject jsonObject = new JSONObject();
        try {
            if(pegawai.getId() == null) {
                message = "Added";
            } else {
                message = "Updated";
            }
            Departments departments = departmentRepository.findOne(pegawai.getDeptId());
            pegawai.setDepartments(departments);
            pegawaiRepository.save(pegawai);
            jsonObject.put("status", "success");
            jsonObject.put("title", message+" Confirmation");
            jsonObject.put("message", "Employee "+pegawai.getName() +" "+ message + " successfully.");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jsonObject.toString();
    }

    @Override
    @CacheEvict(value = "pegawaiCache", allEntries = true)
    public String deletePegawai(Long id) {

        JSONObject jsonObject = new JSONObject();
        try {
            pegawaiRepository.delete(id);
            jsonObject.put("message", "Deleted Successfully.");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jsonObject.toString();
    }

    @Override
    public List<Departments> department() {
        return departmentRepository.findAll();
    }

    @Override
    @Caching(evict = {
            @CacheEvict(value = "pegawaiCache", allEntries = true)
    })
    public void refreshCache() {

    }
}
