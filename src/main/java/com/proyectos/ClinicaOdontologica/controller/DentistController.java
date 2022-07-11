package com.proyectos.ClinicaOdontologica.controller;

import com.proyectos.ClinicaOdontologica.entities.Dentist;
import com.proyectos.ClinicaOdontologica.exceptions.ResourceNotFoundException;
import com.proyectos.ClinicaOdontologica.services.DentistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("v1/dentists")
public class DentistController {

    @Autowired
    private DentistService dentistService;

    @GetMapping
    public List<Dentist> listAll(){

        return dentistService.dentistList();
    }

    @PostMapping
    public Dentist create(@RequestBody Dentist dentist){
        return dentistService.createDentist(dentist);
    }

    @PutMapping
    public Dentist update(@RequestBody Dentist dentist){
    return dentistService.updateDentist(dentist);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Dentist> searchById(@PathVariable Long id){
        if(dentistService.searchDentistById(id).isPresent()){
            return ResponseEntity.ok(dentistService.searchDentistById(id).get());
        }
        else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) throws ResourceNotFoundException {
        dentistService.deleteDentist(id);
        return ResponseEntity.ok("The dentist was eliminated correctly");
    }
}
