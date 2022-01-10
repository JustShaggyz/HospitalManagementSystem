package com.informatics.cscb869hospital.web.view.controllers;

import com.informatics.cscb869hospital.data.entity.Specialty;
import com.informatics.cscb869hospital.dto.doctor.CreateDoctorDTO;
import com.informatics.cscb869hospital.dto.hospital.CreateHospitalDTO;
import com.informatics.cscb869hospital.dto.hospital.HospitalDTO;
import com.informatics.cscb869hospital.dto.patient.CreatePatientDTO;
import com.informatics.cscb869hospital.dto.patient.PatientDTO;
import com.informatics.cscb869hospital.services.DoctorService;
import com.informatics.cscb869hospital.services.HospitalService;
import com.informatics.cscb869hospital.services.PatientService;
import com.informatics.cscb869hospital.web.view.model.doctor.CreateDoctorViewModel;
import com.informatics.cscb869hospital.web.view.model.hospital.CreateHospitalViewModel;
import com.informatics.cscb869hospital.web.view.model.hospital.HospitalViewModel;
import com.informatics.cscb869hospital.web.view.model.patient.CreatePatientViewModel;
import com.informatics.cscb869hospital.web.view.model.patient.PatientViewModel;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@AllArgsConstructor
@RequestMapping("/patients")
public class PatientController {
    private final HospitalService hospitalService;
    private final DoctorService doctorService;
    private final PatientService patientService;
    private final ModelMapper modelMapper;

    @GetMapping
    public String getPatients(Model model) {
        final List<PatientViewModel> patients = patientService.getAllPatients()
                .stream()
                .map(this::convertToPatientViewModel)
                .collect(Collectors.toList());
        model.addAttribute("patients", patients);
        return "/patients/patients";
    }


    @GetMapping("/create-patient")
    public String showCreatePatientForm(Model model) {
        model.addAttribute("doctors", doctorService.getAllDoctorHospitals());
        model.addAttribute("hospitals", hospitalService.getHospitals());
        model.addAttribute("patient", new CreatePatientViewModel());
        return "/patients/create-patient";
    }

    @PostMapping("/create")
    public String createPatient(@Valid @ModelAttribute("patient") CreatePatientViewModel patient,
                               BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("doctors", doctorService.getAllDoctorHospitals());
            model.addAttribute("hospitals", hospitalService.getHospitals());
            return "/patients/create-patient";
        }
        patientService.create(modelMapper.map(patient, CreatePatientDTO.class));
        return "redirect:/patients";
    }

    @GetMapping("/delete/{id}")
    public String processProgramForm(@PathVariable int id) {
        patientService.deletePatient(id);
        return "redirect:/patients";
    }

    private PatientViewModel convertToPatientViewModel(PatientDTO patientDTO) {
        return modelMapper.map(patientDTO, PatientViewModel.class);
    }
}
