package com.proyectos.ClinicaOdontologica.repository;

import com.dh.clase36.integradora.entities.Dentist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DentistRepository extends JpaRepository<Dentist, Long> {
}
