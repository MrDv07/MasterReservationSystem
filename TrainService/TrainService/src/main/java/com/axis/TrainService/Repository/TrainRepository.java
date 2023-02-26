package com.axis.TrainService.Repository;

import com.axis.TrainService.Entity.Train;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TrainRepository extends JpaRepository<Train , Integer> {

    Train findByTrainName(String trainName);

    List<Train> findBySourceAndDestination(String sourceStation, String destination);
}
