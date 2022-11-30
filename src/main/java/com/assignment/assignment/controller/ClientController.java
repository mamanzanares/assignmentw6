package com.assignment.assignment.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.assignment.assignment.dao.ClientRepository;
import com.assignment.assignment.service.ClientService;

@RestController
public class ClientController {

	@Autowired
	private ClientService clientService;
	
}
