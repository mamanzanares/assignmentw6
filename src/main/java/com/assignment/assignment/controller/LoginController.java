package com.assignment.assignment.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.assignment.assignment.dao.UserRepository;
import com.assignment.assignment.model.User;

@Controller
@RequestMapping(path = "/login")
public class LoginController {

	@Autowired
	private UserRepository userRepository;
	
	@PostMapping("/login")
	public boolean loginUser(@RequestBody User user) {
		Optional<User> tmp= userRepository.findById(user.getUserName());
		boolean found = false;
		if(tmp!=null) {
			if(user.getPass().equals(tmp.get().getPass())) {
			found=true;
			}
		}
		return found;
	}
	
}
