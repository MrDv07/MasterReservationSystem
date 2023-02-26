package com.axis.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.axis.entity.Flight;
import com.axis.exception.IdNotValidException;
import com.axis.exception.InvalidCharacterException;
import com.axis.exception.ZeroException;
import com.axis.repository.FlightRepository;

@Service
public class FlightServiceIMPL  implements FlightService{
	
	
	@Autowired
	private FlightRepository flightRepository;

	@Override
	public Flight addFlight(Flight flight) {
		if(flight.getDestination().isBlank() || flight.getSource().isBlank() || flight.getFlightName().isBlank()) {
            throw new InvalidCharacterException("\"flight Name , Source  , Destination cannot be empty or cannot contain space");
        }
        else if (flight.getHoursOfJourney()== 0 ) {
            throw new ZeroException("Hours of Journey cannot be zero");
        }

        return flightRepository.save(flight);
	}

	@Override
	public Flight getFlightById(int id) {
		
		Optional<Flight> fr = flightRepository.findById(id);

        if(fr.isPresent()) {
            return fr.get();
        }
        else {
            throw new IdNotValidException("Invalid Id..!!. There is no Flight by this ID");
        }
		
	}

	@Override
	public List<Flight> getFlightBySourceAndDestination(String source, String destination) {
		
		return flightRepository.findBySourceAndDestination(source, destination);
	}

	@Override
	public Flight getFlightByName(String flightName) {
		
		return flightRepository.findByFlightName(flightName);
	}
	
	

}
