package com.informatics.cscb869hospital.web.view.model.doctor;

import com.informatics.cscb869hospital.data.entity.Hospital;
import com.informatics.cscb869hospital.data.entity.Specialty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class CreateDoctorViewModel {
    private long id;
    @Pattern(regexp="^(\\s*|\\d{10})$", message = "egn must be exactly 10 digits")
    private String egn;
    private String doctorId;
    @NotNull
    private Specialty specialty;
    private boolean isGp;
    @NotBlank
    @Size(min = 1, max = 100)
    private String name;
    @NotNull
    private Hospital hospital;
}
