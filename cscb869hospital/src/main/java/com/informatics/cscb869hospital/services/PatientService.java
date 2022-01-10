package com.informatics.cscb869hospital.services;

import com.informatics.cscb869hospital.data.entity.Doctor;
import com.informatics.cscb869hospital.data.entity.Patient;
import com.informatics.cscb869hospital.dto.doctor.CreateDoctorDTO;
import com.informatics.cscb869hospital.dto.doctor.DoctorHospitalDTO;
import com.informatics.cscb869hospital.dto.patient.CreatePatientDTO;
import com.informatics.cscb869hospital.dto.patient.PatientDTO;

import java.util.List;

public interface PatientService {
    List<PatientDTO> getAllPatients();
    Patient create(CreatePatientDTO patient);
    Patient updatePatient(long id, Patient patient);
    void deletePatient(long id);
}
