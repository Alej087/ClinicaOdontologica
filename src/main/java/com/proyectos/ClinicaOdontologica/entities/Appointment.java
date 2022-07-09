package com.proyectos.ClinicaOdontologica.entities;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "Appointments")
public class Appointment {

    @Id
    @SequenceGenerator(name = "appointment_sequence", sequenceName = "appointment_sequence")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "appointment_sequence")
    private Long id;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "patient_id", nullable = false)
    private Patient patient;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "dentist_id", nullable = false)
    private Dentist dentist;

    @Column
    private LocalDate date;

    public Appointment() {
    }

    public Appointment(Patient patient, Dentist dentist, LocalDate date) {
        this.patient = patient;
        this.dentist = dentist;
        this.date = date;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public Dentist getDentist() {
        return dentist;
    }

    public void setDentist(Dentist dentist) {
        this.dentist = dentist;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
}
