package com.assignment.assignment.controller;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.assignment.assignment.dao.ClientRepository;
import com.assignment.assignment.model.Client;
import com.assignment.assignment.service.ClientService;


@RestController
public class ClientController {

	@Autowired
	private ClientService clientService;

	//GET ALL
	@GetMapping("/clients")
	public List<Client> findAllClients(){
		return clientService.findAllClients();
	}
	
	//GET
	@GetMapping("/clients/{id}")
	public Client findClients(@PathVariable int id){
		return clientService.findClient(id);
	}
	
	//POST
	@PostMapping("/clients")
	public void createClient(@RequestBody Client client) {
		clientService.createClient(client);
	}
	
}
