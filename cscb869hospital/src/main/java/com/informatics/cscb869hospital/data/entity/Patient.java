package com.informatics.cscb869hospital.data.entity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "patient")
public class Patient extends Person{
    private boolean isHealthInsured;
    @ManyToOne
    @JoinColumn(name = "hospital_id")
    private Hospital hospital;
    @ManyToOne
    @JoinColumn(name = "doctor_id")
    private Doctor gp;


}
