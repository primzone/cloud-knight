package com.narek.spring.cloud_knight.entity;

import org.springframework.security.core.GrantedAuthority;

public enum Role implements GrantedAuthority {
    USER, ADMIN;


    @Override
    public String getAuthority() {
        return name(); // name = строковое представление enum,
        //каждый enum имплементит GrantedAuthority
    }
}
