package com.axis.Repository;



import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.axis.Entity.Booking;

public interface BookingRepository extends MongoRepository<Booking, ObjectId> {
	
	

}
