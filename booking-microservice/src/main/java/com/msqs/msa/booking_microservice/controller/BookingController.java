package com.msqs.msa.booking_microservice.controller;

import com.msqs.msa.booking_microservice.entity.BookingEntity;
import com.msqs.msa.booking_microservice.service.BookingService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path="/booking")
public class BookingController {

    private final BookingService bookingService;

    public BookingController(BookingService bookingService) {
        this.bookingService = bookingService;
    }

    @PostMapping ("/add")
    public ResponseEntity<BookingEntity> add(@RequestBody BookingEntity val){
        BookingEntity booking = bookingService.addBooking(val);
        return new ResponseEntity<>(booking, HttpStatus.CREATED);
    }

    @GetMapping("/views")
    public List<BookingEntity> views(){
        return bookingService.getAllBookings();
    }

    @GetMapping("/views/{val}")
    public ResponseEntity<BookingEntity> view(@PathVariable int val){
        try {
            BookingEntity booking = bookingService.getBookingById(val);
            return new ResponseEntity<>(booking, HttpStatus.OK);
        }catch (RuntimeException e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/update")
    public ResponseEntity<BookingEntity> update(@RequestBody BookingEntity val){
        try{
            BookingEntity updatedBooking = bookingService.updateBooking(val);
            return new ResponseEntity<>(updatedBooking, HttpStatus.OK);
        }catch(Exception e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @DeleteMapping("/delete/{val}")
    public ResponseEntity<String> delete(@PathVariable int val){
        try {
            bookingService.deleteBooking(val);
            return new ResponseEntity<>("Booking deleted successfully", HttpStatus.OK);
        }catch (RuntimeException e){
            return new ResponseEntity<>("Booking not found",HttpStatus.NOT_FOUND);
        }
    }
}