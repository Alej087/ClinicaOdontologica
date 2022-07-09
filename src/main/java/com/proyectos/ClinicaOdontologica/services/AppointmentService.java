package com.proyectos.ClinicaOdontologica.services;

import com.proyectos.ClinicaOdontologica.entities.Appointment;
import com.proyectos.ClinicaOdontologica.exceptions.BadRequestException;
import com.proyectos.ClinicaOdontologica.exceptions.ResourceNotFoundException;
import com.proyectos.ClinicaOdontologica.repository.AppointmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AppointmentService {

    @Autowired
    AppointmentRepository repository;

    public Appointment createAppointment(Appointment appointment) throws BadRequestException {
        if(appointment.getPatient() == null || appointment.getDentist() == null){
            throw new BadRequestException("The appointment can not be created because the patient or the dentist does not exist");
        }
        return repository.save(appointment);
    }
    public List<Appointment> appointmentList(){

        return repository.findAll();
    }

    public void deleteAppointment(Long id) throws ResourceNotFoundException{
        Optional<Appointment> appointmentSearched = searchAppointmetById(id);
        if(appointmentSearched.isPresent()) {
            repository.deleteById(id);
        }
        else {
            throw new ResourceNotFoundException("The appointment with id = "+id+" not exist.Enter a right id");
        }
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
