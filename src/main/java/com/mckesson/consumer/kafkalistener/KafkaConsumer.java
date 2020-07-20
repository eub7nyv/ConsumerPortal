package com.mckesson.consumer.kafkalistener;

import com.mckesson.consumer.service.ConsumerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumer {


    @Autowired
    ConsumerService consumerService;


       @KafkaListener(topics="time-topic" , groupId = "docker-compose-consumer")
       public String consumer(String message){

        System.out.println("Message From >>>>"+message);






        //consumerService.insertConsumerData();


        //To save the Data DB


        return message;
    }

 /*   @KafkaListener(topics="time-topic" , groupId = "docker-compose-consumer")
    public String consumerTopic2(String message){

        System.out.println("Message is Fom Customer2  >>>>"+message);

        return message;
    }
    */


}
