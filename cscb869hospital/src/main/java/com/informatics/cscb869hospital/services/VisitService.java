package com.informatics.cscb869hospital.services;

import com.informatics.cscb869hospital.data.entity.Visit;
import com.informatics.cscb869hospital.dto.visit.CreateVisitDTO;
import com.informatics.cscb869hospital.dto.visit.VisitDTO;

import java.util.List;

public interface VisitService {
    Visit create(CreateVisitDTO visit);
    List<VisitDTO> getVisits();
    List<VisitDTO> getVisitsByDiagnose(String diagnose);
}
