package com.attendance.controller;

import com.attendance.model.CheckInOut;
import com.attendance.service.CheckInOutService;
import com.attendance.service.PegawaiService;
import com.attendance.service.ShiftService;
import com.attendance.utils.ErrorUtils;
import com.attendance.utils.MethodUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.jasperreports.JasperReportsPdfView;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Tobitoi on 8/24/17.
 */

@Controller
@RequestMapping("/checkInOut")

public class CheckInOutController {

    @Autowired
    private ApplicationContext appContext;
    private CheckInOutService checkInOutService;
    private PegawaiService pegawaiService;
    private ShiftService shiftService;



    @Autowired
    public CheckInOutController(CheckInOutService checkInOutService, PegawaiService pegawaiService, ShiftService shiftService) {
        this.checkInOutService = checkInOutService;
        this.pegawaiService = pegawaiService;
        this.shiftService = shiftService;

    }

    @GetMapping("/form")
    public String Form(Model model) {
        model.addAttribute("isNew", false);
        model.addAttribute("pegawais", pegawaiService.pegawaiList());
        model.addAttribute("shifts", shiftService.shiftList());
        return "checkInOut/form";
    }

    @GetMapping("/edit/{id}")
    public String checkInOutOne(@PathVariable Long id, Model model) {
        model.addAttribute("isNew", false);
        model.addAttribute("pegawais", pegawaiService.pegawaiList());
        model.addAttribute("shifts", shiftService.shiftList());
        model.addAttribute("checkInOutForm", checkInOutService.findOne(id));
        model.addAttribute("pegawaiss",pegawaiService.findOne(id));
        return "checkInOut/form";
    }


    @GetMapping(value = "/delete/{id}", produces= MediaType.APPLICATION_JSON_VALUE)
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public @ResponseBody
    String checkInOut(@PathVariable Long id) {
            return checkInOutService.deleteCheckInOut(id);
        }
    @PostMapping(value = "/add", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody String addCheckInOut(@Valid @RequestBody CheckInOut checkInOut, BindingResult result) {
        if(result.hasErrors()) {
           return ErrorUtils.customErrors(result.getAllErrors());

        } else {
            return checkInOutService.addCheckInOut(checkInOut);
        }
    }

    @GetMapping("/list/{id}")
    public CheckInOut findOne(@PathVariable Long id) {
            return checkInOutService.findOne(id);
        }


    @GetMapping("/list")
    public String checkInOutList(Model model,Pageable pageable) {
        Page<CheckInOut> pages = checkInOutService.findAll(pageable);
        model.addAttribute("checkInOuts", pages.getContent());
        MethodUtils.pageModel(model,pages);
        return "checkInOut/list";
    }

    @GetMapping("/refresh")
    public String refreshCache(Model model, Pageable pageable){
        checkInOutService.refreshCache();
        Page<CheckInOut> pages = checkInOutService.findAll(pageable);
        model.addAttribute("checkInOuts", pages.getContent());
        MethodUtils.pageModel(model,pages);
        return "checkInOut/list";
    }

    @GetMapping(path = "/report")
    public ModelAndView report() {

        JasperReportsPdfView view = new JasperReportsPdfView();
        view.setUrl("classpath:report2.jrxml");
        view.setApplicationContext(appContext);

        Map<String, Object> params = new HashMap<>();
        params.put("datasource", checkInOutService.checkInOutList());

        return new ModelAndView(view, params);
    }

}
