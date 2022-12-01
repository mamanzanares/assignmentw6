package com.assignment.assignment;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.assignment.assignment.dao.ClientRepository;
import com.assignment.assignment.model.Client;
import com.assignment.assignment.model.Contact;
import com.assignment.assignment.model.Opportunity;
import com.assignment.assignment.service.ClientService;
import com.assignment.assignment.service.OpportunityService;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@SpringBootTest
class ClientTest {
	
	static int index;
	
	@Autowired
	ClientRepository clientRepository;
	@Autowired
	ClientService clientService;
	
	@Autowired
	OpportunityService opportunityService;

	@Test
	void createClient() {
		//Creation,saving in db and validation of the client
		Client client = new Client("Testing", 500, new Opportunity("test2"));
		clientService.createClient(client);
		Optional<Client> tmpClient = clientRepository.findById(client.getId());
		index = client.getId();
		assertTrue(tmpClient.isPresent());
		
		//Seach in the opportunity list for one with the client id of the one created
		Iterable<Opportunity> tmpOpportunity = opportunityService.findAllOpportunitiesNotDeleted();
		List<Opportunity> tmpList = new ArrayList<>();
		tmpOpportunity.forEach(tmpList::add);
		Iterator it = tmpList.iterator();
		boolean found = false;
		while(it.hasNext()) {
			Opportunity opportunity = (Opportunity)it.next();
			if(opportunity.getClientId()==index) {
				found= true;
			}
		}
		assertTrue(found);
	}

}
