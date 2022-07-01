package com.proyectos.ClinicaOdontologica.controller;


import com.proyectos.ClinicaOdontologica.entities.Appointment;
import com.proyectos.ClinicaOdontologica.entities.Dentist;
import com.proyectos.ClinicaOdontologica.entities.Patient;
import com.proyectos.ClinicaOdontologica.services.AppointmentService;
import com.proyectos.ClinicaOdontologica.services.DentistService;
import com.proyectos.ClinicaOdontologica.services.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/turnos")
public class AppointmentController {

    @Autowired
    private AppointmentService appointmentService;
    @Autowired
    private PatientService patientService;
    @Autowired
    private DentistService dentistService;


    @PostMapping
    public ResponseEntity<Appointment> create(@RequestBody Appointment appointment){
        ResponseEntity<Appointment> response;
        Optional<Patient> patient = patientService.searchPatientById(appointment.getPatient().getId());
        Optional<Dentist> dentist = dentistService.searchDentistById(appointment.getDentist().getId());
        if(patient.isPresent()&&dentist.isPresent()){
            response=ResponseEntity.ok(appointmentService.createAppointment(appointment));
        }
        else{
            response=ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        return response;
    }

    @GetMapping
    public ResponseEntity<List<Appointment>> listAll(){

        return ResponseEntity.ok(appointmentService.appointmentList());
    }

    @PutMapping
    public Appointment update(@RequestBody Appointment appointment){
        return appointmentService.updateAppointment(appointment);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Appointment> searchById(@PathVariable Long id){
        if(appointmentService.searchAppointmetById(id).isPresent()){
            return ResponseEntity.ok(appointmentService.searchAppointmetById(id).get());
        }
        else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id){
        String resp= "Error id entered is wrong";
        if(appointmentService.searchAppointmetById(id).isPresent()){
            appointmentService.deleteAppointment(id);
            resp="The appointment with id="+id+" was eliminates";
        }
        return resp;
    }
}
