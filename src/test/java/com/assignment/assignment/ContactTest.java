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
	
	static int index;

	@Autowired
	ContactRepository contactRepository;
	
	@Autowired
	ContactService contactService;
	
	@Test
	@Order(1)
	void createContact() {
		Contact contact = new Contact("Reunion presencial", new Date(2022,11,30,11,35), new Opportunity("test2"));
		contactService.createContact(contact);
		Optional<Contact> tmpOpportunity = contactRepository.findById(contact.getId());
		index = contact.getId();
		assertTrue(tmpOpportunity.isPresent());
	}
	
	@Test
	@Order(2)
	void editContact() {
		Contact contact = new Contact(index,"Reunion presencial editada",new Date(2022,11,30,12,35),new Opportunity("test2"));
		contactService.editContact(contact);
		Optional<Contact> tmpContact = contactRepository.findById(index);
		assertEquals(contact, tmpContact.get());
	}
	
	@Test
	@Order(3)
	void deleteContact() {
		contactService.deleteContact(index);
		Optional<Contact> tmpOpportunity = contactRepository.findById(index);
		assertTrue(!tmpOpportunity.isPresent());
	}

}
