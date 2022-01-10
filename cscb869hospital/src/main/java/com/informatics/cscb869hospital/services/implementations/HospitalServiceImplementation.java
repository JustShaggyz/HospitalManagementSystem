package com.informatics.cscb869hospital.services.implementations;

import com.informatics.cscb869hospital.data.entity.Hospital;
import com.informatics.cscb869hospital.data.repository.HospitalRepository;
import com.informatics.cscb869hospital.dto.hospital.CreateHospitalDTO;
import com.informatics.cscb869hospital.dto.hospital.HospitalDTO;
import com.informatics.cscb869hospital.dto.hospital.UpdateHospitalDTO;
import com.informatics.cscb869hospital.services.HospitalService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class HospitalServiceImplementation implements HospitalService {
    private final HospitalRepository hospitalRepository;

    private final ModelMapper modelMapper;


    @Override
    public List<HospitalDTO> getHospitals(){
        return hospitalRepository.findAll().stream()
                .map(this::convertToHospitalDTO)
                .collect(Collectors.toList());
    }


    @Override
    public HospitalDTO getHospital(@Min(1) long id) {
        return modelMapper.map(hospitalRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid hospital id: " + id)), HospitalDTO.class);
    }

    @Override
    public Hospital create(@Valid CreateHospitalDTO createHospitalDTO) {
        return hospitalRepository.save(modelMapper.map(createHospitalDTO, Hospital.class));
    }

    @Override
    public Hospital updateHospital(long id, UpdateHospitalDTO updateHospitalDTO) {
        Hospital hospital = modelMapper.map(updateHospitalDTO, Hospital.class);
        hospital.setId(id);
        return hospitalRepository.save(hospital);
    }

    @Override
    public void deleteHospital(long id) {
        Hospital hospital = hospitalRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid hospital id: " + id));
        hospitalRepository.deleteById(id);
    }

    private HospitalDTO convertToHospitalDTO(Hospital hospital) {
        return modelMapper.map(hospital, HospitalDTO.class);
    }

}
