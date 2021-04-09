package com.narek.spring.cloud_knight.entity;


import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.*;

@Entity
@Table(name = "usr")
public class User implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @NotBlank(message = "Имя не может быть пустым")
    private String username;
    @NotBlank(message = "Пароль не может быть пустым")
    private String password;

    private boolean active;

    @OneToOne(mappedBy = "owner")
    private Knight user_knight;

    @OneToOne(mappedBy = "owner")
    private Monster user_monster;

    @ElementCollection(targetClass = Role.class, fetch = FetchType.EAGER)
    @CollectionTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id"))
    @Enumerated(EnumType.STRING)
    private Set<Role> roles;


    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "user_usedcities", joinColumns = @JoinColumn(name = "user_id"))
    private Set<String> usedCities;


    public boolean isAdmin(){
        return roles.contains(Role.ADMIN);

    }


    public Set<String> getUsedCities() {
        return usedCities;
    }

    public void setUsedCities(Set<String> usedCities) {
        this.usedCities = usedCities;
    }

    public Knight getUser_knight() {
        return user_knight;
    }

    public void setUser_knight(Knight user_knight) {
        this.user_knight = user_knight;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
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
        return isActive();
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return getRoles();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    public Monster getUser_monster() {
        return user_monster;
    }

    public void setUser_monster(Monster user_monster) {
        this.user_monster = user_monster;
    }
}
