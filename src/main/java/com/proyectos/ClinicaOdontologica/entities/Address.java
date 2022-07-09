package com.proyectos.ClinicaOdontologica.entities;

import javax.persistence.*;

@Entity
@Table(name = "Addresses")
public class Address {

    @Id
    @SequenceGenerator(name = "address_sequence", sequenceName = "address_sequence")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "address_sequence")
    private Long id;
    @Column
    private String street;
    @Column
    private Integer number;
    @Column
    private String country;
    @Column
    private String city;

    @OneToOne(mappedBy = "address")
    private Patient patient;



    public Address() {
    }

    public Address(String street, Integer number, String country, String city) {
        this.street = street;
        this.number = number;
        this.country = country;
        this.city = city;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }
}
