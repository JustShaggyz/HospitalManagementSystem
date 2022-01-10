package com.informatics.cscb869hospital.web.view.model.patient;

import com.informatics.cscb869hospital.data.entity.Doctor;
import com.informatics.cscb869hospital.data.entity.Hospital;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreatePatientViewModel {
    private long id;
    private String name;
    private String egn;
    private String isHealthInsured;
    private Hospital hospital;
    private Doctor gp;
}
