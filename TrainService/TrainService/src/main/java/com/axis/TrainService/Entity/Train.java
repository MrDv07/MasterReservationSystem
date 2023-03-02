package com.axis.TrainService.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;



@Entity
@Table(name= "Train_Details")
public class Train {

    @Id
    @Column(name = "Train_Number")
    private int id;
    private String source;
    private String destination;
    private String trainName;
    private int hoursOfJourney;
    private int numberOfStops;
    private int fareOfSleeperClass;
    private int fareOf3Ac;
    private int fareOf2Ac;
    private int fareOf1Ac;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getTrainName() {
        return trainName;
    }

    public void setTrainName(String trainName) {
        this.trainName = trainName;
    }

    public int getHoursOfJourney() {
        return hoursOfJourney;
    }

    public void setHoursOfJourney(int hoursOfJourney) {
        this.hoursOfJourney = hoursOfJourney;
    }

    public int getNumberOfStops() {
        return numberOfStops;
    }

    public void setNumberOfStops(int numberOfStops) {
        this.numberOfStops = numberOfStops;
    }

    public int getFareOfSleeperClass() {
        return fareOfSleeperClass;
    }

    public void setFareOfSleeperClass(int fareOfSleeperClass) {
        this.fareOfSleeperClass = fareOfSleeperClass;
    }

    public int getFareOf3Ac() {
        return fareOf3Ac;
    }

    public void setFareOf3Ac(int fareOf3Ac) {
        this.fareOf3Ac = fareOf3Ac;
    }

    public int getFareOf2Ac() {
        return fareOf2Ac;
    }

    public void setFareOf2Ac(int fareOf2Ac) {
        this.fareOf2Ac = fareOf2Ac;
    }

    public int getFareOf1Ac() {
        return fareOf1Ac;
    }

    public void setFareOf1Ac(int fareOf1Ac) {
        this.fareOf1Ac = fareOf1Ac;
    }
}
