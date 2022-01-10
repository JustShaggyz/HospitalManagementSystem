package com.informatics.cscb869hospital.dto.doctor;

import com.informatics.cscb869hospital.data.entity.Hospital;
import com.informatics.cscb869hospital.data.entity.Patient;
import com.informatics.cscb869hospital.data.entity.Specialty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class DoctorHospitalDTO {
    private long id;
    private String egn;
    private String doctorId;
    private Specialty specialty;
    private boolean isGp;
    private String name;
    private Hospital hospital;
    private int numberOfPatients;
    private List<Patient> patients;
}
