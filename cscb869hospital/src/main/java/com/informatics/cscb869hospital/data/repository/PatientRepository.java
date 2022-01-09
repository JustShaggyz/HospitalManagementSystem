package com.informatics.cscb869hospital.data.repository;

import com.informatics.cscb869hospital.data.entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository<Patient, Long> {
}
