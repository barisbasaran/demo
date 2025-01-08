package com.baris.demo;


import com.redis.testcontainers.RedisContainer;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

import static org.assertj.core.api.Assertions.assertThat;

@Testcontainers
@SpringBootTest
@ActiveProfiles("integration")
@Slf4j
public class RedisIntegrationTest {

    @Container
    private static final RedisContainer redisContainer = new RedisContainer("redis:latest")
        .withExposedPorts(6379);

    @Autowired
    private ClientRepository clientRepository;

    @Test
    public void testFindAll() {
        clientRepository.save(Client.builder().id(1).name("ali").email("ali@yahoo.com").build());

        var clients = clientRepository.findAll();
        assertThat(clients.size()).isEqualTo(1);
    }

    @DynamicPropertySource
    private static void registerRedisProperties(DynamicPropertyRegistry registry) {
        registry.add("spring.data.redis.host", redisContainer::getHost);
        registry.add("spring.data.redis.port", () -> redisContainer.getMappedPort(6379).toString());
    }
}
