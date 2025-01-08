package com.baris.demo;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.stereotype.Component;

/**
 * Registers the REST resources, filters etc.
 */
@Component
public class JerseyConfig extends ResourceConfig {

    public JerseyConfig() {
        // register resources
        register(HelloResource.class);
        register(PetResource.class);
    }
}
