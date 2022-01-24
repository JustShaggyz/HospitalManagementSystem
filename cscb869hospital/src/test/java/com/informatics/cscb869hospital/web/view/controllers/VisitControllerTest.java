package com.informatics.cscb869hospital.web.view.controllers;

import com.informatics.cscb869hospital.services.*;
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
@WebMvcTest(VisitController.class)
public class VisitControllerTest {
    @MockBean
    private VisitService visitService;

    @MockBean
    private RecordService recordService;

    @MockBean
    private HospitalService hospitalService;

    @MockBean
    private DoctorService doctorService;


    @MockBean
    private ModelMapper modelMapper;

    @Autowired
    private MockMvc mockMvc;

    @Test
    void showCreateVisitForm() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/visits/create-visit"))
                .andExpect(status().isOk())
                .andExpect(view().name("/visits/create-visit"));
    }

    @Test
    void processSearchDiagnoseForm() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/visits/search-diagnose"))
                .andExpect(status().isOk())
                .andExpect(view().name("/visits/search-diagnose"));
    }

    @Test
    void getPatientsByDiagnose() throws Exception {
        String diagnose = "Cold";
        mockMvc.perform(MockMvcRequestBuilders.get("/visits/diagnose?diagnose="+diagnose))
                .andExpect(status().isOk())
                .andExpect(view().name("/visits/visits"));
    }
}
