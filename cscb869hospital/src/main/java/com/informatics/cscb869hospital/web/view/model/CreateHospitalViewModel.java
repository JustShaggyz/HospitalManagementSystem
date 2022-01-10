package com.informatics.cscb869hospital.web.view.model;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Getter
@Setter
public class CreateHospitalViewModel {

    @NotBlank
    @Size(min = 1, max = 30, message = "Max 30 characters!")
    private String name;
}
