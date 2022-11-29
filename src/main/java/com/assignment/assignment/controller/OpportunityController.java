package com.assignment.assignment.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.assignment.assignment.dao.OpportunityRepository;

@RestController
public class OpportunityController {

	@Autowired
	private OpportunityRepository opportunityRepository;
	
}
