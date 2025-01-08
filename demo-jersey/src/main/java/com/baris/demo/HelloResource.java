package com.baris.demo;

import com.baris.demo.service.GreetingService;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import static jakarta.ws.rs.core.MediaType.TEXT_PLAIN;

@Path("/hello")
@Component
public class HelloResource {

    @Autowired
    private GreetingService greetingService;

    @GET
    @Produces(TEXT_PLAIN)
    public String index() {
        return greetingService.greet();
    }
}
