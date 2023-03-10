package com.axis.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Bus")
public class Bus {
	
	
	@Id
	@Column(name = "bus_number")
	private int id;
    private String source;
    private String destination;
    private String busName;
    private int hoursOfJourney;
    private int numberOfStops;
    private int fareOfSitter;
    private int fareOfSleeper;
    
    
	public Bus() {
		super();
	}

	
	

	public Bus(int id, String source, String destination, String busName, int hoursOfJourney, int numberOfStops,
			int fareOfSitter, int fareOfSleeper) {
		super();
		this.id = id;
		this.source = source;
		this.destination = destination;
		this.busName = busName;
		this.hoursOfJourney = hoursOfJourney;
		this.numberOfStops = numberOfStops;
		this.fareOfSitter = fareOfSitter;
		this.fareOfSleeper = fareOfSleeper;
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
	
	public String getBusName() {
		return busName;
	}
	
	public void setBusName(String busName) {
		this.busName = busName;
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




	public int getFareOfSitter() {
		return fareOfSitter;
	}




	public void setFareOfSitter(int fareOfSitter) {
		this.fareOfSitter = fareOfSitter;
	}




	public int getFareOfSleeper() {
		return fareOfSleeper;
	}




	public void setFareOfSleeper(int fareOfSleeper) {
		this.fareOfSleeper = fareOfSleeper;
	}
	
	
	
    
}
