package com.axis.UserService.service;

import java.util.List;
import java.util.Optional;

import com.axis.UserService.entity.User;
import org.bson.types.ObjectId;



public interface UserService {
	
	User addUser(User user);

	User getUserByUserName(String username);

	User getUserByID(ObjectId id);

	User updateUserById(ObjectId id, User user);

	String deleteUserById(ObjectId id);

}
