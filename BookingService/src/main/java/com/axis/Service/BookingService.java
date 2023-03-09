package com.axis.Service;

import java.util.List;

import com.axis.Entity.Booking;

public interface BookingService {
	
	
	Booking trainbooking(Booking booking);
	
	Booking flightbooking(Booking booking);
	
	Booking busbooking(Booking booking);
	
	List<Booking> getAllBookingByUserName(String username);
	
}
