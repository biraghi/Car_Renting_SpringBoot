package com.example.Car_Renting_SpringBoot.controller;

import com.example.Car_Renting_SpringBoot.entity.Car;
import com.example.Car_Renting_SpringBoot.entity.User;
import com.example.Car_Renting_SpringBoot.service.Car.CarService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/car")
public class CarController {
    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    private final CarService carService;

    public CarController(CarService carService) {
        this.carService = carService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Car>> getAllCars(){
        List<Car> list = carService.getAll();
        return new ResponseEntity<List<Car>>(list, HttpStatus.OK);
    }

    @GetMapping("getId/{id}")
    public ResponseEntity<Car> getCarById(@PathVariable int id){
        Car car = carService.getById(id);
        if(car == null){
            String ErrMsg = String.format("Car not found with id %s", id);
            logger.warn(ErrMsg);
            return new ResponseEntity<Car>(HttpStatus.NOT_FOUND);
        }
        else{
            return new ResponseEntity<Car>(car, HttpStatus.OK);
        }
    }

    @GetMapping("/getLicensePlate/{licensePlate}")
    public ResponseEntity<Car> getCarByLicensePLate(@PathVariable String licensePlate){
        Car car = carService.getByLicensePlate(licensePlate);
        if(car == null){
            String ErrMsg = String.format("Car not found with License Plate %s", licensePlate);
            logger.warn(ErrMsg);
            return new ResponseEntity<Car>(HttpStatus.NOT_FOUND);
        }
        else{
            return new ResponseEntity<Car>(car, HttpStatus.OK);
        }
    }

    @GetMapping("/notBooked")
    public ResponseEntity<List<Car>> getCarNotBooked(@RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate start,
                                                  @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate finish){
        List<Car> list = carService.carNotBooked(start, finish);
        if(list == null){
            String ErrMsg = String.format("Cars not found with start %s", start);
            logger.warn(ErrMsg);
            return new ResponseEntity<List<Car>>(HttpStatus.NOT_FOUND);
        }
        else{
            return new ResponseEntity<List<Car>>(list, HttpStatus.OK);
        }

    }

    @PostMapping("/add")
    public ResponseEntity<Car> addNewCar(@RequestBody Car car){
        Car newCar = carService.add(car);
        if(newCar == null){
            String ErrMsg = "Error";
            logger.warn(ErrMsg);
            return new ResponseEntity<Car>(HttpStatus.BAD_REQUEST);
        }
        else{
            return new ResponseEntity<Car>(car, HttpStatus.OK);
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Car> updateCar(@RequestBody Car car, @PathVariable int id){
        Car newCar = carService.update(car, id);
        if(newCar == null){
            String ErrMsg = String.format("Car not found with id %s or Bad Request", id);
            logger.warn(ErrMsg);
            return new ResponseEntity<Car>(HttpStatus.BAD_REQUEST);
        }
        else{
            return new ResponseEntity<Car>(car, HttpStatus.OK);
        }
    }

    @DeleteMapping("/delete/all")
    public ResponseEntity<Car> deleteAllCars(){
        carService.deleteAll();
        return new ResponseEntity<Car>(HttpStatus.OK);
    }

    @DeleteMapping("/deleteId/{id}")
    public ResponseEntity<Car> deleteCarbyId(@PathVariable int id){
        boolean del = carService.deleteById(id);
        if (!del){
            String ErrMsg = String.format("Car not found with id %s", id);
            logger.warn(ErrMsg);
            return new ResponseEntity<Car>(HttpStatus.NOT_FOUND);
        }
        else {
            return new ResponseEntity<Car>(HttpStatus.OK);
        }
    }


}
