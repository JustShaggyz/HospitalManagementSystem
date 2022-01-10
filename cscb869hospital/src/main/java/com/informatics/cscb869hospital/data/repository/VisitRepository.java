package com.informatics.cscb869hospital.data.repository;

import com.informatics.cscb869hospital.data.entity.Visit;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface VisitRepository extends JpaRepository<Visit, Long> {
    List<Visit> findAllByDiagnose(String diagnose);
}
