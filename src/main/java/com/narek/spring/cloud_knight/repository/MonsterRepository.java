package com.narek.spring.cloud_knight.repository;


import com.narek.spring.cloud_knight.entity.Monster;
import com.narek.spring.cloud_knight.entity.User;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;


public interface MonsterRepository extends CrudRepository<Monster, Long> {

    Optional<Integer> findByOwnerId(int id);

    Optional<Monster> findByOwner(User user);


}
