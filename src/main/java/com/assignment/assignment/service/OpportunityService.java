package com.assignment.assignment.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.assignment.assignment.dao.OpportunityRepository;

@Service
public class OpportunityService {

	@Autowired
	OpportunityRepository opportunityRepository;
}
