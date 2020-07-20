package com.mckesson.consumer.service;

import com.mckesson.consumer.bean.ConsumerBean;
import com.mckesson.consumer.dao.ConsumerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

@Service
public class ConsumerService {

    @Autowired
    ConsumerRepository consumerRepository;

    public void insertConsumerData(ConsumerBean consumerBean ) {
        consumerRepository.save(consumerBean);

    }

    public List<ConsumerBean> getAllConsumerDataList(){
        final List<ConsumerBean> students = new ArrayList<>();

        for (ConsumerBean consumerBean : consumerRepository.findAll()) {
            System.err.println("Hello Here -----"+consumerBean.getMessage());
            students.add(consumerBean);
        }
        return students;
    }

    public String insertKafkaConsumerData(String message){

        List<String> list= processMessageData(message);

        ConsumerBean consumerBean =new ConsumerBean();
        if(list!=null && !list.isEmpty()){
            consumerBean.setPayerId(list.get(0));
            consumerBean.setMessage(list.get(1));
            consumerBean.setParentid(list.get(2));
        }
         consumerRepository.save(consumerBean);

        return "Data Saves Sucefully...!!!!!";
    }


    private   List<String> processMessageData(String str) {
        return Collections.list(new StringTokenizer(str, "|")).stream()
                .map(token -> (String) token)
                .collect(Collectors.toList());
    }


}
