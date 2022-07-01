package com.proyectos.ClinicaOdontologica.repository;

import com.dh.clase36.integradora.entities.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Long> {
}
