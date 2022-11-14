package com.example.MyWikiLoc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.example.MyWikiLoc.model.MyUserDetails;
import com.example.MyWikiLoc.model.User;
import com.example.MyWikiLoc.repository.UserRepository;

public class UserDetailsServiceImpl implements UserDetailsService {

	//Automatically generate implementation and inject an instant of 
	// userRepo in this class
	@Autowired
	private UserRepository userRepo;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userRepo.findByEmail(username);
		
		if(user == null) {
			throw new UsernameNotFoundException("Could not find user");
		}
		return new MyUserDetails(user);
	}

}
