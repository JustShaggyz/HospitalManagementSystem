package com.informatics.cscb869hospital.services.implementations;

import com.informatics.cscb869hospital.data.entity.Visit;
import com.informatics.cscb869hospital.data.repository.VisitRepository;
import com.informatics.cscb869hospital.services.VisitService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class VisitServiceImplementation implements VisitService {
    private final VisitRepository visitRepository;
    @Override
    public Visit create(Visit visit) {
        return visitRepository.save(visit);
    }

    @Override
    public Visit getVisit(long id) {
        return visitRepository.getById(id);
    }

    @Override
    public Visit updateVisit(long id, Visit visit) {
        visit.setId(id);
        return visitRepository.save(visit);
    }

    @Override
    public void deleteVisit(long id) {
        Visit visit = visitRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid hospital id: " + id));
        visitRepository.deleteById(id);
    }
}
