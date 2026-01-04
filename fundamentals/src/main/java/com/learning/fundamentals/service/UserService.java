package com.learning.fundamentals.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.learning.fundamentals.exceptionhandling.UserNotFoundException;
import com.learning.fundamentals.model.User;
import com.learning.fundamentals.repository.Userrepository;

@Service
public class UserService {
	
	private final Userrepository repo;
	
	public UserService(Userrepository repo) {
		this.repo=repo;
	}
	
	//It saves the user to the database.
	public User saveUsers(User user) {
		return repo.save(user);
	}
	
	//It returns list of all users in the database.
	public List<User> getAllUser(){
		return repo.findAll();
	}
	
	//It returns a particular user by user id.
	public User getUserById(Long id) {
		return repo.findById(id).orElseThrow(()->new UserNotFoundException(id));
	}
	
	//This method updates a existing user with new values.
	public User updateUserById(Long id,User updatedUser) {
		User existingUser=repo.findById(id).orElseThrow(()->new UserNotFoundException(id));
		
		existingUser.setName(updatedUser.getName());
		existingUser.setAge(updatedUser.getAge());
		existingUser.setPhone(updatedUser.getPhone());
		
		return repo.save(existingUser);
	}

	
	//This method a delete a user in the database by id.
	public void deleteUserById(Long id) {
		if(!repo.existsById(id)) {
			throw new UserNotFoundException(id);
		}
		repo.deleteById(id);
		
	}

}
