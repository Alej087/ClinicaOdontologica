package com.proyectos.ClinicaOdontologica.entities;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.Collection;
import java.util.Collections;

@Entity
public class AppUser implements UserDetails {

    @Id
    @SequenceGenerator(name = "appUser_sequence", sequenceName = "appUser_sequence")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "appUser_sequence")
    private Long id;
    @Column
    private String name;
    @Column
    private String userName;
    @Column
    private String email;
    @Column
    private String password;
    @Enumerated(EnumType.STRING)
    private AppUsersRoles appUsersRoles;

    public AppUser() {
    }

    public AppUser(String name, String userName, String email, String password, AppUsersRoles appUsersRoles) {
        this.name = name;
        this.userName = userName;
        this.email = email;
        this.password = password;
        this.appUsersRoles = appUsersRoles;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        SimpleGrantedAuthority grantedAuthority = new SimpleGrantedAuthority(appUsersRoles.name());
        return Collections.singletonList(grantedAuthority);
    }

    @Override
    public String getUsername() {
        return userName;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public AppUsersRoles getAppUsersRoles() {
        return appUsersRoles;
    }

    public void setAppUsersRoles(AppUsersRoles appUsersRoles) {
        this.appUsersRoles = appUsersRoles;
    }
}
