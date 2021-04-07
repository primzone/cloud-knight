package com.narek.spring.cloud_knight.repository;

import com.narek.spring.cloud_knight.entity.Knight;
import com.narek.spring.cloud_knight.entity.User;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;


public interface KnightRepository extends CrudRepository<Knight, Long> {

    Optional<Integer> findByOwnerId(int id);

    Optional<Knight> findByOwner(User user);




}
