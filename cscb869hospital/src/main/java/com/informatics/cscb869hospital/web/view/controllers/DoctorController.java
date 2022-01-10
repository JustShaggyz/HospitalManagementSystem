package com.informatics.cscb869hospital.web.view.controllers;

import com.informatics.cscb869hospital.data.entity.Specialty;
import com.informatics.cscb869hospital.dto.doctor.CreateDoctorDTO;
import com.informatics.cscb869hospital.dto.doctor.DoctorHospitalDTO;
import com.informatics.cscb869hospital.services.DoctorService;
import com.informatics.cscb869hospital.services.HospitalService;
import com.informatics.cscb869hospital.web.view.model.doctor.CreateDoctorViewModel;
import com.informatics.cscb869hospital.web.view.model.doctor.DoctorHospitalViewModel;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.security.auth.Subject;
import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@AllArgsConstructor
@RequestMapping("/doctors")
public class DoctorController {
    private final HospitalService hospitalService;
    private final DoctorService doctorService;
    private final ModelMapper modelMapper;

    @GetMapping
    public String getDoctorHospitals(Model model) {
        final List<DoctorHospitalViewModel> doctors =
                doctorService.getAllDoctorHospitals().stream()
                        .map(this::convertToDoctorHospitalViewModel)
                        .collect(Collectors.toList());
        model.addAttribute("doctors", doctors);
        return "/doctors/doctor-hospital";
    }

    @GetMapping("/create-doctor")
    public String showCreateDoctorForm(Model model) {
        model.addAttribute("specialties", Specialty.values());
        model.addAttribute("hospitals", hospitalService.getHospitals());
        model.addAttribute("doctor", new CreateDoctorViewModel());
        return "/doctors/create-doctor";
    }

    @PostMapping("/create")
    public String createDoctor(@Valid @ModelAttribute("doctor") CreateDoctorViewModel doctor,
                                BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("specialties", Specialty.values());
            model.addAttribute("hospitals", hospitalService.getHospitals());
            return "/doctors/create-doctor";
        }
        doctorService.create(modelMapper.map(doctor, CreateDoctorDTO.class));
        return "redirect:/doctors";
    }

    private DoctorHospitalViewModel convertToDoctorHospitalViewModel(DoctorHospitalDTO doctor) {
        return modelMapper.map(doctor, DoctorHospitalViewModel.class);
    }
}
