package com.informatics.cscb869hospital.services.implementations;

import com.informatics.cscb869hospital.data.entity.Doctor;
import com.informatics.cscb869hospital.data.repository.DoctorRepository;
import com.informatics.cscb869hospital.services.DoctorService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class DoctorServiceImplementation implements DoctorService {
    private final DoctorRepository doctorRepository;

    @Override
    public List<Doctor> getDoctors(){
        return doctorRepository.findAll();
    }

    @Override
    public Doctor create(Doctor doctor) {
        return doctorRepository.save(doctor);
    }
}
