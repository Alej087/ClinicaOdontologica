package com.proyectos.ClinicaOdontologica.services;


import com.proyectos.ClinicaOdontologica.entities.Patient;
import com.proyectos.ClinicaOdontologica.exceptions.ResourceNotFoundException;
import com.proyectos.ClinicaOdontologica.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PatientService {

    @Autowired
    private PatientRepository repository;

    public List<Patient> patientList() {

        return repository.findAll();
    }
    /*public Paciente buscarPacientePorEmail(String email) {

        return repository.findBy(email);
    }*/

    public Patient createPatient(Patient patient) {

        return repository.save(patient);
    }

    public Patient updatePatient(Patient patient) {
        if (searchPatientById(patient.getId()).isPresent()) {
            return repository.save(patient);
        }
        else {
            return null;
        }
    }

    public Optional<Patient> searchPatientById(Long id) {

        return repository.findById(id);
    }

    public void deletePatient(Long id) throws ResourceNotFoundException {
        Optional<Patient> patientSearched = searchPatientById(id);
        if(patientSearched.isPresent()) {
            repository.deleteById(id);
        }
        else {
            throw new ResourceNotFoundException("The patient with id = "+id+" not exist.Enter a right id");
        }
    }
}
