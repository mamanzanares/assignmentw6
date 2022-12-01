package com.assignment.assignment.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.assignment.assignment.dao.ClientRepository;
import com.assignment.assignment.model.Client;

@Service
public class ClientService {
	
	@Autowired
	ClientRepository clientRepository;

	public List<Client> findAllClients() {
		Iterable<Client> dbList = clientRepository.findAll();
		List<Client> tmpList = new ArrayList<>();
		dbList.forEach(tmpList::add);
		return tmpList;
	}

	public Client findClient(int id) {
		Optional<Client> tmp = clientRepository.findById(id);
		Client client = null;
		if(tmp.isPresent()) {
			client=tmp.get();
		}
		return client;
	}
	
	public void createClient(Client client) {
		clientRepository.save(client);
	}
	
}
