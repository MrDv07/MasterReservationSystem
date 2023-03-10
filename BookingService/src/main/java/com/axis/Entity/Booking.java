package com.axis.Entity;

import java.time.LocalDate;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;



@Document(collection = "Bookings")
public class Booking {
	
	@org.springframework.data.annotation.Id
	private ObjectId Id;
	private String username;
    private LocalDate bookingDate;
    private String serviceType ;
    private String nameOfMode ;
    private int numberOfMode;
    private String reservationClass;
    private String source;
    private String destination;
    private String travelDate;
    private int numberOfPassengers;
    private int numberOfStops;
    private int hoursOfJourney;
    private int fare;
    
    
	public Booking() {
		super();
	}
	
	
	
	public Booking(ObjectId id, String username, LocalDate bookingDate, String serviceType, String nameOfMode,
			int numberOfMode, String reservationClass, String source, String destination, String travelDate,
			int numberOfPassengers, int numberOfStops, int hoursOfJourney, int fare) {
		super();
		Id = id;
		this.username = username;
		this.bookingDate = bookingDate;
		this.serviceType = serviceType;
		this.nameOfMode = nameOfMode;
		this.numberOfMode = numberOfMode;
		this.reservationClass = reservationClass;
		this.source = source;
		this.destination = destination;
		this.travelDate = travelDate;
		this.numberOfPassengers = numberOfPassengers;
		this.numberOfStops = numberOfStops;
		this.hoursOfJourney = hoursOfJourney;
		this.fare = fare;
	}


	public String getNameOfMode() {
		return nameOfMode;
	}


	public void setNameOfMode(String nameOfMode) {
		this.nameOfMode = nameOfMode;
	}


	public int getNumberOfMode() {
		return numberOfMode;
	}


	public void setNumberOfMode(int numberOfMode) {
		this.numberOfMode = numberOfMode;
	}

	
	public ObjectId getId() {
		return Id;
	}
	
	
	public void setId(ObjectId id) {
		Id = id;
	}
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public LocalDate getBookingDate() {
		return bookingDate;
	}
	public void setBookingDate(LocalDate bookingDate) {
		this.bookingDate = bookingDate;
	}
	public String getServiceType() {
		return serviceType;
	}
	public void setServiceType(String serviceType) {
		this.serviceType = serviceType;
	}
	public String getReservationClass() {
		return reservationClass;
	}
	public void setReservationClass(String reservationClass) {
		this.reservationClass = reservationClass;
	}
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}
	public String getDestination() {
		return destination;
	}
	public void setDestination(String destination) {
		this.destination = destination;
	}
	public String getTravelDate() {
		return travelDate;
	}
	public void setTravelDate(String travelDate) {
		this.travelDate = travelDate;
	}
	public int getNumberOfPassengers() {
		return numberOfPassengers;
	}
	public void setNumberOfPassengers(int numberOfPassengers) {
		this.numberOfPassengers = numberOfPassengers;
	}
	public int getNumberOfStops() {
		return numberOfStops;
	}
	public void setNumberOfStops(int numberOfStops) {
		this.numberOfStops = numberOfStops;
	}
	public int getHoursOfJourney() {
		return hoursOfJourney;
	}
	public void setHoursOfJourney(int hoursOfJourney) {
		this.hoursOfJourney = hoursOfJourney;
	}
	public int getFare() {
		return fare;
	}
	public void setFare(int fare) {
		this.fare = fare;
	}
  
}
