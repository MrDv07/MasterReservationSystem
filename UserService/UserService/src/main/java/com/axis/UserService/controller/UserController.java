package com.axis.UserService.controller;

import com.axis.UserService.entity.User;
import com.axis.UserService.service.UserService;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api/v1/user")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	
	@PostMapping
	public ResponseEntity<User> addUser(@RequestBody User user){
		return new ResponseEntity<User>(userService.addUser(user), HttpStatus.OK);
	}
	
	@GetMapping("/findall")
	public ResponseEntity<List<User>> getAllUser(){
		return new ResponseEntity<List<User>>(userService.getAllUsers(), HttpStatus.FOUND);
	}

	@GetMapping("/findbyid/{id}")
	public ResponseEntity<User> findUserById(@PathVariable ObjectId id){
		return new ResponseEntity<User>(userService.getUserByID(id), HttpStatus.FOUND);
	}

	@GetMapping("/findbyusername")
	public ResponseEntity<User> findUserByUserName(@RequestBody User user ){
		return new ResponseEntity<User>(userService.getUserByUserName(user.getUsername()), HttpStatus.FOUND);
	}

	@PutMapping("/updatebyid")
	public ResponseEntity<User> updateUserById(@RequestBody ObjectId id , User user){
		return new ResponseEntity<User>(userService.updateUserById(id, user), HttpStatus.CREATED);
	} 
	
	@DeleteMapping("/deleteuser")
	public ResponseEntity<String> deleteUser(@PathVariable ObjectId id){
		return new ResponseEntity<String>(userService.deleteUserById(id), HttpStatus.FOUND);
	}
	

}
