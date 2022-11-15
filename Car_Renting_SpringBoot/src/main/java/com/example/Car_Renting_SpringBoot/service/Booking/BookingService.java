package com.example.Car_Renting_SpringBoot.service.Booking;

import com.example.Car_Renting_SpringBoot.entity.Booking;
import com.example.Car_Renting_SpringBoot.entity.User;
import com.example.Car_Renting_SpringBoot.repository.BookingRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookingService implements BookingServiceInterface{
    private final BookingRepository bookingRepository;

    public BookingService(BookingRepository bookingRepository) {
        this.bookingRepository = bookingRepository;
    }

    @Override
    public List<Booking> getAll() {
        return bookingRepository.findAll();
    }

    @Override
    public Booking getById(int id) {
        if(id != 0 && bookingRepository.findById(id).isPresent()){
            return bookingRepository.findById(id).get();
        }
        else{
            return null;
        }
    }

    @Override
    public Booking add(Booking booking) {
        if(booking != null && booking.getId() == 0){
            return bookingRepository.save(booking);
        }
        else{
            return null;
        }
    }

    @Override
    public Booking update(Booking booking, int id) {
        if(booking != null && bookingRepository.findById(id).isPresent()){
            booking.setId(id);
            return bookingRepository.save(booking);
        }
        else{
            return null;
        }
    }

    @Override
    public boolean deleteAll() {
        bookingRepository.deleteAll();
        return true;
    }

    @Override
    public boolean deleteById(int id) {
        if(id != 0 && bookingRepository.findById(id).isPresent()){
            bookingRepository.deleteById(id);
            return true;
        }
        else{
            return false;
        }
    }

    @Override
    public boolean setApprove(int id) {
        if(id != 0 && bookingRepository.findById(id).isPresent()){
            Booking booking = bookingRepository.findById(id).get();
            booking.setApprove(true);
            bookingRepository.save(booking);
            return true;
        }
        else{
            return false;
        }
    }


}
