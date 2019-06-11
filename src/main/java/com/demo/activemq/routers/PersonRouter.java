package com.demo.activemq.routers;

import com.demo.activemq.models.Person;
import com.demo.activemq.predicates.SrCitizenPredicate;
import com.demo.activemq.processors.GeneralCitizenProcessor;
import com.demo.activemq.processors.SeniorCitizenProcessor;
import lombok.RequiredArgsConstructor;
import org.apache.camel.Predicate;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class PersonRouter extends RouteBuilder {

    @Value("${topic-name.person}")
    private String personTopicName;

    private final SeniorCitizenProcessor seniorCitizenProcessor;
    private final GeneralCitizenProcessor generalCitizenProcessor;
    private final SrCitizenPredicate predicate;

    @Override
    public void configure() throws Exception {

        from(String.format("activemq:topic:%s", personTopicName))
                .choice()
                    .when(predicate)
//                    .when(getPredicate())
                    .process(seniorCitizenProcessor)
                .otherwise()
                    .process(generalCitizenProcessor)
                .end();


    }

    private Predicate getPredicate() {
        return exchange -> {
            Person body = exchange.getIn().getBody(Person.class);
            return body.getAge() >= 60;
        };
    }


}
