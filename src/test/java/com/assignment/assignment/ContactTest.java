package com.assignment.assignment;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.Date;
import java.sql.Time;
import java.util.Optional;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.assignment.assignment.dao.ContactRepository;
import com.assignment.assignment.model.Contact;
import com.assignment.assignment.model.Opportunity;
import com.assignment.assignment.service.ContactService;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@SpringBootTest
class ContactTest {
	
	static int index;

	@Autowired
	ContactRepository contactRepository;
	
	@Autowired
	ContactService contactService;
	
	@Test
	@Order(1)
	void createContact() {
		Contact contact = new Contact("Reunion presencial", new Date(1669809650000L), new Opportunity("test2"));
		contactService.createContact(contact);
		Optional<Contact> tmpOpportunity = contactRepository.findById(contact.getId());
		index = contact.getId();
		assertTrue(tmpOpportunity.isPresent());
	}
	
	@Test
	@Order(2)
	void editContact() {
		Contact contact = new Contact(index,"Reunion presencial editada",new Date(1669813250000L),new Opportunity("test2"));
		contactService.editContact(contact);
		Optional<Contact> tmpContact = contactRepository.findById(index);
		assertEquals(contact.getId(), tmpContact.get().getId());
		assertEquals(contact.getOpportunity().getId(), tmpContact.get().getOpportunity().getId());
		assertEquals("Reunion presencial editada", tmpContact.get().getDescription());
	}
	
	@Test
	@Order(3)
	void deleteContact() {
		contactService.deleteContact(index);
		Optional<Contact> tmpOpportunity = contactRepository.findById(index);
		assertTrue(!tmpOpportunity.isPresent());
	}

}
