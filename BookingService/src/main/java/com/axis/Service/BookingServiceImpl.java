package com.axis.Service;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.axis.Config.TrainServiceFeign;
import com.axis.Entity.Booking;
import com.axis.Entity.Train;
import com.axis.Exception.ZeroException;
import com.axis.Repository.BookingRepository;

@Service
public class BookingServiceImpl implements BookingService{
	
	
    @Autowired
    private BookingRepository bookingRepository;
    
    
    
    @Autowired
    private TrainServiceFeign trainServiceClient;
    
    

	@Override
	public Booking trainbooking(String username, int numberOfPassengers, int numberOfMode,String reservationClass, String travelDate){
		
		if(numberOfPassengers == 0) {
			throw new ZeroException("Id Not Valid");
		}
		
		Train train = trainServiceClient.getTrain(numberOfMode);
        int fare = calculateFare(train,reservationClass ,numberOfPassengers);
        
       
        Booking booking = new Booking();
        booking.setUsername(username);
        booking.setBookingDate(LocalDate.now());
        booking.setServiceType("Train");
        booking.setNameOfMode(train.getTrainName());
        booking.setNumberOfMode(numberOfMode);
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
	
}
    



