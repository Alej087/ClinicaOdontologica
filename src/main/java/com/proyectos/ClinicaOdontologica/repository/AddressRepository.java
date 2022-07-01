package com.proyectos.ClinicaOdontologica.repository;


import com.proyectos.ClinicaOdontologica.entities.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepository extends JpaRepository<Address, Long> {
}
