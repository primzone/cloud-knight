package com.narek.spring.cloud_knight.service;


import com.narek.spring.cloud_knight.entity.Knight;
import com.narek.spring.cloud_knight.entity.User;
import com.narek.spring.cloud_knight.repository.KnightRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class KnightService {

    @Autowired
    KnightRepository knightRepository;


    public void deleteAll() {
        knightRepository.deleteAll();
    }

    public Optional<Knight> findByOwner(User user) {
        return knightRepository.findByOwner(user);
    }

    public void save(Knight knight) {
        knightRepository.save(knight);
    }

    public Optional<Knight> findById(long knight_id) {
        return knightRepository.findById(knight_id);
    }

    public Iterable<Knight> findAll() {
        return knightRepository.findAll();
    }

    public void deleteById(long knight_id) {
        knightRepository.deleteById(knight_id);
    }
}



