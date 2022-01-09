package com.informatics.cscb869hospital.data.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.print.Doc;
import java.util.List;
import java.util.Objects;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "record")
public class Record extends BaseEntity{
    @OneToOne
    private Patient patient;

    @OneToMany(mappedBy = "record")
    @JsonIgnoreProperties("record")
    private List<Visit> visits;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Record record = (Record) o;
        return patient.equals(record.patient);
    }

}
