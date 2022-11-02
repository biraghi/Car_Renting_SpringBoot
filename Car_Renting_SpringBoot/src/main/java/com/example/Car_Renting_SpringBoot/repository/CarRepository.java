package com.example.Car_Renting_SpringBoot.repository;

import com.example.Car_Renting_SpringBoot.entity.Car;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarRepository extends JpaRepository<Car, Integer> {
}
