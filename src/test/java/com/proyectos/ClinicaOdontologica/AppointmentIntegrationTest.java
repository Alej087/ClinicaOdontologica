package com.proyectos.ClinicaOdontologica;

import com.proyectos.ClinicaOdontologica.entities.Address;
import com.proyectos.ClinicaOdontologica.entities.Appointment;
import com.proyectos.ClinicaOdontologica.entities.Dentist;
import com.proyectos.ClinicaOdontologica.entities.Patient;
import com.proyectos.ClinicaOdontologica.exceptions.BadRequestException;
import com.proyectos.ClinicaOdontologica.services.AppointmentService;
import com.proyectos.ClinicaOdontologica.services.DentistService;
import com.proyectos.ClinicaOdontologica.services.PatientService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.time.LocalDate;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc(addFilters = false)
public class AppointmentIntegrationTest  {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    PatientService patientService;

    @Autowired
    DentistService dentistService;

    @Autowired
    AppointmentService appointmentService;

    public void initialData() throws BadRequestException {
        Address address = new Address("Calle C",43,"Colombia","Bogotá");
        Patient patient = patientService.createPatient(new Patient("González","Alejo","b@gmail.com",1234, LocalDate.of(2022,11,05),address));
        Dentist dentist = dentistService.createDentist(new Dentist("Toro","David","DG0987"));
        appointmentService.createAppointment(new Appointment(patient,dentist,LocalDate.of(2021,02,10)));
    }

    @Test
    public void listAppointments() throws Exception {
        //initialData();
        MvcResult response = mockMvc.perform(MockMvcRequestBuilders.get("/appointments")
                        .accept(MediaType.APPLICATION_JSON))
                        .andDo(MockMvcResultHandlers.print())
                        .andExpect(MockMvcResultMatchers.status().isOk())
                        .andReturn();

        Assert.assertFalse(response.getResponse().getContentAsString().isEmpty());
    }

    @Test
    public void findApointmentById() throws BadRequestException {
        Address address = new Address("Calle C",43,"Colombia","Bogotá");
        Patient patient = patientService.createPatient(new Patient("González","Alejo","b@gmail.com",1234, LocalDate.of(2022,11,05),address));
        Dentist dentist = dentistService.createDentist(new Dentist("Toro","David","DG0987"));
        Appointment appointment = appointmentService.createAppointment(new Appointment(patient,dentist,LocalDate.of(2021,02,10)));

        appointmentService.searchAppointmetById(appointment.getId()).get();

        Assert.assertFalse(appointment.getPatient().getEmail().isEmpty());
    }
}
