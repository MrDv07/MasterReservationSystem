package com.axis.TrainService.Service;

import com.axis.TrainService.Entity.Train;
import com.axis.TrainService.Exception.InvalidCharacterException;

import java.util.List;

public interface TrainService {

    Train addTrain(Train train);
    
    List<Train> getAllTrains();

    Train getTrainById(int id);

    List<Train> getTrainBySourceAndDestination(String source , String destination);

    Train getTrainByName(String trainName);
}
