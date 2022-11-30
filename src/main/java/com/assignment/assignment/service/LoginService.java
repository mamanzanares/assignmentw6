package com.assignment.assignment.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.assignment.assignment.dao.UserRepository;
import com.assignment.assignment.model.User;

@Service
public class LoginService {
	
	@Autowired
	private UserRepository userRepository;

	public boolean loginUser(User user) {
		Optional<User> tmp= userRepository.findById(user.getUserName());
		boolean found = false;
		if(!tmp.isEmpty()) {
			if(user.getPass().equals(tmp.get().getPass())) {
			found=true;
			}
		}
		return found;
	}
	
}
