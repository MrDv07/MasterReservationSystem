package com.axis.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.axis.entity.Flight;


@Repository
public interface FlightRepository extends JpaRepository<Flight, Integer> {
	
	Flight findByFlightName(String flightName);
	
	List<Flight> findBySourceAndDestination(String sourceStation, String destination);

}
