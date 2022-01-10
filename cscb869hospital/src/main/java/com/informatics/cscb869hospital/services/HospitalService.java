package com.informatics.cscb869hospital.services;

import com.informatics.cscb869hospital.data.entity.Hospital;
import com.informatics.cscb869hospital.dto.hospital.CreateHospitalDTO;
import com.informatics.cscb869hospital.dto.hospital.HospitalDTO;
import com.informatics.cscb869hospital.dto.hospital.UpdateHospitalDTO;

import javax.validation.Valid;
import java.util.List;

public interface HospitalService {
    List<HospitalDTO> getHospitals();
    HospitalDTO getHospital(long id);
    Hospital create(@Valid CreateHospitalDTO createHospitalDTO);
    Hospital updateHospital(long id, UpdateHospitalDTO updateHospitalDTO);
    void deleteHospital(long id);
}
