package com.mckesson.consumer.kafkaconfig;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.LongDeserializer;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.apache.commons.lang3.StringUtils;

import java.util.HashMap;
import java.util.Map;

@EnableKafka
@Configuration
public class KafkaConfiguration {

   private final static Logger log = LoggerFactory.getLogger(KafkaConfiguration.class);



    protected static String environmentOrDefault(String envKey, String defaultVal) {
        String val = StringUtils.trimToNull(System.getenv(envKey));
        return (null == val) ? defaultVal : val;
    }


    private static final String KAFKA_BROKERS = environmentOrDefault("KAFKA_BROKER_URIS", "localhost:9092");
    private static final String CONSUMER_ID = environmentOrDefault("CONSUMER_ID", "docker-compose-consumer");
  //  private static final String TOPIC_NAME = environmentOrDefault("TOPIC_NAME", "kafka-example-java-default-topic");


    public ConsumerFactory<String, String> consumerFactory() {
        log.info("in side building consumerFactory ..");

        Map<String, Object> config = new HashMap<>();
        config.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, KAFKA_BROKERS);
        config.put(ConsumerConfig.GROUP_ID_CONFIG, CONSUMER_ID);
        config.put(ConsumerConfig.MAX_POLL_RECORDS_CONFIG, 5);
        config.put(ConsumerConfig.ENABLE_AUTO_COMMIT_CONFIG, "false");
        config.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "earliest");
        config.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        config.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        log.info("Configuration Details are "+config);
        return new DefaultKafkaConsumerFactory<>(config);
    }



    @Bean
    public ConcurrentKafkaListenerContainerFactory<String, String> kafkaListenerContainerFactory() {
        ConcurrentKafkaListenerContainerFactory<String, String> factory = new ConcurrentKafkaListenerContainerFactory();
        log.info("in side kafkaListenerContainerFactory ..");
        factory.setConsumerFactory(consumerFactory());
        return factory;

    }



}
