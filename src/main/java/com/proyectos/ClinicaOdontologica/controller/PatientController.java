package com.proyectos.ClinicaOdontologica.controller;

import com.proyectos.ClinicaOdontologica.entities.Patient;
import com.proyectos.ClinicaOdontologica.services.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/patients")
public class PatientController {

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
        return patientService.patientList();
    }

    @PostMapping
    public Patient create(@RequestBody Patient patient){
        return patientService.createPatient(patient);
    }

    @PutMapping
    public Patient update(@RequestBody Patient patient){
        return patientService.updatePatient(patient);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Patient> searchById(@PathVariable Long id){
        if(patientService.searchPatientById(id).isPresent()){
            return ResponseEntity.ok(patientService.searchPatientById(id).get());
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id) {
        String resp = "Error! id entered not exist";
        if (patientService.searchPatientById(id).isPresent()) {
            patientService.deletePatient(id);
            resp= "The patient with id " + id + " was eliminated";
        }
        return resp;
    }

}
