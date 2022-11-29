package com.assignment.assignment.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.assignment.assignment.dao.ClientRepository;

@RestController
public class ClientController {

	@Autowired
	private ClientRepository clientRepository;
	
}
