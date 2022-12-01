package com.assignment.assignment;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Optional;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.assignment.assignment.dao.ClientRepository;
import com.assignment.assignment.model.Client;
import com.assignment.assignment.model.Opportunity;
import com.assignment.assignment.service.ClientService;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@SpringBootTest
class ClientTest {
	
	static int index;
	
	@Autowired
	ClientRepository clientRepository;
	@Autowired
	ClientService clientService;

	@Test
	void createClient() {
		Client client = new Client("Testing", 500, new Opportunity("test2"));
		clientService.createClient(client);
		Optional<Client> tmpClient = clientRepository.findById(client.getId());
		index = client.getId();
		assertTrue(tmpClient.isPresent());
	
	}

}
