package com.assignment.assignment;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Optional;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.assignment.assignment.controller.LoginController;
import com.assignment.assignment.dao.UserRepository;
import com.assignment.assignment.model.User;

@SpringBootTest
class LoginTest {

	@Autowired
   private LoginController loginController;
	
	@Test
	void login() {
		boolean found= loginController.loginUser(new User("admin","admin"));
		assertEquals(true,found);
	}
	
}
