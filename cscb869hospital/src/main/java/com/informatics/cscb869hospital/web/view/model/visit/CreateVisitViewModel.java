package com.informatics.cscb869hospital.web.view.model.visit;

import com.informatics.cscb869hospital.data.entity.Doctor;
import com.informatics.cscb869hospital.data.entity.Record;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class CreateVisitViewModel {
    @NotNull
    private Record record;
    @NotNull
    private Doctor doctor;
    private LocalDate visitationDate;
    @NotBlank
    @Size(min = 1, max = 100)
    private String diagnose;
    @NotBlank
    @Size(min = 1, max = 100)
    private String treatment;
    @NotNull
    @Max(value = 30)
    private int sickLeave;
}
