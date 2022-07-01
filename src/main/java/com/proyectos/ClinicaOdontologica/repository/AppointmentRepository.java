package com.proyectos.ClinicaOdontologica.repository;

import com.proyectos.ClinicaOdontologica.entities.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AppointmentRepository extends JpaRepository<Appointment, Long> {
}
