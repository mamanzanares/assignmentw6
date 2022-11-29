package com.assignment.assignment.dao;

import org.springframework.data.repository.CrudRepository;

import com.assignment.assignment.model.Client;

public interface ClientRepository extends CrudRepository<Client, Integer> {

}
