package com.proyectos.ClinicaOdontologica.services;

import com.proyectos.ClinicaOdontologica.entities.AppUser;
import com.proyectos.ClinicaOdontologica.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AppUserService implements UserDetailsService {

    @Autowired
    UserRepository repository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<AppUser> userSearched = repository.findByEmail(username);
        if(userSearched.isPresent()){
            return userSearched.get();
        }
        else {
         throw new UsernameNotFoundException("Email's user not found");
        }
    }
}
