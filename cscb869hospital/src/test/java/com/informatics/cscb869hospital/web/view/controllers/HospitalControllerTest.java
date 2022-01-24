package com.informatics.cscb869hospital.web.view.controllers;

import com.informatics.cscb869hospital.services.DoctorService;
import com.informatics.cscb869hospital.services.HospitalService;
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
@WebMvcTest(HospitalController.class)
public class HospitalControllerTest {
    @MockBean
    private HospitalService hospitalService;

    @MockBean
    private DoctorService doctorService;

    @MockBean
    private ModelMapper modelMapper;

    @Autowired
    private MockMvc mockMvc;

    @Test
    void getHospitals() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/hospitals"))
                .andExpect(status().isOk())
                .andExpect(view().name("/hospitals/hospitals"));
    }

    @Test
    void showCreateHospitalForm() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/hospitals/create-hospital"))
                .andExpect(status().isOk())
                .andExpect(view().name("/hospitals/create-hospital"));
    }
}
