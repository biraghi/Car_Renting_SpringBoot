package com.example.Car_Renting_SpringBoot.repository;

import com.example.Car_Renting_SpringBoot.entity.Car;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CarRepository extends JpaRepository<Car, Integer> {
    public Optional<Car> findByLicensePlate(String licensePlate);
}
