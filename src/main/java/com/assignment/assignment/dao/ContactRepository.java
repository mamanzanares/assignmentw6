package com.assignment.assignment.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.assignment.assignment.model.Contact;

@Repository
public interface ContactRepository extends CrudRepository<Contact, Integer>{

	@Query(value = "select id,description,date from Contact where opportunity_id=:id")
	Iterable<Contact> findContactByIdOpportunity(String id);
	
}
