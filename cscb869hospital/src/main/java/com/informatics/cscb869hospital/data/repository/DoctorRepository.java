package com.informatics.cscb869hospital.data.repository;

import com.informatics.cscb869hospital.data.entity.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DoctorRepository extends JpaRepository<Doctor, Long> {

}
