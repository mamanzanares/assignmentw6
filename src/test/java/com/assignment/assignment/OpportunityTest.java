package com.assignment.assignment;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.assignment.assignment.dao.OpportunityRepository;
import com.assignment.assignment.model.Opportunity;
import com.assignment.assignment.model.User;
import com.assignment.assignment.service.OpportunityService;

@SpringBootTest
class OpportunityTest {

	@Autowired
	OpportunityRepository opportunityRepository;
	
	@Autowired
	OpportunityService opportunityService;
	
	@Test
	void createOpportunity() {
		Opportunity opportunity = new Opportunity("test3", "Pedro", null, null);
		opportunityService.createOpportunity(opportunity);
		Optional<Opportunity> tmpOpportunity = opportunityRepository.findById("test3");
		assertTrue(tmpOpportunity.isPresent());
	}

}
