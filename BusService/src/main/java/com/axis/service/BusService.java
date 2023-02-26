package com.axis.service;

import java.util.List;

import com.axis.entity.Bus;

public interface BusService {
	
	Bus addBus(Bus bus) ;

    Bus getBusById(int id);

    List<Bus> getBusBySourceAndDestination(String source , String destination);

    Bus getBusByName(String busName);

}
