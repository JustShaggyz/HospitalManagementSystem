package com.informatics.cscb869hospital.services.implementations;

import com.informatics.cscb869hospital.data.entity.Visit;
import com.informatics.cscb869hospital.data.repository.VisitRepository;
import com.informatics.cscb869hospital.dto.visit.CreateVisitDTO;
import com.informatics.cscb869hospital.dto.visit.VisitDTO;
import com.informatics.cscb869hospital.services.VisitService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class VisitServiceImplementation implements VisitService {
    private final VisitRepository visitRepository;
    private final ModelMapper modelMapper;

    @Override
    public Visit create(CreateVisitDTO visit) {
        visit.setVisitationDate(LocalDate.now());
        return visitRepository.save(modelMapper.map(visit, Visit.class));
    }

    @Override
    public List<VisitDTO> getVisits() {
        return visitRepository.findAll().stream()
                .map(this::convertToVisitDTO)
                .collect(Collectors.toList());
    }

    private VisitDTO convertToVisitDTO(Visit visit) {
        return modelMapper.map(visit, VisitDTO.class);
    }

}
