package com.mckesson.consumer.controller;

import com.mckesson.consumer.bean.ConsumerBean;
import com.mckesson.consumer.kafkalistener.KafkaConsumer;
import com.mckesson.consumer.service.ConsumerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MckessonController {

    @Autowired
    ConsumerService consumerService;


    @GetMapping("/greeting")
    public String greeting() {
        return "Hello From  MckessonController >> Check Heart Beat";
    }


    @RequestMapping(value = "/insertConsumerData", method = RequestMethod.POST)
    public void insertEmployee(@RequestBody ConsumerBean consumerBean) {
        consumerService.insertConsumerData(consumerBean);
    }

    @RequestMapping(value= "/listofMessages")
    public List<ConsumerBean> getAll() {
        return consumerService.getAllConsumerDataList();
    }


}
