package com.example.Car_Renting_SpringBoot.repository;

import com.example.Car_Renting_SpringBoot.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {
    public Optional<User> findByUsername(String username);
}
