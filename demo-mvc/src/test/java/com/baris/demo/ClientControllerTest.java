package com.baris.demo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

@SpringBootTest(webEnvironment = RANDOM_PORT)
@ActiveProfiles("unit")
public class ClientControllerTest {

    @Autowired
    private TestRestTemplate template;

    @Test
    public void getClient() {
        var client = Client.builder().name("ali").email("ali@yahoo.com").build();
        template.postForEntity("/clients", client, Client.class);

        ResponseEntity<Client> response = template.getForEntity("/clients/1", Client.class);
        var clientCreated = response.getBody();

        assertThat(response.getStatusCode()).isEqualTo(HttpStatusCode.valueOf(200));
        assertThat(clientCreated).isNotNull();
        assertThat(clientCreated.getId()).isEqualTo(1);
        assertThat(clientCreated.getName()).isEqualTo("ali");
        assertThat(clientCreated.getEmail()).isEqualTo("ali@yahoo.com");
    }
}
