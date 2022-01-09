package com.informatics.cscb869hospital.data.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@MappedSuperclass
public abstract class Person extends BaseEntity{
    private String name;
    private String egn;
}
