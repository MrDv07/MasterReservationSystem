package com.axis.UserService.repository;

import com.axis.UserService.entity.User;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;



@Repository
public interface UserRepository extends MongoRepository<User, ObjectId> {

    @Query("{'username' : ?0}")
    User getUserByUserName(String username);
    
    @Query("{'role' : ?0}")
    User getUserByRole(String role);
	

}
