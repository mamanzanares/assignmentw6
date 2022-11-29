package com.assignment.assignment.dao;

import org.springframework.data.repository.CrudRepository;

import com.assignment.assignment.model.User;

public interface UserRepository extends CrudRepository<User, String> {

}
