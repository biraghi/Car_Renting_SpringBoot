package com.example.Car_Renting_SpringBoot.repository;

import com.example.Car_Renting_SpringBoot.entity.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface CarRepository extends JpaRepository<Car, Integer> {
    public Optional<Car> findByLicensePlate(String licensePlate);
//    @Query(value = "SELECT c\n" +
//            "FROM Car c\n" +
//            "WHERE c.?1 = ?2")
//    public Optional<List<Car>> findByField(String fieldName, String fieldValue);

    @Query(value = "SELECT DISTINCT c1\n" +
            "FROM Car c1\n" +
            "WHERE c1.id NOT IN (SELECT DISTINCT  c.id\n" +
            "from Booking b\n" +
            "right outer join Car c on b.car.id=c.id  \n" +
            "WHERE (b.startDate<=?2 and b.finishDate>=?1) AND b.approve = 1 )\n")
    public Optional<List<Car>> findCarNotBooked(LocalDate start, LocalDate finish);

}
