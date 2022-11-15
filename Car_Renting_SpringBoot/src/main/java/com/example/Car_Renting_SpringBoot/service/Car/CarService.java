package com.example.Car_Renting_SpringBoot.service.Car;

import com.example.Car_Renting_SpringBoot.entity.Car;
import com.example.Car_Renting_SpringBoot.repository.CarRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
public class CarService implements CarServiceInterface{
    private final CarRepository carRepository;

    public CarService(CarRepository carRepository) {
        this.carRepository = carRepository;
    }


    @Override
    public List<Car> getAll() {
        return carRepository.findAll();
    }

    @Override
    public Car getById(int id) {
        if(id != 0 && carRepository.findById(id).isPresent()){
            return carRepository.findById(id).get();
        }
        else{
            return null;
        }

    }

    @Override
    public Car getByLicensePlate(String licensePlate) {
        if(licensePlate != null && carRepository.findByLicensePlate(licensePlate).isPresent()){
            return carRepository.findByLicensePlate(licensePlate).get();
        }
        else{
            return null;
        }
    }

    @Override
    public Car add(Car car) {
        if(car != null && car.getId()==0){
            return carRepository.save(car);
        }
        else{
            return null;
        }
    }

    @Override
    public Car update(Car car, int id) {
        if(car != null && carRepository.findById(id).isPresent()){
            car.setId(id);
            return carRepository.save(car);
        }
        else{
            return null;
        }

    }

    @Override
    public boolean deleteAll() {
        carRepository.deleteAll();
        return true;
    }

    @Override
    public boolean deleteById(int id) {
        if(id != 0 && carRepository.findById(id).isPresent()){
            carRepository.findById(id).get();
            return true;
        }
        else{
            return false;
        }
    }

    @Override
    public List<Car> carNotBooked(LocalDate start, LocalDate finish) {
//        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
//        LocalDate startDate = LocalDate.parse(start, formatter);
//        LocalDate finishDate = LocalDate.parse(finish, formatter);
        if (carRepository.findCarNotBooked(start, finish).isPresent()){
            return carRepository.findCarNotBooked(start, finish).get();
        }
        else{
            return null;
        }

    }


}
