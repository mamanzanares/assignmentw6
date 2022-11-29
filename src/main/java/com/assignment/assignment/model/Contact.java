package com.assignment.assignment.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table
public class Contact {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "contact_id")
	private int id;
	@Column(name = "contact_description")
	private String description;
	@Column(name = "contact_date")
	private Date date;
	
	@ManyToOne
	@JoinColumn(name = "opportunity_id",nullable = false,unique = false)
	private Opportunity opportunity;

	public Contact() {
	}

	public Contact(int id, String description, Date date, Opportunity opportunity) {
		super();
		this.id = id;
		this.description = description;
		this.date = date;
		this.opportunity = opportunity;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Opportunity getOpportunity() {
		return opportunity;
	}

	public void setOpportunity(Opportunity opportunity) {
		this.opportunity = opportunity;
	}
	
	
	
	
	
}
