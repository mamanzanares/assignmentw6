package com.assignment.assignment.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.assignment.assignment.dao.ClientRepository;

@Service
public class ClientService {
	
	@Autowired
	ClientRepository clientRepository;

}
