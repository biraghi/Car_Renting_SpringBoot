package com.example.Car_Renting_SpringBoot.controller;

import com.example.Car_Renting_SpringBoot.entity.Booking;
import com.example.Car_Renting_SpringBoot.entity.User;
import com.example.Car_Renting_SpringBoot.service.Booking.BookingService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/booking")
public class BookingController {
    private static final Logger logger = LoggerFactory.getLogger(UserController.class);
    private final BookingService bookingService;

    public BookingController(BookingService bookingService) {
        this.bookingService = bookingService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Booking>> getAllBookings(){
        List<Booking> list = bookingService.getAll();
        return new ResponseEntity<List<Booking>>(list, HttpStatus.OK);
    }

    @GetMapping("/getId/{id}")
    public ResponseEntity<Booking> getBookingById(@PathVariable int id){
        Booking booking = bookingService.getById(id);
        if(booking == null){
            String ErrMsg = String.format("Booking not found with id %s", id);
            logger.warn(ErrMsg);
            return new ResponseEntity<Booking>(HttpStatus.NOT_FOUND);
        }
        else{
            return new ResponseEntity<Booking>(booking, HttpStatus.OK);
        }
    }

    @PostMapping("/add")
    public ResponseEntity<Booking> addNewBooking(@RequestBody Booking booking){
        Booking newBooking = bookingService.add(booking);
        if(newBooking == null){
            String ErrMsg = "Error";
            logger.warn(ErrMsg);
            return new ResponseEntity<Booking>(HttpStatus.BAD_REQUEST);
        }
        else{
            return new ResponseEntity<Booking>(booking, HttpStatus.OK);
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Booking> updateBooking(@RequestBody Booking booking, @PathVariable int id){
        Booking newBooking = bookingService.update(booking, id);
        if(newBooking == null){
            String ErrMsg = String.format("Booking not found with id %s or Bad Request", id);
            logger.warn(ErrMsg);
            return new ResponseEntity<Booking>(HttpStatus.BAD_REQUEST);
        }
        else{
            return new ResponseEntity<Booking>(booking, HttpStatus.OK);
        }
    }

    @DeleteMapping("/delete/all")
    public ResponseEntity<Booking> deleteAllBookings(){
        bookingService.deleteAll();
        return new ResponseEntity<Booking>(HttpStatus.OK);
    }

    @DeleteMapping("/deleteId/{id}")
    public ResponseEntity<Booking> deleteBookingbyId(@PathVariable int id){
        boolean del = bookingService.deleteById(id);
        if (!del){
            String ErrMsg = String.format("Booking not found with id %s", id);
            logger.warn(ErrMsg);
            return new ResponseEntity<Booking>(HttpStatus.NOT_FOUND);
        }
        else {
            return new ResponseEntity<Booking>(HttpStatus.OK);
        }
    }

    @PostMapping("/approve")
    public ResponseEntity<Booking> setApprove(@RequestBody int id){
        boolean app = bookingService.setApprove(id);
        if (!app){
            String ErrMsg = String.format("Booking not found with id %s", id);
            logger.warn(ErrMsg);
            return new ResponseEntity<Booking>(HttpStatus.NOT_FOUND);
        }
        else {
            return new ResponseEntity<Booking>(HttpStatus.OK);
        }
    }
}
