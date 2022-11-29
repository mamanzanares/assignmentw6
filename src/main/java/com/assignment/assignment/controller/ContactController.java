package com.assignment.assignment.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.assignment.assignment.dao.ContactRepository;

@RestController
public class ContactController {

	@Autowired
	private ContactRepository contactRepository;
	
}
