package com.proyectos.ClinicaOdontologica.services;


import com.proyectos.ClinicaOdontologica.entities.Dentist;
import com.proyectos.ClinicaOdontologica.exceptions.ResourceNotFoundException;
import com.proyectos.ClinicaOdontologica.repository.DentistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DentistService {

    @Autowired
    DentistRepository repository;

    public List<Dentist> dentistList() {

        return repository.findAll();
    }

    public Optional<Dentist> searchDentistById(Long id) {

        return repository.findById(id);
    }

    public Dentist createDentist(Dentist dentist) {

        return repository.save(dentist);
    }

    public void deleteDentist(Long id) throws ResourceNotFoundException {
        Optional<Dentist> dentistSearched = searchDentistById(id);
        if(dentistSearched.isPresent()) {
            repository.deleteById(id);
        }
        else {
            throw new ResourceNotFoundException("The dentist with id = "+id+" not exist.Enter a right id");
        }
    }

    public Dentist updateDentist(Dentist dentist){
        if(searchDentistById(dentist.getId()).isPresent()){
            return repository.save(dentist);
        }
        else {
            return null;
        }
    }
}
