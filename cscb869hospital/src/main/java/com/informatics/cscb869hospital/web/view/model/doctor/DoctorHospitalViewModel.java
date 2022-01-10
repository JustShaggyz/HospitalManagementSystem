package com.informatics.cscb869hospital.web.view.model.doctor;

import com.informatics.cscb869hospital.data.entity.Hospital;
import com.informatics.cscb869hospital.data.entity.Specialty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DoctorHospitalViewModel {
    private long id;
    private String egn;
    private String doctorId;
    private Specialty specialty;
    private boolean isGp;
    private String name;
    private Hospital hospital;
    private int numberOfPatients;
}
