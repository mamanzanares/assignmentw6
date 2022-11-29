package com.assignment.assignment.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class User {
	
	@Id
	private String userName;
	@Column(name = "userPass",nullable = false)
	private String pass;
	
	
	public User() {
	}
	
	public User(String userName, String pass) {
		this.userName = userName;
		this.pass = pass;
	}


	public String getUserName() {
		return userName;
	}


	public void setUserName(String userName) {
		this.userName = userName;
	}


	public String getPass() {
		return pass;
	}


	public void setPass(String pass) {
		this.pass = pass;
	}

	
	
	
}
