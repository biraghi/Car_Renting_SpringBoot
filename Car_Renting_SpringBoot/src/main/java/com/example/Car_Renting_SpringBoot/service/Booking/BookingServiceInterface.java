package com.example.Car_Renting_SpringBoot.service.Booking;

import com.example.Car_Renting_SpringBoot.entity.Booking;
import com.example.Car_Renting_SpringBoot.entity.Car;

import java.util.List;

public interface BookingServiceInterface {
    public List<Booking> getAll();
    public Booking getById(int id);
    public Booking add(Booking booking);
    public Booking update(Booking booking, int id);
    public boolean deleteAll();
    public boolean deleteById(int id);
    public boolean setApprove(int id);
}
