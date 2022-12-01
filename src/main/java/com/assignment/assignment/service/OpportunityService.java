package com.assignment.assignment.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.assignment.assignment.dao.OpportunityRepository;
import com.assignment.assignment.model.Client;
import com.assignment.assignment.model.Contact;
import com.assignment.assignment.model.Opportunity;

@Service
public class OpportunityService {

	@Autowired
	OpportunityRepository opportunityRepository;
	@Autowired
	ContactService contactService;
	@Autowired
	ClientService clientService;
	
	public List<Opportunity> findAllOpportunitiesNotDeleted(){
		Iterable<Opportunity> dbList = opportunityRepository.findAllOpportunitiesNotDeleted();
		List<Opportunity> tmpList = new ArrayList<>();
		dbList.forEach(tmpList::add);
		return tmpList;
	}
	
	public Opportunity findOpportunity(String id) {
		Optional<Opportunity> tmp = opportunityRepository.findById(id);
		Opportunity opportunity = null;
		if(tmp.isPresent()) {
			opportunity=tmp.get();
			opportunity.setContacts(contactService.findContactsByIdOp(id));
		}
		return opportunity;
	}
	
	public void createOpportunity(Opportunity opportunity) {
		opportunityRepository.save(opportunity);
		Contact contact = new Contact(null,null,opportunity);
		contactService.createContact(contact);
		
	}
	
	public void deleteOpportunity(String id) {
		Optional<Opportunity> tmp = opportunityRepository.findById(id);
		if(tmp.isPresent()) {
		Opportunity tmpOpportunity = tmp.get();
		tmpOpportunity.setVisible(false);
		opportunityRepository.save(tmpOpportunity);
			}
		}
	
	public void editOpportunity(Opportunity opportunity) {
		opportunityRepository.save(opportunity);
	}
	
	public void vinculateClient(String id,Client client) {
		Optional<Opportunity> opportunity = opportunityRepository.findById(id);
		Opportunity tmpOpportunity = opportunity.get();
		tmpOpportunity.setClientId(client.getId());
		opportunityRepository.save(tmpOpportunity);
	}
	
	public List<Client> findClients(String id){
		return clientService.findAllClients();
	}
}
