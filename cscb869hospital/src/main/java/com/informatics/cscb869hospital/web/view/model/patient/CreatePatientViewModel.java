package com.informatics.cscb869hospital.web.view.model.patient;

import com.informatics.cscb869hospital.data.entity.Doctor;
import com.informatics.cscb869hospital.data.entity.Hospital;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Getter
@Setter
public class CreatePatientViewModel {
    private long id;
    @NotBlank
    @Size(min = 1, max = 100)
    private String name;
    @Pattern(regexp="^(\\s*|\\d{10})$", message = "egn must be exactly 10 digits")
    private String egn;
    @NotBlank
    @Size(min = 1, max = 100)
    private String isHealthInsured;
    @NotNull
    private Hospital hospital;
    @NotNull
    private Doctor gp;
}
