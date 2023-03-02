package com.axis.Config;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


import com.axis.Entity.Train;



@FeignClient(name = "Train-Service" , url = "http://localhost:9092")
public interface TrainServiceFeign {
    

    
    @GetMapping("/api/v1/train/findtrain/{numberOfMode}")
    Train getTrain(@PathVariable int numberOfMode);





}

