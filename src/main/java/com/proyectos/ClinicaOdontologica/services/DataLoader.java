package com.proyectos.ClinicaOdontologica.services;

import com.proyectos.ClinicaOdontologica.entities.AppUser;
import com.proyectos.ClinicaOdontologica.entities.AppUsersRoles;
import com.proyectos.ClinicaOdontologica.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements ApplicationRunner {

    @Autowired
    UserRepository repository;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String passUser= passwordEncoder.encode("digital");
        String passAdmin = passwordEncoder.encode("admin");

        repository.save(new AppUser("Alejo","Alejo","a@gmail.com",passUser, AppUsersRoles.ROLE_USER));
        repository.save(new AppUser("David","David","admin@gmail.com",passAdmin,AppUsersRoles.ROLE_ADMIN));
    }
}
