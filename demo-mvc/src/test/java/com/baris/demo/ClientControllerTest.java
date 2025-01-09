package com.baris.demo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.ActiveProfiles;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

@SpringBootTest(webEnvironment = RANDOM_PORT)
@ActiveProfiles("unit")
public class ClientControllerTest {

    @Autowired
    private TestRestTemplate template;

    @Test
    public void createAndGetClient() {
        var client = Client.builder().name("ali").email("ali@yahoo.com").build();
        template.postForEntity("/clients", client, Client.class);

        var clientCreated = template.getForObject("/clients/1", Client.class);
        assertThat(clientCreated).isNotNull();
        assertThat(clientCreated.getId()).isEqualTo(1);
        assertThat(clientCreated.getName()).isEqualTo("ali");
        assertThat(clientCreated.getEmail()).isEqualTo("ali@yahoo.com");

        template.delete("/clients/1");
    }

    @Test
    public void getClients() {
        template.postForEntity("/clients", Client.builder().name("ali").email("ali@yahoo.com").build(), Client.class);
        template.postForEntity("/clients", Client.builder().name("veli").email("veli@yahoo.com").build(), Client.class);

        var clients = template.getForObject("/clients", List.class);

        assertThat(clients.size()).isEqualTo(2);
    }
}
