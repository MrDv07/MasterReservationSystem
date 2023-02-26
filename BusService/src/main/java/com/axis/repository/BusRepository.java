package com.axis.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.axis.entity.Bus;

@Repository
public interface BusRepository extends JpaRepository<Bus, Integer> {
	
	
    Bus findByBusName(String busName);
	
	List<Bus> findBySourceAndDestination(String sourceStation, String destination);

}
