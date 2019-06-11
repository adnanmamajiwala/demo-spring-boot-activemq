package com.demo.activemq;

import org.apache.activemq.command.ActiveMQTopic;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfiguration {

    @Bean
    public ActiveMQTopic activeMQTopic(@Value("${topic-name.person}") String topicName){
        return new ActiveMQTopic(topicName);
    }
}
