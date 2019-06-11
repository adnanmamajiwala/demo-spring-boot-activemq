package com.demo.activemq.processors;

import com.demo.activemq.models.Person;
import lombok.extern.slf4j.Slf4j;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class GeneralCitizenProcessor implements Processor {

    @Override
    public void process(Exchange exchange) throws Exception {
        Person body = exchange.getIn().getBody(Person.class);

        log.debug("Inside general citizen processor - {} ", body.toString());
    }
}