package com.axis.TrainService.Controller;


import com.axis.TrainService.Entity.Train;
import com.axis.TrainService.Service.TrainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("api/v1/train")
public class TrainController {

    @Autowired
    private TrainService trainService;

    @PostMapping
	public ResponseEntity<Train> addTrain(@RequestBody Train train){
		return new ResponseEntity<Train>(trainService.addTrain(train), HttpStatus.OK);
	}

	@GetMapping("/findtrain/{id}")
	public ResponseEntity<Train> findTrainById(@PathVariable int id){
		return new ResponseEntity<Train>(trainService.getTrainById(id), HttpStatus.FOUND);
	}
	
	@GetMapping("/findalltrain")
	public ResponseEntity<List<Train>> findAllTrains(){
		return new ResponseEntity<>(trainService.getAllTrains(), HttpStatus.FOUND);
	}


	@GetMapping("/findtrainbystation")
	public ResponseEntity<List<Train>> getTrainByStations(@RequestBody Train train){
		return new ResponseEntity<List<Train>>(trainService.getTrainBySourceAndDestination(train.getSource(), train.getDestination()), HttpStatus.FOUND);
	}

	@GetMapping("/findtrainbytrainname")
	public ResponseEntity<Train> getTrainByName(@RequestBody Train train){
		return new ResponseEntity<Train>(trainService.getTrainByName(train.getTrainName()), HttpStatus.FOUND);
	}
}
