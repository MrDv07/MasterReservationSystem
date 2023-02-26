package com.axis.UserService.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
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
