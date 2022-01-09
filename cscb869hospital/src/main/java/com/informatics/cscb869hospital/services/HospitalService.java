package com.informatics.cscb869hospital.services;

import com.informatics.cscb869hospital.data.entity.Hospital;

import java.util.List;

public interface HospitalService {
    List<Hospital> getHospitals();
    Hospital getHospital();
    Hospital create(Hospital hospital);
    Hospital updateHospital(long id, Hospital hospital);
    void deleteHospital(long id);
}
