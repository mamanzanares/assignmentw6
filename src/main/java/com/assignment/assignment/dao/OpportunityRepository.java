package com.assignment.assignment.dao;


import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.assignment.assignment.model.Opportunity;

@Repository
public interface OpportunityRepository extends CrudRepository<Opportunity, String>{

	@Query(value = "from Opportunity o where o.visible=true")
	Iterable<Opportunity> findAllOpportunitiesNotDeleted();
	
}
