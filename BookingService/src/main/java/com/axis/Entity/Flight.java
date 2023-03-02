package com.axis.Entity;

public class Flight {
	
	private int id;
    private String source;
    private String destination;
    private String flightName;
    private int hoursOfJourney;
    private int numberOfStops;
    private int fareOfEconomyClass;
    private int fareOfBusinessClass;
    
    
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
