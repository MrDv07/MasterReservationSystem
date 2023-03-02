package com.axis.Repository;



import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.axis.Entity.Booking;

public interface BookingRepository extends MongoRepository<Booking, ObjectId> {
	
	@Query("{'username' : ?0}")
    List<Booking> getBookingByUserName(String username);

}
