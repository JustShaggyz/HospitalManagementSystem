package com.informatics.cscb869hospital.services;

import com.informatics.cscb869hospital.data.entity.Doctor;
import com.informatics.cscb869hospital.dto.doctor.CreateDoctorDTO;
import com.informatics.cscb869hospital.dto.doctor.DoctorHospitalDTO;

import java.util.List;

public interface DoctorService {
    List<DoctorHospitalDTO> getAllDoctorHospitals();
    Doctor create(CreateDoctorDTO doctor);
    Doctor updateDoctor(long id, Doctor doctor);
    void deleteDoctor(long id);
}
