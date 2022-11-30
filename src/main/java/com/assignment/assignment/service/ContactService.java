package com.assignment.assignment.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.assignment.assignment.dao.ContactRepository;
import com.assignment.assignment.model.Contact;
import com.assignment.assignment.model.Opportunity;

@Service
public class ContactService {

	@Autowired
	ContactRepository contactRepository;

	public List<Contact> findAllContacts() {
		Iterable<Contact> dbList = contactRepository.findAll();
		List<Contact> tmpList = new ArrayList<>();
		dbList.forEach(tmpList::add);
		return tmpList;
	}

	public Contact findContact(int id) {
		Optional<Contact> tmp = contactRepository.findById(id);
		Contact contact = null;
		if(tmp.isPresent()) {
			contact=tmp.get();
		}
		return contact;
	}
	
	public void createContact(Contact contact) {
		contactRepository.save(contact);
	}
	
	public void deleteContact(int id) {
		
	}
}
