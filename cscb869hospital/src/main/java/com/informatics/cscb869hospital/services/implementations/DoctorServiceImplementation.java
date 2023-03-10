package com.informatics.cscb869hospital.services.implementations;

import com.informatics.cscb869hospital.data.entity.Doctor;
import com.informatics.cscb869hospital.data.repository.DoctorRepository;
import com.informatics.cscb869hospital.dto.doctor.CreateDoctorDTO;
import com.informatics.cscb869hospital.dto.doctor.DoctorHospitalDTO;
import com.informatics.cscb869hospital.services.DoctorService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class DoctorServiceImplementation implements DoctorService {
    private final DoctorRepository doctorRepository;
    private final ModelMapper modelMapper;

    @Override
    public List<DoctorHospitalDTO> getAllDoctorHospitals() {
        List<DoctorHospitalDTO> listOfDoctors = doctorRepository.findAll().stream()
                .map(this::convertToDoctorHospitalDTO)
                .collect(Collectors.toList());
        for (DoctorHospitalDTO doctor:listOfDoctors) {
            doctor.setNumberOfPatients(doctor.getPatients().size());
        }
        return listOfDoctors;
    }

    @Override
    public Doctor create(CreateDoctorDTO doctor) {
        return doctorRepository.save(modelMapper.map(doctor, Doctor.class));
    }


    @Override
    public Doctor updateDoctor(long id, Doctor doctor) {
        doctor.setId(id);
        return doctorRepository.save(doctor);
    }

    @Override
    public void deleteDoctor(long id) {
        Doctor doctor = doctorRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid hospital id: " + id));
        doctorRepository.deleteById(id);
    }

    private DoctorHospitalDTO convertToDoctorHospitalDTO(Doctor doctor) {
        return modelMapper.map(doctor, DoctorHospitalDTO.class);
    }
}
