package com.proyectos.ClinicaOdontologica.controller;


import com.proyectos.ClinicaOdontologica.entities.Appointment;
import com.proyectos.ClinicaOdontologica.exceptions.BadRequestException;
import com.proyectos.ClinicaOdontologica.exceptions.ResourceNotFoundException;
import com.proyectos.ClinicaOdontologica.services.AppointmentService;
import com.proyectos.ClinicaOdontologica.services.DentistService;
import com.proyectos.ClinicaOdontologica.services.PatientService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("v1/appointments")
public class AppointmentController {

    private static final Logger logger = Logger.getLogger(AppointmentController.class);

    @Autowired
    private AppointmentService appointmentService;
    @Autowired
    private PatientService patientService;
    @Autowired
    private DentistService dentistService;


    @PostMapping
    public ResponseEntity<String> create(@RequestBody Appointment appointment) throws BadRequestException {
        appointmentService.createAppointment(appointment);
        logger.info("The appointment for "+ appointment.getDate()+ " was created.");
        return ResponseEntity.ok("Appointment created");
    }

    @GetMapping
    public ResponseEntity<List<Appointment>> listAll(){

        return ResponseEntity.ok(appointmentService.appointmentList());
    }

    @PutMapping
    public Appointment update(@RequestBody Appointment appointment){
        logger.info("The appointment was updated.");
        return appointmentService.updateAppointment(appointment);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Appointment> searchById(@PathVariable Long id){
        if(appointmentService.searchAppointmetById(id).isPresent()){
            return ResponseEntity.ok(appointmentService.searchAppointmetById(id).get());
        }
        else{
            logger.error("The appointment with id: " + id + " is not found.");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) throws ResourceNotFoundException {
        appointmentService.deleteAppointment(id);
        logger.info("The appointment with id "+ id + " was eliminated.");
        return ResponseEntity.ok("The appointment was eliminated correctly");
    }

    @ExceptionHandler({BadRequestException.class})
    public ResponseEntity<String> processErrorBadRequest(BadRequestException ex){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
    }
}
