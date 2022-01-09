package com.informatics.cscb869hospital.services;
import com.informatics.cscb869hospital.data.entity.Record;

import java.util.List;

public interface RecordService {
    List<Record> getRecords();
    Record getRecord(long id);
    Record create(Record record);
    Record updateRecord(long id, Record record);
    void deleteRecord(long id);
}
