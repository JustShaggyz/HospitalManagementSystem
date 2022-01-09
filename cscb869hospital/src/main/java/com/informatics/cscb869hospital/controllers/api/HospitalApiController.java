package com.informatics.cscb869hospital.controllers.api;

import com.informatics.cscb869hospital.data.entity.Doctor;
import com.informatics.cscb869hospital.data.entity.Hospital;
import com.informatics.cscb869hospital.services.DoctorService;
import com.informatics.cscb869hospital.services.HospitalService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class HospitalApiController {
    private final HospitalService hospitalService;
    private final DoctorService doctorService;

    @GetMapping("/api/hospitals")
    public List<Hospital> getHospitals() {
        return hospitalService.getHospitals();
    }

    @RequestMapping("/api/hospitals/{id}")
    public Hospital getHospital(@PathVariable("id") int id) {
        return hospitalService.getHospital(id);
    }

    @PostMapping("/api/hospitals")
    public Hospital createHospital(@RequestBody Hospital hospital) {
        return hospitalService.create(hospital);
    }

    @PutMapping("/api/hospitals/{id}")
    public Hospital updateHospital(@PathVariable("id") int id,@RequestBody Hospital hospital) {
        return hospitalService.updateHospital(id, hospital);
    }

    @DeleteMapping("/api/hospitals/{id}")
    public void deleteHospital(@PathVariable long id) {
        hospitalService.deleteHospital(id);
    }

    ////////////////////////////////
    @GetMapping("/api/doctors")
    public List<Doctor> getDoctors() {
        return doctorService.getDoctors();
    }

    @PostMapping("/api/doctors")
    public Doctor createDoctor(@RequestBody Doctor doctor) {
        return doctorService.create(doctor);
    }
}
