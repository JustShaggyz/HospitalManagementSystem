package com.informatics.cscb869hospital.services.implementations;

import com.informatics.cscb869hospital.data.entity.Record;
import com.informatics.cscb869hospital.data.repository.RecordRepository;
import com.informatics.cscb869hospital.services.RecordService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class RecordServiceImplementation implements RecordService {
    private final RecordRepository  recordRepository;

    @Override
    public List<Record> getRecords() {
        return recordRepository.findAll();
    }

    @Override
    public Record getRecord(long id) {
        return recordRepository.getById(id);
    }

    @Override
    public Record create(Record record) {
        List<Record> records = this.getRecords();
        return records.contains(record) ? null : recordRepository.save(record);
    }

    @Override
    public Record updateRecord(long id, Record record) {
        record.setId(id);
        return recordRepository.save(record);
    }

    @Override
    public void deleteRecord(long id) {
        Record record = recordRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid hospital id: " + id));
        recordRepository.deleteById(id);
    }
}
