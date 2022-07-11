package com.proyectos.ClinicaOdontologica.controller;

import com.proyectos.ClinicaOdontologica.entities.Patient;
import com.proyectos.ClinicaOdontologica.exceptions.ResourceNotFoundException;
import com.proyectos.ClinicaOdontologica.services.PatientService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("v1/patients")
public class PatientController {

    private static final Logger logger = Logger.getLogger(PatientController.class);

    @Autowired
    private PatientService patientService;

    /*
    @GetMapping("/index")
    public String traerPaciente(Model model, @RequestParam("email")String email){
        //buscar al paciente con el email
        Paciente paciente= pacienteService.buscarPacientePorEmail(email);
        model.addAttribute("nombre",paciente.getNombre());
        model.addAttribute("apellido",paciente.getApellido());
        return "index";
    }
    */

    @GetMapping
    public List<Patient> listAll(){
        logger.info("This are the patients in our base: ");
        return patientService.patientList();
    }

    @PostMapping
    public Patient create(@RequestBody Patient patient){
        logger.info("The patient "+ patient.getName()+ " was created.");
        return patientService.createPatient(patient);
    }

    @PutMapping
    public Patient update(@RequestBody Patient patient){
        logger.info("The patient " + patient + " was updated.");
        return patientService.updatePatient(patient);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Patient> searchById(@PathVariable Long id){
        if(patientService.searchPatientById(id).isPresent()){
            return ResponseEntity.ok(patientService.searchPatientById(id).get());
        }
        logger.error("The patient with id: " + id + " is not found.");
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) throws ResourceNotFoundException {
        patientService.deletePatient(id);
        logger.info("The patient with id "+ id + " was eliminated.");
        return ResponseEntity.ok("The patient was eliminated correctly");
    }

}
