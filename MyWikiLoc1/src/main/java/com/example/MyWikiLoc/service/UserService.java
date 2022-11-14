package com.example.MyWikiLoc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.FindAndModifyOptions;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import com.example.MyWikiLoc.model.DbSequence;
import com.example.MyWikiLoc.model.User;
import com.example.MyWikiLoc.repository.UserRepository;



@Service
public class UserService {
	@Autowired	
	private UserRepository repo;
	
	@Autowired
	private MongoOperations userRepo;
	
	public List<User> listAll(){
		return repo.findAll();
	}
	
	public void saveUser(User user) {
		
		repo.save(user);
	}
	
	public User findUserByEmail(String email) {
		 return repo.findByEmail(email);
	}
	
	public void updateUser(User user) {
		Query query = new Query(Criteria.where("id").is(user.getId()));
		Update update = new Update();
		update.set("name",user.getName());
		update.set("lname",user.getLname());
		update.set("email",user.getEmail());
		update.set("role",user.getRole());
		
		
		// if upsert is true, if document not found it will create new
		// returnNew means it will rreturn the new created object
		User newUser = userRepo.findAndModify(query, update, FindAndModifyOptions.options().returnNew(true).upsert(false), User.class);
		
	}
	

}
