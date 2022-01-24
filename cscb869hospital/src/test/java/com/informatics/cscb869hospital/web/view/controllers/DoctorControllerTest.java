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
@WebMvcTest(DoctorController.class)
public class DoctorControllerTest {
    @MockBean
    private DoctorService doctorService;

    @MockBean
    private HospitalService hospitalService;

    @MockBean
    private ModelMapper modelMapper;

    @Autowired
    private MockMvc mockMvc;

    @Test
    void getDoctorHospitals() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/doctors"))
                .andExpect(status().isOk())
                .andExpect(view().name("/doctors/doctor-hospital"));
    }

    @Test
    void showCreateDoctorForm() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/doctors/create-doctor"))
                .andExpect(status().isOk())
                .andExpect(view().name("/doctors/create-doctor"));
    }
}
