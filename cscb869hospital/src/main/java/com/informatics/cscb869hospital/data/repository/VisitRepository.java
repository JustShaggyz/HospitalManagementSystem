package com.informatics.cscb869hospital.data.repository;

import com.informatics.cscb869hospital.data.entity.Visit;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VisitRepository extends JpaRepository<Visit, Long> {
}
