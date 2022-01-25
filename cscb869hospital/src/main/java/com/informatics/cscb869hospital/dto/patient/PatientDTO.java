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
public class PatientDTO {
    private long id;
    private String name;
    private String egn;
    private boolean isHealthInsured;
    private Hospital hospital;
    private Doctor gp;
}
