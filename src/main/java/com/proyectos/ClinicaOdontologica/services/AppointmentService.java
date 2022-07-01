package com.proyectos.ClinicaOdontologica.services;

import com.proyectos.ClinicaOdontologica.entities.Appointment;
import com.proyectos.ClinicaOdontologica.repository.AppointmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AppointmentService {

    @Autowired
    AppointmentRepository repository;

    public Appointment createAppointment(Appointment appointment){

        return repository.save(appointment);
    }
    public List<Appointment> appointmentList(){

        return repository.findAll();
    }

    public void deleteAppointment(Long id){
        repository.deleteById(id);
    }

    public Optional<Appointment> searchAppointmetById(Long id){
        return repository.findById(id);
    }

    public Appointment updateAppointment(Appointment appointment){
        if(searchAppointmetById(appointment.getId()).isPresent()){
            return repository.save(appointment);
        }
        else {
            return null;
        }
    }
}
