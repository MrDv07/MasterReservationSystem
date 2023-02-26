package com.axis.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.axis.entity.Bus;
import com.axis.exception.IdNotValidException;
import com.axis.exception.InvalidCharacterException;
import com.axis.exception.ZeroException;
import com.axis.repository.BusRepository;


@Service
public class BusServiceIMPL implements BusService{
	
	@Autowired
	private BusRepository busRepository;

	@Override
	public Bus addBus(Bus bus) {
		if(bus.getDestination().isBlank() || bus.getSource().isBlank() || bus.getBusName().isBlank()) {
            throw new InvalidCharacterException("\"Bus Name , Source  , Destination cannot be empty or cannot contain space");
        }
        else if (bus.getHoursOfJourney()== 0 ) {
            throw new ZeroException("Hours of Journey cannot be zero");
        }

        return busRepository.save(bus);
	}

	@Override
	public Bus getBusById(int id) {
		Optional<Bus> fr = busRepository.findById(id);

        if(fr.isPresent()) {
            return fr.get();
        }
        else {
            throw new IdNotValidException("Invalid Id..!!. There is no Bus by this ID");
        }
	}

	@Override
	public List<Bus> getBusBySourceAndDestination(String source, String destination) {
		// TODO Auto-generated method stub
		return busRepository.findBySourceAndDestination(source, destination);
	}

	@Override
	public Bus getBusByName(String busName) {
		// TODO Auto-generated method stub
		return busRepository.findByBusName(busName);
	}

}
