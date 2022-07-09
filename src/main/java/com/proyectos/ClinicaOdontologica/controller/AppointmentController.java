package com.proyectos.ClinicaOdontologica.controller;


import com.proyectos.ClinicaOdontologica.entities.Appointment;
import com.proyectos.ClinicaOdontologica.exceptions.BadRequestException;
import com.proyectos.ClinicaOdontologica.exceptions.ResourceNotFoundException;
import com.proyectos.ClinicaOdontologica.services.AppointmentService;
import com.proyectos.ClinicaOdontologica.services.DentistService;
import com.proyectos.ClinicaOdontologica.services.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/appointments")
public class AppointmentController {

    @Autowired
    private AppointmentService appointmentService;
    @Autowired
    private PatientService patientService;
    @Autowired
    private DentistService dentistService;


    @PostMapping
    public ResponseEntity<String> create(@RequestBody Appointment appointment) throws BadRequestException {
        appointmentService.createAppointment(appointment);
        return ResponseEntity.ok("Appointment created");
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
    public ResponseEntity<String> delete(@PathVariable Long id) throws ResourceNotFoundException {
        appointmentService.deleteAppointment(id);
        return ResponseEntity.ok("The appointment was eliminated correctly");
    }

    @ExceptionHandler({BadRequestException.class})
    public ResponseEntity<String> processErrorBadRequest(BadRequestException ex){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
    }
}
