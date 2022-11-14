package com.example.MyWikiLoc.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.MyWikiLoc.model.User;



public interface UserRepository extends MongoRepository<User, Integer> {
	
	public User findByEmail(String email);
}
