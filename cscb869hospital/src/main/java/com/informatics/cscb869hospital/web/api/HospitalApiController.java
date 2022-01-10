package com.informatics.cscb869hospital.web.api;

import com.informatics.cscb869hospital.data.entity.Doctor;
import com.informatics.cscb869hospital.data.entity.Hospital;
import com.informatics.cscb869hospital.dto.hospital.CreateHospitalDTO;
import com.informatics.cscb869hospital.dto.hospital.HospitalDTO;
import com.informatics.cscb869hospital.dto.hospital.UpdateHospitalDTO;
import com.informatics.cscb869hospital.services.DoctorService;
import com.informatics.cscb869hospital.services.HospitalService;
import com.informatics.cscb869hospital.web.view.model.hospital.CreateHospitalViewModel;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@AllArgsConstructor
public class HospitalApiController {
    private final HospitalService hospitalService;
    private final DoctorService doctorService;
    private final ModelMapper modelMapper;

    @GetMapping("/api/hospitals")
    public List<HospitalDTO> getHospitals() {
        return hospitalService.getHospitals();
    }

    @RequestMapping("/api/hospitals/{id}")
    public HospitalDTO getHospital(@PathVariable("id") int id) {
        return hospitalService.getHospital(id);
    }

    @PostMapping("/api/hospitals")
    public Hospital createHospital(@RequestBody @Valid CreateHospitalViewModel hospital) {
        return hospitalService.create(modelMapper.map(hospital, CreateHospitalDTO.class));
    }

    @PutMapping("/api/hospitals/{id}")
    public Hospital updateHospital(@PathVariable("id") int id,@RequestBody UpdateHospitalDTO hospital) {
        return hospitalService.updateHospital(id, modelMapper.map(hospital, UpdateHospitalDTO.class));
    }

    @DeleteMapping("/api/hospitals/{id}")
    public void deleteHospital(@PathVariable long id) {
        hospitalService.deleteHospital(id);
    }

    ////////////////////////////////
//    @GetMapping("/api/doctors")
//    public List<Doctor> getDoctors() {
//        return doctorService.getDoctors();
//    }
//
//    @PostMapping("/api/doctors")
//    public Doctor createDoctor(@RequestBody Doctor doctor) {
//        return doctorService.create(doctor);
//    }
}
