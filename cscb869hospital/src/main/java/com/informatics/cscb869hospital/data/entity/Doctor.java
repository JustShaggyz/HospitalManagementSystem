package com.informatics.cscb869hospital.data.entity;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonAppend;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "doctor")
public class Doctor extends Person{
    private String doctorId;
    @Enumerated
    private Specialty specialty;
    private boolean isGp;

    @OneToMany(mappedBy = "gp")
    @JsonIgnoreProperties("gp")
    private List<Patient> patients;
}
