package com.axis.service;

import java.util.List;

import com.axis.entity.Flight;



public interface FlightService {
	
	
	Flight addFlight(Flight flight) ;

    Flight getFlightById(int id);

    List<Flight> getFlightBySourceAndDestination(String source , String destination);

    Flight getFlightByName(String flightName);

}
