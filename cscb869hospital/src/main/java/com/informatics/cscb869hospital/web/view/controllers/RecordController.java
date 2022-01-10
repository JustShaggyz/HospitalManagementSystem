package com.informatics.cscb869hospital.web.view.controllers;

import com.informatics.cscb869hospital.dto.patient.CreatePatientDTO;
import com.informatics.cscb869hospital.dto.patient.PatientDTO;
import com.informatics.cscb869hospital.dto.record.CreateRecordDTO;
import com.informatics.cscb869hospital.dto.record.RecordDTO;
import com.informatics.cscb869hospital.services.HospitalService;
import com.informatics.cscb869hospital.services.PatientService;
import com.informatics.cscb869hospital.services.RecordService;
import com.informatics.cscb869hospital.web.view.model.patient.CreatePatientViewModel;
import com.informatics.cscb869hospital.web.view.model.patient.PatientViewModel;
import com.informatics.cscb869hospital.web.view.model.record.CreateRecordViewModel;
import com.informatics.cscb869hospital.web.view.model.record.RecordViewModel;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@Controller
@AllArgsConstructor
@RequestMapping("/records")
public class RecordController {
    private final ModelMapper modelMapper;
    private final RecordService recordService;
    private final HospitalService hospitalService;
    private final PatientService patientService;

    @RequestMapping
    public String processToGetRecord(Model model) {
        model.addAttribute("record", new CreateRecordViewModel());
        return "/records/get-record";
    }


//    @GetMapping("/{id}")
//    public String getRecord(Model model, @PathVariable Long id) {
//        model.addAttribute("record", modelMapper.map(recordService.getRecord(id), RecordViewModel.class));
//        return "/records/record";
//    }
@PostMapping("/getrecord")
public String getRecord(@Valid @ModelAttribute("record") CreateRecordViewModel record,
    BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return "/records";
        }
        Long id = record.getId();
        model.addAttribute("record", modelMapper.map(recordService.getRecord(id), RecordViewModel.class));
        return "/records/record";

}


    @GetMapping("/create-record")
    public String showCreateRecordForm(Model model) {
        model.addAttribute("patients", patientService.getAllPatients());
        model.addAttribute("hospitals", hospitalService.getHospitals());
        model.addAttribute("record", new CreateRecordViewModel());
        return "/records/create-record";
    }

    @PostMapping("/create")
    public String createRecord(@Valid @ModelAttribute("record") CreateRecordViewModel record,
                                BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("patients", patientService.getAllPatients());
            model.addAttribute("hospitals", hospitalService.getHospitals());
            return "/records/create-record";
        }
        recordService.create(modelMapper.map(record, CreateRecordDTO.class));
        return "redirect:/records";
    }


    private RecordViewModel convertToRecordViewModel(RecordDTO recordDTO) {
        return modelMapper.map(recordDTO, RecordViewModel.class);
    }
}
