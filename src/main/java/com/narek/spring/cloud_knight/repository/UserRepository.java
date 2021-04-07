package com.narek.spring.cloud_knight.repository;

import com.narek.spring.cloud_knight.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

    User findByUsername(String username);

}
