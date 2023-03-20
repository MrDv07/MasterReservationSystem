package com.axis.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


import com.axis.Entity.Booking;
import com.axis.Entity.Bus;
import com.axis.Entity.Flight;
import com.axis.Entity.Train;
import com.axis.Exception.IdNotValidException;
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
	public Booking trainbooking(Booking booking ){
		
		
		String trainUrl = trainServiceUrl+booking.getNumberOfMode();
		
		Train train = restTemplate.getForObject(trainUrl, Train.class);
		
        int fare = calculateFare(train ,booking.getReservationClass() ,booking.getNumberOfPassengers());
        
        
       
        Booking booking2 = new Booking();
        booking2.setUsername(booking.getUsername());
        booking2.setBookingDate(LocalDate.now());
        booking2.setServiceType("Train");
        booking2.setNameOfMode(train.getTrainName());
        booking2.setNumberOfMode(train.getId());
        booking2.setReservationClass(booking.getReservationClass());
        booking2.setSource(train.getSource());
        booking2.setDestination(train.getDestination());
        booking2.setTravelDate(booking.getTravelDate());
        booking2.setNumberOfPassengers(booking.getNumberOfPassengers());
        booking2.setNumberOfStops(train.getNumberOfStops());
        booking2.setHoursOfJourney(train.getHoursOfJourney());
        booking2.setFare(fare);
        
        
        return bookingRepository.save(booking2);
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
	public Booking flightbooking(Booking booking) {
		
		
		
		String flightUrl = flightServiceUrl+booking.getNumberOfMode();
		
		Flight flight = restTemplate.getForObject(flightUrl, Flight.class);
		
        int fare = calculateFare(flight ,booking.getReservationClass() ,booking.getNumberOfPassengers());
        
        
       
        Booking booking2 = new Booking();
        booking2.setUsername(booking.getUsername());
        booking2.setBookingDate(LocalDate.now());
        booking2.setServiceType("Flight");
        booking2.setNameOfMode(flight.getFlightName());
        booking2.setNumberOfMode(flight.getId());
        booking2.setReservationClass(booking.getReservationClass());
        booking2.setSource(flight.getSource());
        booking2.setDestination(flight.getDestination());
        booking2.setTravelDate(booking.getTravelDate());
        booking2.setNumberOfPassengers(booking.getNumberOfPassengers());
        booking2.setNumberOfStops(flight.getNumberOfStops());
        booking2.setHoursOfJourney(flight.getHoursOfJourney());
        booking2.setFare(fare);
        
        
        return bookingRepository.save(booking2);
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
	public Booking busbooking(Booking booking) {
		
		
		String busUrl = busServiceUrl+booking.getNumberOfMode();
		
		Bus bus = restTemplate.getForObject(busUrl, Bus.class);
		
        int fare = calculateFare(bus ,booking.getReservationClass() ,booking.getNumberOfPassengers());
        
        
       
        Booking booking1 = new Booking();
        booking1.setUsername(booking.getUsername());
        booking1.setBookingDate(LocalDate.now());
        booking1.setServiceType("Bus");
        booking1.setNameOfMode(bus.getBusName());
        booking1.setNumberOfMode(bus.getId());
        booking1.setReservationClass(booking.getReservationClass());
        booking1.setSource(bus.getSource());
        booking1.setDestination(bus.getDestination());
        booking1.setTravelDate(booking.getTravelDate());
        booking1.setNumberOfPassengers(booking.getNumberOfPassengers());
        booking1.setNumberOfStops(bus.getNumberOfStops());
        booking1.setHoursOfJourney(bus.getHoursOfJourney());
        booking1.setFare(fare);
        
        
        return bookingRepository.save(booking1);
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

	@Override
	public List<Booking> getAll() {
		
		return bookingRepository.findAll();
	}

	@Override
	public String deleteBooking(ObjectId id) {
	
		Optional<Booking> bh = bookingRepository.findById(id);
		if(bh.isPresent()){
			bookingRepository.deleteById(id);
			return " Booking Cancelled ";
		}
		else 
			throw new IdNotValidException("Id Not Found");
		}
	
	
}
	

    



