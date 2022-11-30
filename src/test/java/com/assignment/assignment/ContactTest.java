package com.assignment.assignment;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Date;
import java.util.Optional;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.assignment.assignment.dao.ContactRepository;
import com.assignment.assignment.model.Contact;
import com.assignment.assignment.model.Opportunity;
import com.assignment.assignment.service.ContactService;

@SpringBootTest
class ContactTest {

	@Autowired
	ContactRepository contactRepository;
	
	@Autowired
	ContactService contactService;
	
	@Test
	@Order(1)
	void createContact() {
		Contact contact = new Contact(3,"Reunion presencial", new Date(2022,11,30,11,35), new Opportunity("test2"));
		contactService.createContact(contact);
		Optional<Contact> tmpOpportunity = contactRepository.findById(3);
		assertTrue(tmpOpportunity.isPresent());
	}
	
	@Test
	@Order(2)
	void deleteContact() {
		contactService.deleteContact(3);
		Optional<Contact> tmpOpportunity = contactRepository.findById(3);
		assertTrue(!tmpOpportunity.isPresent());
	}

}
