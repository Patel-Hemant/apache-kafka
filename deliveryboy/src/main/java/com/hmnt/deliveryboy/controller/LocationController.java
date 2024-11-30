package com.hmnt.deliveryboy.controller;

import com.hmnt.deliveryboy.kafka.KafkaProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/location")
public class LocationController {

    @Autowired
    private KafkaProducer kafkaProducer;

    @PostMapping("/update")
    public ResponseEntity<?> updateLocation(){
        for (int i = 0; i < 100000; i++) {
            String location  = "location_" + Math.random()*100;
            kafkaProducer.produceLocation(location);
        }
        return new ResponseEntity<>(Map.of("msg","location updated successfully"), HttpStatus.OK);
    }

}
