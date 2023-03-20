package com.axis.Service;

import java.util.List;

import org.bson.types.ObjectId;

import com.axis.Entity.Booking;

public interface BookingService {
	
	
	Booking trainbooking(Booking booking);
	
	Booking flightbooking(Booking booking);
	
	Booking busbooking(Booking booking);
	
	List<Booking> getAll();
	
	List<Booking> getAllBookingByUserName(String username);
	
	String deleteBooking(ObjectId id);
	
	
}
