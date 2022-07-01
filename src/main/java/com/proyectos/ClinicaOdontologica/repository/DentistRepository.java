package com.proyectos.ClinicaOdontologica.repository;

import com.proyectos.ClinicaOdontologica.entities.Dentist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DentistRepository extends JpaRepository<Dentist, Long> {
}
