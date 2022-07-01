package com.proyectos.ClinicaOdontologica.services;

import com.proyectos.ClinicaOdontologica.entities.Address;
import com.proyectos.ClinicaOdontologica.repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AddressService {

    @Autowired
    AddressRepository repository;

    public List<Address> addressList(){
        return repository.findAll();
    }

    public Address createAddress(Address address){
        return repository.save(address);
    }

    public void deleteAddress(Long id){
        repository.deleteById(id);
    }

    public Optional<Address> searchAddressById(Long id){
        return repository.findById(id);
    }

    public Address updateAddress(Address address){
        if(searchAddressById(address.getId()).isPresent()){
            return repository.save(address);
        }
        else {
            return null;
        }
    }
}
