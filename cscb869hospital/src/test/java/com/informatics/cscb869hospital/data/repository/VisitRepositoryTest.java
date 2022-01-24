package com.informatics.cscb869hospital.data.repository;

import com.informatics.cscb869hospital.data.entity.Doctor;
import com.informatics.cscb869hospital.data.entity.Visit;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import static org.assertj.core.api.Assertions.assertThat;

import java.time.LocalDate;

@DataJpaTest
public class VisitRepositoryTest {
    @Autowired
    private TestEntityManager testEntityManager;

    @Autowired
    private VisitRepository visitRepository;

    @Test
    void findAllByDiagnoseTest() {
        Visit visit = new Visit();
        String diagnose = "Cold";
        visit.setDiagnose(diagnose);
        visit.setVisitationDate(LocalDate.of(2022,1,26));
        visit.setTreatment("Tea");
        visit.setSickLeave(10);
        testEntityManager.persistAndFlush(visit);

        assertThat(visitRepository.findAllByDiagnose(diagnose).size()).isEqualTo(1);
    }

}
