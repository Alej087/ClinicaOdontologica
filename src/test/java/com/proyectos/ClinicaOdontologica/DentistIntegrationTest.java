package com.proyectos.ClinicaOdontologica;

import com.proyectos.ClinicaOdontologica.entities.Dentist;
import com.proyectos.ClinicaOdontologica.services.DentistService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc(addFilters = false)
public class DentistIntegrationTest {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    DentistService dentistService;

    @Test
    public void createDentist() throws Exception {

    }
}
