package com.informatics.cscb869hospital.services.implementations;

import com.informatics.cscb869hospital.data.entity.Hospital;
import com.informatics.cscb869hospital.data.repository.HospitalRepository;
import com.informatics.cscb869hospital.services.HospitalService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class HospitalServiceImplementation implements HospitalService {
    private final HospitalRepository hospitalRepository;

    @Override
    public List<Hospital> getHospitals(){
        return hospitalRepository.findAll();
    }
    @Override
    public Hospital getHospital(long id) {
        return hospitalRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid hospital id: " + id));
    }
    @Override
    public Hospital create(Hospital hospital) {
        return hospitalRepository.save(hospital);
    }
    @Override
    public Hospital updateHospital(long id, Hospital hospital) {
        hospital.setId(id);
        return hospitalRepository.save(hospital);
    }
    @Override
    public void deleteHospital(long id) {
        Hospital hospital = hospitalRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid hospital id: " + id));
        hospitalRepository.deleteById(id);
    }

}
