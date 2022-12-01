package com.assignment.assignment;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.sql.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

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
	
	/*
	@Test
	@Order(1)
	void createOpportunity() {
		Opportunity opportunity = new Opportunity("test3", "Pedro", null, null,true);
		opportunityService.createOpportunity(opportunity);
		Optional<Opportunity> tmpOpportunity = opportunityRepository.findById("test3");
		assertTrue(tmpOpportunity.isPresent());
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
	*/
	@Test
	@Order(4)
	void getAllOppotunitiesNotDeleted() {
		List<Opportunity> opportunitiesList = opportunityService.findAllOpportunities();
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
