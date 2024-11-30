package com.hmnt.deliveryboy.kafka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import static com.hmnt.deliveryboy.AppConstants.LOCATION_TOPIC_NAME;

@Service
public class KafkaProducer {

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    public boolean produceLocation(String location){
        kafkaTemplate.send(LOCATION_TOPIC_NAME, location);
        return true;
    }

}
