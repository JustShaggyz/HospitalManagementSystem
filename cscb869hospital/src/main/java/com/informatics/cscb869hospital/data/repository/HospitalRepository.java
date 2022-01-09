package com.informatics.cscb869hospital.data.repository;

import com.informatics.cscb869hospital.data.entity.Hospital;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HospitalRepository extends JpaRepository<Hospital, Long> {

}
