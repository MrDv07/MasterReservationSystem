package com.axis.Service;

import com.axis.Entity.Booking;

public interface BookingService {
	
	
	Booking trainbooking(String username, int numberOfPassengers, int numberOfMode,
			String reservationClass, String travelDate);
	
}