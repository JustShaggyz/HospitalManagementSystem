package com.informatics.cscb869hospital.web.view.controllers;


import com.informatics.cscb869hospital.services.HospitalService;
import com.informatics.cscb869hospital.services.PatientService;
import com.informatics.cscb869hospital.services.RecordService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

@ExtendWith(SpringExtension.class)
@WebMvcTest(RecordController.class)
public class RecordControllerTest {
    @MockBean
    private RecordService recordService;

    @MockBean
    private HospitalService hospitalService;

    @MockBean
    private PatientService patientService;

    @MockBean
    private ModelMapper modelMapper;

    @Autowired
    private MockMvc mockMvc;

    @Test
    void processToGetRecord() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/records"))
                .andExpect(status().isOk())
                .andExpect(view().name("/records/get-record"));
    }

    @Test
    void showCreateRecordForm() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/records/create-record"))
                .andExpect(status().isOk())
                .andExpect(view().name("/records/create-record"));
    }
}
