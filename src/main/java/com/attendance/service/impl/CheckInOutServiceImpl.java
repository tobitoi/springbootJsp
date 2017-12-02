package com.attendance.service.impl;

import com.attendance.model.CheckInOut;
import com.attendance.model.Pegawai;
import com.attendance.model.Shift;
import com.attendance.repository.*;
import com.attendance.service.CheckInOutService;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Caching;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import javax.jdo.annotations.Cacheable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by Tobitoi on 8/25/17.
 */

@Service
public class CheckInOutServiceImpl  implements CheckInOutService{
    @Autowired
    private CheckInOutRepository checkInOutRepository;
    private PegawaiRepository pegawaiRepository;
    private ShiftRepository shiftRepository;
    private JdbcTemplate jtm;

    @Autowired
    public CheckInOutServiceImpl(CheckInOutRepository checkInOutRepository, PegawaiRepository pegawaiRepository,JdbcTemplate jtm, ShiftRepository shiftRepository) {
        this.checkInOutRepository = checkInOutRepository;
        this.pegawaiRepository = pegawaiRepository;
        this.jtm =jtm;
        this.shiftRepository = shiftRepository;
    }

    @Override
    @Cacheable("checkInOutCache")

    public List<CheckInOut> checkInOutList() {
        return checkInOutRepository.findAll();
    }

    @Override
    @Cacheable("checkInOutCache")
    public Page<CheckInOut> findAll(Pageable pageable) {
        return checkInOutRepository.findAll(new PageRequest(pageable.getPageNumber() - 1, 10));
    }

    @Override
    public CheckInOut findOne(Long id) {
        return checkInOutRepository.findOne(id);
    }

    @Override
    @Caching(put = {
            @CachePut(value = "checkInOutCache", key = "#checkInOut")
    })
    public String addCheckInOut(CheckInOut checkInOut) {
        String message = null;

        JSONObject jsonObject = new JSONObject();
        try {
            if(checkInOut.getId() == null) {
                message = "Added";
            } else {
                message = "Updated";
            }
            Pegawai pegawai = pegawaiRepository.findOne(checkInOut.getPegawaiId());
            Shift shift = shiftRepository.findOne(checkInOut.getShiftId());

            checkInOut.setPegawai(pegawai);
            checkInOut.setShift(shift);

            String checkIn = checkInOut.getCheckInTime().substring(10);
            String checkInShift = checkInOut.getShift().getTimeIn().toString();
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm:ss");
            Date date1 = null;
            Date date2 = null;
            try {
                date1 = simpleDateFormat.parse(checkIn);
                date2 = simpleDateFormat.parse(checkInShift);
            } catch (ParseException e) {
                e.printStackTrace();
            }

            if (date1.after(date2)) {
                checkInOut.setLate("Terlambat");
            }else {
                checkInOut.setLate("tidak terlambat");
            }

            checkInOutRepository.save(checkInOut);
            jsonObject.put("status", "success");
            jsonObject.put("title", message+" Confirmation");
            jsonObject.put("message", "Address for "+pegawai.getName() +" "+ message + " successfully.");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jsonObject.toString();
    }

    @Override
    @CacheEvict(value = "checkInOutCache", allEntries = true)
    public String deleteCheckInOut(Long id) {
        JSONObject jsonObject = new JSONObject();
        try {
            checkInOutRepository.delete(id);
            jsonObject.put("message", "User Deleted Successfully.");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jsonObject.toString();

    }

    @Override
    public List<CheckInOut> findAll() {
        String sql = "SELECT * FROM check_in_out";

        List<CheckInOut> checkInOuts = jtm.query(sql, new BeanPropertyRowMapper(CheckInOut.class));

        return checkInOuts;
    }

    @Override
    @CacheEvict(value = "checkInOutCache", allEntries = true)
    public void refreshCache() {

    }
}
