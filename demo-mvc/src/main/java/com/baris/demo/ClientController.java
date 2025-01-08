package com.baris.demo;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/clients")
public class ClientController {

    @Autowired
    private ClientRepository clientRepository;

    @GetMapping
    public List<Client> getClients() {
        var clients = clientRepository.findAll();
        log.info("Clients: {}", clients);
        return clients;
    }

    @GetMapping("/{id}")
    public Client getClient(@PathVariable Integer id) {
        var client = clientRepository.findById(id).orElseThrow(RuntimeException::new);
        log.info("Client: {}", client);
        return client;
    }

    @PostMapping
    public ResponseEntity createClient(@RequestBody Client client) throws URISyntaxException {
        Client savedClient = clientRepository.save(client);
        log.info("Client created: {}", savedClient);
        return ResponseEntity.created(new URI("/clients/" + savedClient.getId())).body(savedClient);
    }

    @PutMapping("/{id}")
    public ResponseEntity updateClient(@PathVariable Integer id, @RequestBody Client client) {
        Client currentClient = clientRepository.findById(id).orElseThrow(RuntimeException::new);
        currentClient.setName(client.getName());
        currentClient.setEmail(client.getEmail());
        currentClient = clientRepository.save(currentClient);
        log.info("Client updated: {}", currentClient);
        return ResponseEntity.ok(currentClient);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteClient(@PathVariable Integer id) {
        clientRepository.deleteById(id);
        log.info("Client deleted: {}", id);
        return ResponseEntity.ok().build();
    }
}
