package com.baris.demo;


import com.baris.demo.model.Pet;
import com.baris.demo.model.Species;
import com.baris.demo.service.PetRepository;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

import static org.assertj.core.api.Assertions.assertThat;

@Testcontainers
@SpringBootTest
@ActiveProfiles("integration")
@Slf4j
public class DatabaseIntegrationTest {

    @Container
    public static PostgreSQLContainer<?> postgreSQLContainer = new PostgreSQLContainer<>("postgres:latest")
        .withDatabaseName("it-db")
        .withUsername("sa")
        .withPassword("sa");

    @Autowired
    private PetRepository petRepository;

    @Test
    public void testFindAll() {
        var jdbcUrl = postgreSQLContainer.getJdbcUrl();
        log.info("JDBC URL: {}", jdbcUrl);

        petRepository.save(Pet.builder().name("lucky").age(2).species(Species.DOG).build());

        var pets = petRepository.findAll();
        assertThat(pets.size()).isEqualTo(1);
    }
}
