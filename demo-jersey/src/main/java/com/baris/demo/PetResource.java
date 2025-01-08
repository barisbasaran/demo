package com.baris.demo;

import com.baris.demo.model.Pet;
import com.baris.demo.service.PetRepository;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

import static jakarta.ws.rs.core.MediaType.APPLICATION_JSON;

@Path("/pets")
@Consumes(APPLICATION_JSON)
@Produces(APPLICATION_JSON)
@Component
@Slf4j
public class PetResource {

    @Autowired
    private PetRepository petRepository;

    @GET
    public List<Pet> pets() {
        var pets = petRepository.findAll();
        log.info("Returning pets {}", pets);
        return pets;
    }

    @POST
    public Pet createPet(Pet pet) {
        var petCreated = petRepository.save(pet);
        log.info("Created pet {}", petCreated);
        return petCreated;
    }

    @Path("/{petId}")
    @GET
    public Pet getPet(@PathParam("petId") int petId) {
        var pet = petRepository.findById(petId);
        log.info("Returning pet {}", pet);
        return pet;
    }
}
