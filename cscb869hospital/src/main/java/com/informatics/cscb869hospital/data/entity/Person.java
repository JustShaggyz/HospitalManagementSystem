package com.informatics.cscb869hospital.data.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Objects;

@Getter
@Setter
@NoArgsConstructor
@MappedSuperclass
public abstract class Person extends BaseEntity{
    private String name;
    private String egn;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Objects.equals(egn, person.egn);
    }

    @Override
    public int hashCode() {
        return Objects.hash(egn);
    }
}
