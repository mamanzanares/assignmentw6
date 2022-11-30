package com.assignment.assignment.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.assignment.assignment.dao.OpportunityRepository;
import com.assignment.assignment.model.Opportunity;

@Service
public class OpportunityService {

	@Autowired
	OpportunityRepository opportunityRepository;
	
	public List<Opportunity> findAllOpportunities(){
		Iterable<Opportunity> dbList = opportunityRepository.findAll();
		List<Opportunity> tmpList = new ArrayList<>();
		dbList.forEach(tmpList::add);
		return tmpList;
	}
	
	public Opportunity findOpportunity(String id) {
		Optional<Opportunity> tmp = opportunityRepository.findById(id);
		Opportunity opportunity = null;
		if(tmp.isPresent()) {
			opportunity=tmp.get();
		}
		return opportunity;
	}
	
	public void createOpportunity(Opportunity opportunity) {
		
	}
}
