package com.informatics.cscb869hospital.data.repository;

import com.informatics.cscb869hospital.data.entity.Record;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RecordRepository extends JpaRepository<Record, Long> {
}
