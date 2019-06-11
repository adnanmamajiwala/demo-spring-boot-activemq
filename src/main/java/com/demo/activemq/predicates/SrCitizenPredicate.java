package com.demo.activemq.predicates;


import com.demo.activemq.models.Person;
import org.apache.camel.Exchange;
import org.apache.camel.Predicate;
import org.springframework.stereotype.Service;

@Service
public class SrCitizenPredicate implements Predicate {

    @Override
    public boolean matches(Exchange exchange) {
        Person body = exchange.getIn().getBody(Person.class);
        return body.getAge() >= 60;
    }
}
