package com.axis.TrainService.Service;

import com.axis.TrainService.Entity.Train;
import com.axis.TrainService.Exception.IdNotValidException;
import com.axis.TrainService.Exception.InvalidCharacterException;
import com.axis.TrainService.Exception.ZeroException;
import com.axis.TrainService.Repository.TrainRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class TrainServiceImpl  implements TrainService{

    @Autowired
    private TrainRepository trainRepository;

    @Override
    public Train addTrain(Train train){
        if(train.getDestination().isBlank() || train.getSource().isBlank() || train.getTrainName().isBlank()) {
            throw new InvalidCharacterException("Train Name , Source Station , Destination cannot be empty or cannot contain space");
        }
        else if (train.getHoursOfJourney()== 0 ) {
            throw new ZeroException("Hours of Journey cannot be zero");
        }

        return trainRepository.save(train);
    }

    @Override
    public Train getTrainById(int id) {
        
    	Train train = trainRepository.findById(id).orElseThrow(() -> new IdNotValidException("Id Not Found"));
    	
    	return train;
    }

    @Override
    public List<Train> getTrainBySourceAndDestination(String source, String destination) {
        return trainRepository.findBySourceAndDestination(source , destination);
    }

    @Override
    public Train getTrainByName(String trainName) {
        return trainRepository.findByTrainName(trainName);
    }

	@Override
	public List<Train> getAllTrains() {
		// TODO Auto-generated method stub
		return trainRepository.findAll();
	}
}
