package com.informatics.cscb869hospital.services.implementations;

import com.informatics.cscb869hospital.data.entity.Record;
import com.informatics.cscb869hospital.data.repository.RecordRepository;
import com.informatics.cscb869hospital.dto.record.CreateRecordDTO;
import com.informatics.cscb869hospital.dto.record.RecordDTO;
import com.informatics.cscb869hospital.services.RecordService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import javax.validation.constraints.Min;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class RecordServiceImplementation implements RecordService {
    private final RecordRepository  recordRepository;
    private final ModelMapper modelMapper;

    @Override
    public List<RecordDTO> getRecords() {
        return recordRepository.findAll().stream()
                .map(this::convertToRecordDTO)
                .collect(Collectors.toList());
    }

    @Override
    public RecordDTO getRecord(@Min(1) long id) {
        return modelMapper.map(recordRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid record id: " + id)), RecordDTO.class);
    }

    @Override
    public Record create(CreateRecordDTO record) {
        return recordRepository.save(modelMapper.map(record, Record.class));
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

    private RecordDTO convertToRecordDTO(Record record) {
        return modelMapper.map(record, RecordDTO.class);
    }
}
