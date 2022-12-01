package com.assignment.assignment.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.assignment.assignment.dao.ContactRepository;
import com.assignment.assignment.model.Contact;
import com.assignment.assignment.model.Opportunity;
import com.assignment.assignment.service.ContactService;


@RestController
public class ContactController {

	@Autowired
	private ContactService contactService;
	
	//GET ALL
	@GetMapping("/contacts")
	public List<Contact> findAllContacts(){
		return contactService.findAllContacts();
	}
	
	//GET
	@GetMapping("/contacts/{id}")
	public Contact findContact(@PathVariable int id){
		return contactService.findContact(id);
	}
	
	//POST
	@PostMapping("/contacts")
	public void createContact(@RequestBody Contact contact) {
	contactService.createContact(contact);	
	}
	
	//DELETE
	@DeleteMapping("/contacts/{id}")
	public void deleteContact(@PathVariable int id) {
		contactService.deleteContact(id);
	}
	
	//PUT
	@PutMapping("/contacts/{id}")
	public void editContact(@RequestBody Contact contact ,@PathVariable int id) {
		contactService.editContact(contact);
	}
		
	}
	

