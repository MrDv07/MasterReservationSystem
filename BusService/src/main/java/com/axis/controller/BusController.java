package com.axis.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.axis.entity.Bus;
import com.axis.service.BusService;

@RestController
@RequestMapping("/api/v1/bus")
public class BusController {

	@Autowired
	private BusService busService;
	
	@PostMapping
	public ResponseEntity<Bus> addBus(@RequestBody Bus bus){
		return new ResponseEntity<Bus>(busService.addBus(bus), HttpStatus.OK);
	}

	@GetMapping("/findbus/{id}")
	public ResponseEntity<Bus> findBusById(@PathVariable int id){
		return new ResponseEntity<Bus>(busService.getBusById(id), HttpStatus.FOUND);
	}


	@GetMapping("/findbusbystations")
	public ResponseEntity<List<Bus>> getBusByStations(@RequestBody Bus bus){
		return new ResponseEntity<List<Bus>>(busService.getBusBySourceAndDestination(bus.getSource(), bus.getDestination()), HttpStatus.FOUND);
	}

	@GetMapping("/findbusbybusname")
	public ResponseEntity<Bus> getBusByName(@RequestBody Bus bus){
		return new ResponseEntity<Bus>(busService.getBusByName(bus.getBusName()), HttpStatus.FOUND);
	}
}
