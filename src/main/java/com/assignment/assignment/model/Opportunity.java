package com.assignment.assignment.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table
public class Opportunity {
	
	@Id
	@Column(name = "opportunity_id")
	private String id;
	@Column(name = "opportunity_name")
	private String name;
	@Column(name = "opportunity_phone")
	private String phone;
	@Column(name = "opportunity_email")
	private String email;
	@Column(name = "opportunity_client")
	private int clientId;
	
	@OneToOne(mappedBy = "opportunity", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private Client client;
	
    @OneToMany(mappedBy = "opportunity",cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<Contact> contacts = new ArrayList<>();

	public Opportunity() {
	}

	public Opportunity(String id, String name, String phone, String email) {
		this.id = id;
		this.name = name;
		this.phone = phone;
		this.email = email;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public List<Contact> getContacts() {
		return contacts;
	}

	public void setContacts(List<Contact> contacts) {
		this.contacts = contacts;
	}

	public int getClientId() {
		return clientId;
	}

	public void setClientId(int clientId) {
		this.clientId = clientId;
	}
	
	

	
	
}
