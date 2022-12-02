package com.assignment.assignment.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.assignment.assignment.dao.OpportunityRepository;
import com.assignment.assignment.model.Client;
import com.assignment.assignment.model.Opportunity;
import com.assignment.assignment.service.OpportunityService;

@RestController
@CrossOrigin
public class OpportunityController {

	@Autowired
	private OpportunityService opportunityService;
	
	//GET ALL
	@GetMapping("/opportunities")
	public List<Opportunity> findAllOpportunities(){
		return opportunityService.findAllOpportunitiesNotDeleted();
	}
	
	//GET
	@GetMapping("/opportunities/{id}")
	public Opportunity findOpportunity(@PathVariable String id){
		return opportunityService.findOpportunity(id);
	}
	
	//POST 
	@PostMapping("/opportunities")
	public void createOpportunity(@RequestBody Opportunity opportunity) {
	opportunityService.createOpportunity(opportunity);	
	}
	
	//DELETE
	@PostMapping("/opportunities/{id}")
	public void deleteContact(@PathVariable String id) {
		opportunityService.deleteOpportunity(id);
	}
	
	//PUT
		@PostMapping("/opportunities/update/{id}")
		public void editOpportunity(@RequestBody Opportunity opportunity,@PathVariable String id) {
			opportunityService.editOpportunity(opportunity);
		}
	
		//GET List of clients
		@GetMapping("opportunities/{id}/clients")
		public List<Client> findAllClients(@PathVariable String id){
			return opportunityService.findClients(id);
			
		}
		
		//POST Associate client
		@PostMapping("opportunities/{id}/clients")
		public void vinculateClient(@PathVariable String id,@RequestBody Client client) {
			opportunityService.vinculateClient(id,client);
		}
	
	
		
}
