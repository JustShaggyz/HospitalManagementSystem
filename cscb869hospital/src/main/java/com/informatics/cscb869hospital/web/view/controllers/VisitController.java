package com.informatics.cscb869hospital.web.view.controllers;

import com.informatics.cscb869hospital.dto.record.CreateRecordDTO;
import com.informatics.cscb869hospital.dto.record.RecordDTO;
import com.informatics.cscb869hospital.dto.visit.CreateVisitDTO;
import com.informatics.cscb869hospital.dto.visit.VisitDTO;
import com.informatics.cscb869hospital.services.*;
import com.informatics.cscb869hospital.web.view.model.record.CreateRecordViewModel;
import com.informatics.cscb869hospital.web.view.model.record.RecordViewModel;
import com.informatics.cscb869hospital.web.view.model.visit.CreateVisitViewModel;
import com.informatics.cscb869hospital.web.view.model.visit.VisitViewModel;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@AllArgsConstructor
@RequestMapping("/visits")
public class VisitController {
    private final ModelMapper modelMapper;
    private final RecordService recordService;
    private final HospitalService hospitalService;
    private final DoctorService doctorService;
    private final VisitService visitService;


    @GetMapping("/create-visit")
    public String showCreateVisitForm(Model model) {
        model.addAttribute("hospitals", hospitalService.getHospitals());
        model.addAttribute("doctors", doctorService.getAllDoctorHospitals());
        model.addAttribute("records", recordService.getRecords());
        model.addAttribute("visit", new CreateVisitViewModel());
        return "/visits/create-visit";
    }

    @PostMapping("/create")
    public String createVisit(@Valid @ModelAttribute("visit") CreateVisitViewModel visit,
                               BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("hospitals", hospitalService.getHospitals());
            model.addAttribute("doctors", doctorService.getAllDoctorHospitals());
            model.addAttribute("records", recordService.getRecords());
            return "/visits/create-visit";
        }
        visitService.create(modelMapper.map(visit, CreateVisitDTO.class));
        return "redirect:/records";
    }


    private VisitViewModel convertToVisitViewModel(VisitDTO visitDTO) {
        return modelMapper.map(visitDTO, VisitViewModel.class);
    }


    @GetMapping("/search-diagnose")
    public String processSearchDiagnoseForm() {
        return "/visits/search-diagnose";
    }

    @GetMapping("/diagnose")
    public String getPatientsByDiagnose(Model model, @RequestParam String diagnose) {
        List<VisitViewModel> visits = visitService
                .getVisitsByDiagnose(diagnose)
                .stream()
                .map(this::convertToVisitViewModel)
                .collect(Collectors.toList());
        for (VisitViewModel visit: visits) {
            visit.setPatient(visit.getRecord().getPatient());
        }
        model.addAttribute("visits", visits);
        return "/visits/visits";
    }
}
