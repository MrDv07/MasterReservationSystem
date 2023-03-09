package com.axis.UserService.service;

import java.util.List;
import java.util.Optional;

import com.axis.UserService.entity.User;
import com.axis.UserService.exception.IdNotValidException;
import com.axis.UserService.exception.InvalidCharacterException;
import com.axis.UserService.exception.InvalidPhoneNumberException;
import com.axis.UserService.exception.ZeroException;
import com.axis.UserService.repository.UserRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;




@Service
public class UserServiceIMPL implements UserService {
	
	@Autowired
	UserRepository userRepository;

	@Override
	public User addUser(User user) {
		
		if(user.getName().isBlank() || user.getEmailId().isBlank() || user.getGender().isBlank() || user.getPassword().isBlank() || user.getUsername().isBlank()) {
			throw new InvalidCharacterException("Name, Email , Gender , Username, Password cannot be empty or cannot contain space. Give Valid Input.");
		}
		else if (user.getAge() ==0 || user.getPhoneNumber().isBlank()) {
			throw new ZeroException("Age or PhoneNumber cannot be 0");
		}
		else if (user.getPhoneNumber().length() < 10) {
			throw new InvalidPhoneNumberException("Phone Number cannot be less than 10");
		
		}
		
		return userRepository.save(user);
	}

	@Override
	public User getUserByUserName(String username) {
		return userRepository.getUserByUserName(username);
	}

	@Override
	public User getUserByID(ObjectId id) {
		
		Optional<User> us = userRepository.findById(id);
		
		if(us.isPresent()) {
			return us.get();
		}
		else {
			throw new IdNotValidException("There is no user with this Id");
		}
	}
	
	
	@Override
	public User updateUserById(ObjectId id, User user) {
		
	Optional<User> emp = userRepository.findById(id);
	if(emp.isPresent()) {
		user.setId(emp.get().getId());
		return userRepository.save(user);
	}
	else {
		throw new IdNotValidException("No id present to Update");
	   }
	}

	@Override
	public String deleteUserById(ObjectId id) {
		
	Optional<User>emp = userRepository.findById(id);
	if(emp.isPresent()){
		userRepository.deleteById(id);
		return "User Deleted";
	}
	else
		throw new IdNotValidException("No id present to Delete");
	}

	@Override
	public List<User> getAllUsers() {
		return userRepository.findAll();
	}

}
