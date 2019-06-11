package com.demo.activemq.processors;

import com.demo.activemq.models.Person;
import lombok.extern.slf4j.Slf4j;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class SeniorCitizenProcessor implements Processor {

    @Override
    public void process(Exchange exchange) throws Exception {
        Person body = (Person) exchange.getIn().getBody();

        log.debug("Inside senior citizen processor - {}", body.toString());
    }
}
