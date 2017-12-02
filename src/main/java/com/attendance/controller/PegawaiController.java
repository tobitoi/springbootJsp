package com.attendance.controller;

/**
 * Created by Tobitoi on 8/23/17.
 */


import com.attendance.model.Pegawai;
import com.attendance.service.DepartmentService;
import com.attendance.service.PegawaiService;
import com.attendance.utils.ErrorUtils;
import com.attendance.utils.MethodUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;


import javax.validation.Valid;

@Controller
@RequestMapping("/pegawai")
public class PegawaiController {

    private PegawaiService pegawaiService;
    private DepartmentService departmentService;

    @Autowired
    public PegawaiController(PegawaiService pegawaiService, DepartmentService departmentService) {
        this.pegawaiService = pegawaiService;
        this.departmentService = departmentService;

    }

    @GetMapping("/form")
    public String pegawaiForm(Model model) {
        model.addAttribute("isNew", true);
        model.addAttribute("pegawaiForm", new Pegawai());
        model.addAttribute("departments", departmentService.departmentList());
        return "pegawai/form";
    }

    @GetMapping("/edit/{id}")
    public String pegawaiOne(@PathVariable Long id, Model model) {
        model.addAttribute("isNew", false);
        model.addAttribute("pegawaiForm", pegawaiService.findOne(id));
        model.addAttribute("departments", departmentService.departmentList());
        return "pegawai/form";
    }

    @GetMapping(value = "/delete/{id}", produces= MediaType.APPLICATION_JSON_VALUE)
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public @ResponseBody
    String pegawaiDelete(@PathVariable Long id) {
        return pegawaiService.deletePegawai(id);
    }

    @PostMapping(value = "/add", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody String pegawaiAdd(@Valid @RequestBody Pegawai pegawai, BindingResult result) {
        if(result.hasErrors()) {
            return ErrorUtils.customErrors(result.getAllErrors());
        } else {
            return pegawaiService.addPegawai(pegawai);
        }
    }

    @GetMapping("/list/{id}")
    public Pegawai findOne(@PathVariable Long id) {
        return pegawaiService.findOne(id);
    }

    @GetMapping("/list")
    public String pegawaiList(Model model,Pageable pageable) {
        Page<Pegawai> pages = pegawaiService.findAll(pageable);
        model.addAttribute("pegawais", pages.getContent());
        MethodUtils.pageModel(model,pages);
        return "pegawai/list";
    }

    @GetMapping("/refresh")
    public String refreshCache(Model model, Pageable pageable){
        pegawaiService.refreshCache();
        Page<Pegawai> pages = pegawaiService.findAll(pageable);
        model.addAttribute("pegawais", pages.getContent());
        MethodUtils.pageModel(model,pages);
        return "pegawai/list";
    }



}

