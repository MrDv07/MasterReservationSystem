package com.axis.Contoller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import com.axis.Entity.Booking;
import com.axis.Service.BookingService;

@RestController
@RequestMapping("/api/v1/booking")
public class BookingController {
	
	
    @Autowired
    private BookingService bookingService;
    
    @PostMapping("/TrainTicket")
    public ResponseEntity<Booking> trainBooking(@RequestBody String username,String reservationClass,String travelDate, int numberOfPassengers, int numberOfMode) {
        return new ResponseEntity<Booking>(bookingService.trainbooking(username, numberOfPassengers, numberOfMode, reservationClass, travelDate), HttpStatus.OK);
    }
}

