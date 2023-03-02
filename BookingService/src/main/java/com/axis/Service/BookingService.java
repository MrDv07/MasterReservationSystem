package com.axis.Service;

import java.util.List;

import com.axis.Entity.Booking;

public interface BookingService {
	
	
	Booking trainbooking(String username, int numberOfPassengers, int numberOfMode,
			String reservationClass, String travelDate);
	
	Booking flightbooking(String username, int numberOfPassengers, int numberOfMode,
			String reservationClass, String travelDate);
	
	Booking busbooking(String username, int numberOfPassengers, int numberOfMode,
			String reservationClass, String travelDate);
	
	List<Booking> getAllBookingByUserName(String username);
	
}
