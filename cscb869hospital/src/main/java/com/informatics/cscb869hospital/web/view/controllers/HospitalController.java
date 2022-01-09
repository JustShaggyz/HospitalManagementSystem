package com.informatics.cscb869hospital.web.view.controllers;

import com.informatics.cscb869hospital.data.entity.Hospital;
import com.informatics.cscb869hospital.services.HospitalService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@AllArgsConstructor
@RequestMapping("/hospitals")
public class HospitalController {

    private HospitalService hospitalService;

    @GetMapping
    public String getHospitals(Model model) {
        final List<Hospital> hospitals = hospitalService.getHospitals();
        model.addAttribute("hospitals", hospitals);
        return "/hospitals/hospitals.html";
    }
}
