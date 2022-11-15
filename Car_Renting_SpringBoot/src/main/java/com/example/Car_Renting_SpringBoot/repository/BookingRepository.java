package com.example.Car_Renting_SpringBoot.repository;

import com.example.Car_Renting_SpringBoot.entity.Booking;
import com.example.Car_Renting_SpringBoot.entity.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface BookingRepository extends JpaRepository<Booking, Integer> {
}
