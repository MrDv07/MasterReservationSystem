package com.axis.Contoller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
    public ResponseEntity<Booking> trainBooking(@RequestBody Booking booking) {
        return new ResponseEntity<Booking>(bookingService.trainbooking( booking.getUsername(),booking.getNumberOfMode(), booking.getNumberOfPassengers(), booking.getReservationClass(), booking.getTravelDate()), HttpStatus.OK);
    }
    
    @PostMapping("/FlightTicket")
    public ResponseEntity<Booking> flightBooking(@RequestBody Booking booking) {
        return new ResponseEntity<Booking>(bookingService.flightbooking(booking.getUsername(), booking.getNumberOfMode(), booking.getNumberOfPassengers(), booking.getReservationClass(), booking.getTravelDate()), HttpStatus.OK);
    }
    
    @PostMapping("/BusTicket")
    public ResponseEntity<Booking> BusBooking(@RequestBody Booking booking) {
        return new ResponseEntity<Booking>(bookingService.busbooking(booking.getUsername(), booking.getNumberOfMode(), booking.getNumberOfPassengers(), booking.getReservationClass(), booking.getTravelDate()), HttpStatus.OK);
    }
    
    @GetMapping("/findbyusername/{username}")
	public ResponseEntity<List<Booking>> findBookingByUserName(@PathVariable String username ){
		return new ResponseEntity<List<Booking>>(bookingService.getAllBookingByUserName(username), HttpStatus.FOUND);
	}
}

