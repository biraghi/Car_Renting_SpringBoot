package com.example.Car_Renting_SpringBoot.service.Car;

import com.example.Car_Renting_SpringBoot.entity.Car;
import com.example.Car_Renting_SpringBoot.entity.User;

import java.time.LocalDate;
import java.util.List;

public interface CarServiceInterface {
    public List<Car> getAll();
    public Car getById(int id);
    public Car getByLicensePlate(String licensePlate);
    public Car add(Car car);
    public Car update(Car car, int id);
    public boolean deleteAll();
    public boolean deleteById(int id);
    public List<Car> carNotBooked(LocalDate start, LocalDate finish);
}
