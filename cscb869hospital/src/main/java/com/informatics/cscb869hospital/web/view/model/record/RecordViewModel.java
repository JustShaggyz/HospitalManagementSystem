package com.informatics.cscb869hospital.web.view.model.record;

import com.informatics.cscb869hospital.data.entity.Hospital;
import com.informatics.cscb869hospital.data.entity.Patient;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class RecordViewModel {
    private long id;
    private Patient patient;
    private Hospital hospital;
}
