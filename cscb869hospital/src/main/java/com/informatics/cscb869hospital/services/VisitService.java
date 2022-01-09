package com.informatics.cscb869hospital.services;

import com.informatics.cscb869hospital.data.entity.Visit;

public interface VisitService {
    Visit create(Visit visit);
    Visit getVisit(long id);
    Visit updateVisit(long id, Visit visit);
    void deleteVisit(long id);
}
