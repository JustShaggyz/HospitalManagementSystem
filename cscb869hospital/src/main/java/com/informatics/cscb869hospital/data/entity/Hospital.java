package com.informatics.cscb869hospital.data.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "hospital")
public class Hospital extends BaseEntity{
    private String name;

    @OneToMany(mappedBy = "hospital")
    @JsonIgnoreProperties("hospital")
    private List<Patient> patients;

    @OneToMany(mappedBy = "hospital")
    @JsonIgnoreProperties("hospital")
    private List<Doctor> doctors;

}
