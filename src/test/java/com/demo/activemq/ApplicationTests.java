package com.demo.activemq;

import com.demo.activemq.models.Person;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;

public class ApplicationTests {

    @Test
    public void contextLoads() throws Exception {
        System.out.println(new ObjectMapper().writerWithDefaultPrettyPrinter()
                .writeValueAsString(new Person("Test", "ing", 23)));

    }

}
