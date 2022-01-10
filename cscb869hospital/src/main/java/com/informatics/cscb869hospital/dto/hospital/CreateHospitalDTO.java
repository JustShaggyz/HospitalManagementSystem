package com.informatics.cscb869hospital.dto.hospital;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class CreateHospitalDTO {
    @NotBlank
    @Max(value = 30, message = "Max 30 characters")
    private String name;

}
