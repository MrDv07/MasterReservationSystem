package com.axis.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Flight")
public class Flight {
	
	
	@Id
	@Column(name = "flight_number")
	private int id;
    private String source;
    private String destination;
    private String flightName;
    private int hoursOfJourney;
    private int numberOfStops;
    private int fareOfEconomyClass;
    private int fareOfBusinessClass;
    
    
	public Flight() {
		super();
	}
	
	
	public Flight(int id, String source, String destination, String flightName, int hoursOfJourney, int numberOfStops,
			int fareOfEconomyClass, int fareOfBusinessClass) {
		super();
		this.id = id;
		this.source = source;
		this.destination = destination;
		this.flightName = flightName;
		this.hoursOfJourney = hoursOfJourney;
		this.numberOfStops = numberOfStops;
		this.fareOfEconomyClass = fareOfEconomyClass;
		this.fareOfBusinessClass = fareOfBusinessClass;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	public String getFlightName() {
		return flightName;
	}
	public void setFlightName(String flightName) {
		this.flightName = flightName;
	}
	public int getHoursOfJourney() {
		return hoursOfJourney;
	}
	public void setHoursOfJourney(int hoursOfJourney) {
		this.hoursOfJourney = hoursOfJourney;
	}
	public int getNumberOfStops() {
		return numberOfStops;
	}
	public void setNumberOfStops(int numberOfStops) {
		this.numberOfStops = numberOfStops;
	}
	public int getFareOfEconomyClass() {
		return fareOfEconomyClass;
	}
	public void setFareOfEconomyClass(int fareOfEconomyClass) {
		this.fareOfEconomyClass = fareOfEconomyClass;
	}
	public int getFareOfBusinessClass() {
		return fareOfBusinessClass;
	}
	public void setFareOfBusinessClass(int fareOfBusinessClass) {
		this.fareOfBusinessClass = fareOfBusinessClass;
	}
   

    
    
}
