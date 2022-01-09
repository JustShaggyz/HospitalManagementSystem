package com.informatics.cscb869hospital.data.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "visit")
public class Visit extends BaseEntity{
    @ManyToOne
    @JoinColumn(name = "record_id")
    private Record record;
    @OneToOne
    private Doctor doctor;
    private LocalDate visitationDate;
    private String diagnose;
    private String treatment;
    private boolean sickLeave;
    private int daysSickLeave;
}
