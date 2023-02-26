package com.axis.UserService.entity;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;


@Document(collection = "user")
public class User {

	@Id
	private ObjectId id ;
	private String name;
	private int age ;
	private String username;
	private String password;
	private String phoneNumber;
	private String gender;
	private String emailId;

	@Transient
	private List<transactionHistory> transactionHistories;
	
	
	

	public User() {
		super();
	}
	
	

	public User(ObjectId id, String name, int age, String username, String password, String phoneNumber, String gender,
			String emailId, List<transactionHistory> transactionHistories) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.username = username;
		this.password = password;
		this.phoneNumber = phoneNumber;
		this.gender = gender;
		this.emailId = emailId;
		this.transactionHistories = transactionHistories;
	}



	public ObjectId getId() {
		return id;
	}

	public void setId(ObjectId id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public List<transactionHistory> getTransactionHistories() {
		return transactionHistories;
	}

	public void setTransactionHistories(List<transactionHistory> transactionHistories) {
		this.transactionHistories = transactionHistories;
	}
	
	
	

}
