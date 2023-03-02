package com.axis.Service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.axis.Config.TrainServiceFeign;
import com.axis.Entity.Booking;
import com.axis.Entity.Bus;
import com.axis.Entity.Flight;
import com.axis.Entity.Train;
import com.axis.Exception.ZeroException;
import com.axis.Repository.BookingRepository;

@Service
public class BookingServiceImpl implements BookingService{
	
	
    @Autowired
    private BookingRepository bookingRepository;
    
    
    
//    @Autowired
//    private TrainServiceFeign trainServiceClient;
    
    private RestTemplate restTemplate = new RestTemplate();
   
    
    private String trainServiceUrl = "http://localhost:9092/api/v1/train/findtrain/";

	@Override
	public Booking trainbooking(String username, int numberOfPassengers, int numberOfMode,String reservationClass, String travelDate){
		
		
		String trainUrl = trainServiceUrl+numberOfMode;
		
		Train train = restTemplate.getForObject(trainUrl, Train.class);
		
        int fare = calculateFare(train ,reservationClass ,numberOfPassengers);
        
        
       
        Booking booking = new Booking();
        booking.setUsername(username);
        booking.setBookingDate(LocalDate.now());
        booking.setServiceType("Train");
        booking.setNameOfMode(train.getTrainName());
        booking.setNumberOfMode(train.getId());
        booking.setReservationClass(reservationClass);
        booking.setSource(train.getSource());
        booking.setDestination(train.getDestination());
        booking.setTravelDate(travelDate);
        booking.setNumberOfPassengers(numberOfPassengers);
        booking.setNumberOfStops(train.getNumberOfStops());
        booking.setHoursOfJourney(train.getHoursOfJourney());
        booking.setFare(fare);
        
        
        return bookingRepository.save(booking);
    }
    
    private int calculateFare(Train train, String reservationClass, int numberOfPassengers) {
        int fare = 0;
        switch (reservationClass) {
            case "sleeperclass":
                fare = train.getFareOfSleeperClass();
                break;
            case "1ac":
                fare = train.getFareOf1Ac();
                break;
            case "2ac":
                fare = train.getFareOf2Ac();
                break;
            case "3ac":
                fare = train.getFareOf3Ac();
                break;
            default:
                throw new IllegalArgumentException("Invalid reservation class");
        }
        return fare * numberOfPassengers;
	}
    
    private String flightServiceUrl = "http://localhost:9093/api/v1/flight/findflight/";

	@Override
	public Booking flightbooking(String username, int numberOfPassengers, int numberOfMode, String reservationClass,
			String travelDate) {
		
		
		
		String flightUrl = flightServiceUrl+numberOfMode;
		
		Flight flight = restTemplate.getForObject(flightUrl, Flight.class);
		
        int fare = calculateFare(flight ,reservationClass ,numberOfPassengers);
        
        
       
        Booking booking = new Booking();
        booking.setUsername(username);
        booking.setBookingDate(LocalDate.now());
        booking.setServiceType("Flight");
        booking.setNameOfMode(flight.getFlightName());
        booking.setNumberOfMode(flight.getId());
        booking.setReservationClass(reservationClass);
        booking.setSource(flight.getSource());
        booking.setDestination(flight.getDestination());
        booking.setTravelDate(travelDate);
        booking.setNumberOfPassengers(numberOfPassengers);
        booking.setNumberOfStops(flight.getNumberOfStops());
        booking.setHoursOfJourney(flight.getHoursOfJourney());
        booking.setFare(fare);
        
        
        return bookingRepository.save(booking);
    }
    
    private int calculateFare(Flight flight, String reservationClass, int numberOfPassengers) {
        int fare = 0;
        switch (reservationClass) {
            case "EconomyClass":
                fare = flight.getFareOfEconomyClass();
                break;
            case "BusinessClass":
                fare = flight.getFareOfBusinessClass();
                break;
            default:
                throw new IllegalArgumentException("Invalid reservation class");
        }
        return fare * numberOfPassengers;
	}
	
    private String busServiceUrl = "http://localhost:9094/api/v1/bus/findbus/";

	@Override
	public Booking busbooking(String username, int numberOfPassengers, int numberOfMode, String reservationClass,
			String travelDate) {
		
		
		String busUrl = busServiceUrl+numberOfMode;
		
		Bus bus = restTemplate.getForObject(busUrl, Bus.class);
		
        int fare = calculateFare(bus ,reservationClass ,numberOfPassengers);
        
        
       
        Booking booking = new Booking();
        booking.setUsername(username);
        booking.setBookingDate(LocalDate.now());
        booking.setServiceType("Bus");
        booking.setNameOfMode(bus.getBusName());
        booking.setNumberOfMode(bus.getId());
        booking.setReservationClass(reservationClass);
        booking.setSource(bus.getSource());
        booking.setDestination(bus.getDestination());
        booking.setTravelDate(travelDate);
        booking.setNumberOfPassengers(numberOfPassengers);
        booking.setNumberOfStops(bus.getNumberOfStops());
        booking.setHoursOfJourney(bus.getHoursOfJourney());
        booking.setFare(fare);
        
        
        return bookingRepository.save(booking);
    }
    
    private int calculateFare(Bus bus , String reservationClass, int numberOfPassengers) {
        int fare = 0;
        switch (reservationClass) {
            case "sitter":
                fare = bus.getFareOfSitter();
                break;
            case "sleeper":
                fare = bus.getFareOfSleeper();
                break;
            default:
                throw new IllegalArgumentException("Invalid reservation class");
        }
        return fare * numberOfPassengers;
	}

	@Override
	public List<Booking> getAllBookingByUserName(String username) {
		
		return bookingRepository.getBookingByUserName(username);
	}
	
}
    



