package com.informatics.cscb869hospital.dto.visit;

import com.informatics.cscb869hospital.data.entity.Doctor;
import com.informatics.cscb869hospital.data.entity.Record;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class CreateVisitDTO {
    private Record record;
    private Doctor doctor;
    private LocalDate visitationDate;
    private String diagnose;
    private String treatment;
    private int sickLeave;
}
