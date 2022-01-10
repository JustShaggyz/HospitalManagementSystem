package com.informatics.cscb869hospital.dto.patient;

import com.informatics.cscb869hospital.data.entity.Doctor;
import com.informatics.cscb869hospital.data.entity.Hospital;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class CreatePatientDTO {
    private long id;
    private String name;
    private String egn;
    private String isHealthInsured;
    private Hospital hospital;
    private Doctor gp;
}
