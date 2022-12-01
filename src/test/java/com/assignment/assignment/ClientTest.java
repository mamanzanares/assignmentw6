package com.assignment.assignment;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.assignment.assignment.dao.ClientRepository;
import com.assignment.assignment.service.ClientService;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@SpringBootTest
class ClientTest {
	
	@Autowired
	ClientRepository clientRepository;
	@Autowired
	ClientService clientService;

	@Test
	void test() {
		fail("Not yet implemented");
	}

}
