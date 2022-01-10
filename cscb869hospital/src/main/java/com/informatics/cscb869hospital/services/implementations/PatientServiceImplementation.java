package com.informatics.cscb869hospital.services.implementations;

import com.informatics.cscb869hospital.data.entity.Patient;
import com.informatics.cscb869hospital.data.repository.PatientRepository;
import com.informatics.cscb869hospital.dto.patient.CreatePatientDTO;
import com.informatics.cscb869hospital.dto.patient.PatientDTO;
import com.informatics.cscb869hospital.services.PatientService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class PatientServiceImplementation implements PatientService {

    private final PatientRepository patientRepository;
    private final ModelMapper modelMapper;

    @Override
    public List<PatientDTO> getAllPatients() {
        return patientRepository.findAll().stream()
                .map(this::convertToPatientDTO)
                .collect(Collectors.toList());
    }

    @Override
    public Patient create(CreatePatientDTO patient) {
        return patientRepository.save(modelMapper.map(patient, Patient.class));
    }

    @Override
    public Patient updatePatient(long id, Patient patient) {
        patient.setId(id);
        return patientRepository.save(patient);
    }

    @Override
    public void deletePatient(long id) {
        Patient patient = patientRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid patient id: " + id));
        patientRepository.deleteById(id);
    }

    private PatientDTO convertToPatientDTO(Patient patient) {
        return modelMapper.map(patient, PatientDTO.class);
    }
}
