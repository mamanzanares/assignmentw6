package com.assignment.assignment;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.assignment.assignment.dao.ContactRepository;
import com.assignment.assignment.service.ContactService;

@SpringBootTest
class ContactTest {

	@Autowired
	ContactRepository contactRepository;
	
	@Autowired
	ContactService contactService;
	
	@Test
	void test() {
		fail("Not yet implemented");
	}

}
