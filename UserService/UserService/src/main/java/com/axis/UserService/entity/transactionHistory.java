package com.axis.UserService.entity;


import java.time.LocalDate;
import java.util.Date;


public class transactionHistory {

    private int Id;
    private String username;
    private LocalDate bookingDate;
    private String serviceType ;
    private String reservationClass;
    private String source;
    private String destination;
    private Date travelDate;
    private int numberOfPassengers;
    private int numberOfStops;
    private int hoursOfJourney;
    private int fare;

}
