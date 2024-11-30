package com.hmnt.hungryman.kafka;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.KafkaListener;

import static com.hmnt.hungryman.AppConstants.CONSUMER_GROUP_ID;
import static com.hmnt.hungryman.AppConstants.LOCATION_TOPIC_NAME;

@Configuration
public class KafkaConsumer {

    private static final Logger log = LoggerFactory.getLogger(KafkaConsumer.class);

    @KafkaListener(topics = LOCATION_TOPIC_NAME, groupId = CONSUMER_GROUP_ID)
    public void updatedLocation(String location){
        log.info("Location Data: {}", location);
    }

}
