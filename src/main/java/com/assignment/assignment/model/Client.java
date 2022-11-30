package com.assignment.assignment.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table
public class Client {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "client_id")
	private int id;
	@Column(name = "client_name")
	private String name;
	@Column(name = "client_budget")
	private double budget;
	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "opportunity_id",nullable = false,unique = true)
	@JsonManagedReference
	private Opportunity opportunity;

	public Client() {
	}

	public Client(int id, String name, double budget, Opportunity opportunity) {
		this.id = id;
		this.name = name;
		this.budget = budget;
		this.opportunity = opportunity;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getBudget() {
		return budget;
	}

	public void setBudget(double budget) {
		this.budget = budget;
	}

	public Opportunity getOpportunity() {
		return opportunity;
	}

	public void setOpportunity(Opportunity opportunity) {
		this.opportunity = opportunity;
	}
	
	
	
	
	
	

}
