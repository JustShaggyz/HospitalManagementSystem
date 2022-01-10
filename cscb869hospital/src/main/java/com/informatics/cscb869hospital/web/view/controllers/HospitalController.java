package com.informatics.cscb869hospital.web.view.controllers;

import com.informatics.cscb869hospital.dto.hospital.CreateHospitalDTO;
import com.informatics.cscb869hospital.dto.hospital.HospitalDTO;
import com.informatics.cscb869hospital.services.HospitalService;
import com.informatics.cscb869hospital.web.view.model.hospital.CreateHospitalViewModel;
import com.informatics.cscb869hospital.web.view.model.hospital.HospitalViewModel;
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
@RequestMapping("/hospitals")
public class HospitalController {

    private HospitalService hospitalService;
    private final ModelMapper modelMapper;


    @GetMapping
    public String getHospitals(Model model) {
        final List<HospitalViewModel> hospitals = hospitalService.getHospitals()
                .stream()
                .map(this::convertToHospitalViewModel)
                .collect(Collectors.toList());
        model.addAttribute("hospitals", hospitals);
        return "/hospitals/hospitals";
    }


    @GetMapping("/create-hospital")
    public String showCreateHospitalForm(Model model) {
        model.addAttribute("hospital", new CreateHospitalViewModel());
        return "/hospitals/create-hospital";
    }

    @PostMapping("/create")
    public String createHospital(@Valid @ModelAttribute("hospital") CreateHospitalViewModel hospital,
                               BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "/hospitals/create-hospital";
        }
        hospitalService.create(modelMapper.map(hospital, CreateHospitalDTO.class));
        return "redirect:/hospitals";
    }

    @GetMapping("/delete/{id}")
    public String processProgramForm(@PathVariable int id) {
        hospitalService.deleteHospital(id);
        return "redirect:/hospitals";
    }

    private HospitalViewModel convertToHospitalViewModel(HospitalDTO hospitalDTO) {
        return modelMapper.map(hospitalDTO, HospitalViewModel.class);
    }

}
