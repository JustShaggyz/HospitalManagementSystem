package com.informatics.cscb869hospital.services;

import com.informatics.cscb869hospital.data.entity.Doctor;

import java.util.List;

public interface DoctorService {
    List<Doctor> getDoctors();
    Doctor getDoctor(long id);
    Doctor create(Doctor doctor);
    Doctor updateDoctor(long id, Doctor doctor);
    void deleteDoctor(long id);
}
