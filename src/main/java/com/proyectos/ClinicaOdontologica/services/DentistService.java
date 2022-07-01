package com.proyectos.ClinicaOdontologica.services;


import com.proyectos.ClinicaOdontologica.entities.Dentist;
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

    public void deleteDentist(Long id){
        repository.deleteById(id);
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
