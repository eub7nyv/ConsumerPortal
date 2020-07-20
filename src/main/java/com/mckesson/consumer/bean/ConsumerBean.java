package com.mckesson.consumer.bean;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "t_consumer_data")
public class ConsumerBean  {


    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int ID;
    private String topicName;
    private String message; //Payer_Name
    private String payerId;
    private String parentid;

    public ConsumerBean(){

    }

    public ConsumerBean(String topicName, String message, String payerId, String parentid) {
        this.topicName = topicName;
        this.message = message;
        this.payerId = payerId;
        this.parentid = parentid;
    }

    public String getTopicName() {
        return topicName;
    }

    public void setTopicName(String topicName) {
        this.topicName = topicName;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getPayerId() {
        return payerId;
    }

    public void setPayerId(String payerId) {
        this.payerId = payerId;
    }

    public String getParentid() {
        return parentid;
    }

    public void setParentid(String parentid) {
        this.parentid = parentid;
    }
}
