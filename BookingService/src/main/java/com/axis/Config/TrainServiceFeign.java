package com.axis.Config;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RequestBody;

import com.axis.Entity.Train;



@FeignClient(name = "Train-Service")
public interface TrainServiceFeign {
    

    
    @GetMapping("/api/v1/train/findtrain")
    Train getTrain(@RequestBody int numberOfMode);





}

