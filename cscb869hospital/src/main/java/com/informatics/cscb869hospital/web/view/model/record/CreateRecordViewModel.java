package com.informatics.cscb869hospital.web.view.model.record;

import com.informatics.cscb869hospital.data.entity.Hospital;
import com.informatics.cscb869hospital.data.entity.Patient;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.NotNull;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class CreateRecordViewModel {
    private long id;
    @NotNull
    private Patient patient;
    @NotNull
    private Hospital hospital;
}
