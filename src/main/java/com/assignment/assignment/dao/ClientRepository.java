package com.assignment.assignment.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.assignment.assignment.model.Client;

@Repository
public interface ClientRepository extends CrudRepository<Client, Integer> {

}
