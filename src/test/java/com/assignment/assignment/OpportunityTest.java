package com.assignment.assignment;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.assignment.assignment.dao.ContactRepository;
import com.assignment.assignment.dao.OpportunityRepository;
import com.assignment.assignment.model.Contact;
import com.assignment.assignment.model.Opportunity;
import com.assignment.assignment.model.User;
import com.assignment.assignment.service.OpportunityService;
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@SpringBootTest
class OpportunityTest {

	@Autowired
	OpportunityRepository opportunityRepository;
	
	@Autowired
	OpportunityService opportunityService;
	
	@Autowired
	ContactRepository contactRepository;
	
	
	@Test
	@Order(1)
	void createOpportunity() {
		//Creating the opportunity,saving it and getting it from db
		Opportunity opportunity = new Opportunity("test3", "Pedro", null, null,true);
		opportunityService.createOpportunity(opportunity);
		Optional<Opportunity> tmpOpportunity = opportunityRepository.findById("test3");
		//Looking in the list of contacts one with the opportunity id of the one that was created
		Iterable<Contact> tmpContact = contactRepository.findAll();
		List<Contact> tmpList = new ArrayList<>();
		tmpContact.forEach(tmpList::add);
		Iterator it = tmpList.iterator();
		boolean find = false;
		while(it.hasNext()) {
			Contact contact = (Contact)it.next();
			if(contact.getOpportunity().getId().equals(opportunity.getId())) {
				find=true;
			}
		}
		
		assertTrue(tmpOpportunity.isPresent());
		assertTrue(find);
	}
	
	
	@Test
	@Order(2)
	void editOpportunity() {
		Opportunity opportunity = new Opportunity("test3", "Pedro", "622", "mailTestUpdate",true);
		opportunityService.editOpportunity(opportunity);
		Optional<Opportunity> tmpOpportunity = opportunityRepository.findById("test3");
		assertEquals("test3", tmpOpportunity.get().getId());
		assertEquals("622", tmpOpportunity.get().getPhone());
		assertEquals("mailTestUpdate", tmpOpportunity.get().getEmail());
	}
	
	@Test
	@Order(3)
	void deleteOpportunity() {
		opportunityService.deleteOpportunity("test3");
		Optional<Opportunity> tmpOpportunity = opportunityRepository.findById("test3");
		assertEquals(false, tmpOpportunity.get().isVisible());
	}
	
	@Test
	@Order(4)
	void getAllOppotunitiesNotDeleted() {
		List<Opportunity> opportunitiesList = opportunityService.findAllOpportunitiesNotDeleted();
		Iterator it = opportunitiesList.iterator();
		boolean deleted = false;
		while(it.hasNext()) {
			Opportunity tmp = (Opportunity)it.next();
			if(!tmp.isVisible()) {
				deleted=true;
			}
			
		}
		assertTrue(!deleted);
	}

}
