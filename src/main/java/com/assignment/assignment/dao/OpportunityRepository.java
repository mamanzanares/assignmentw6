package com.assignment.assignment.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.assignment.assignment.model.Opportunity;

@Repository
public interface OpportunityRepository extends CrudRepository<Opportunity, String>{

}
