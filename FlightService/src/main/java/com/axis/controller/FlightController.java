package com.axis.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.axis.entity.Flight;

import com.axis.service.FlightService;

@RestController
@RequestMapping("/api/v1/flight")
@CrossOrigin(origins = "http://localhost:3000")
public class FlightController {
	
	@Autowired
	private FlightService flightService;
	
	
	@PostMapping
	public ResponseEntity<Flight> addFlight(@RequestBody Flight flight){
		return new ResponseEntity<Flight>(flightService.addFlight(flight), HttpStatus.OK);
	}

	@GetMapping("/findflight/{id}")
	public ResponseEntity<Flight> findFlightById(@PathVariable int id){
		return new ResponseEntity<Flight>(flightService.getFlightById(id), HttpStatus.FOUND);
	}


	@GetMapping("/findflightbyairports")
	public ResponseEntity<List<Flight>> getFlightByStations(@RequestBody Flight flight){
		return new ResponseEntity<List<Flight>>(flightService.getFlightBySourceAndDestination(flight.getSource(), flight.getDestination()), HttpStatus.FOUND);
	}

	@GetMapping("/findflightbyflightname")
	public ResponseEntity<Flight> getFlightByName(@RequestBody Flight flight){
		return new ResponseEntity<Flight>(flightService.getFlightByName(flight.getFlightName()), HttpStatus.FOUND);
	}

}
