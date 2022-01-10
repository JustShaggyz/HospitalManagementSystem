package com.informatics.cscb869hospital.services;
import com.informatics.cscb869hospital.data.entity.Doctor;
import com.informatics.cscb869hospital.data.entity.Record;
import com.informatics.cscb869hospital.dto.doctor.CreateDoctorDTO;
import com.informatics.cscb869hospital.dto.doctor.DoctorHospitalDTO;
import com.informatics.cscb869hospital.dto.record.CreateRecordDTO;
import com.informatics.cscb869hospital.dto.record.RecordDTO;

import java.util.List;

public interface RecordService {
    List<RecordDTO> getRecords();
    RecordDTO getRecord(long id);
    Record create(CreateRecordDTO record);
    Record updateRecord(long id, Record record);
    void deleteRecord(long id);



}
