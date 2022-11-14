package com.example.MyWikiLoc.controller;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.MyWikiLoc.model.User;
import com.example.MyWikiLoc.service.SequenceGeneratorService;
import com.example.MyWikiLoc.service.UserService;

@Controller
public class MainController {
	@Autowired
	private UserService service;
	@Autowired
	private SequenceGeneratorService seqService;
	

	@RequestMapping("/")
	public String home() {
		System.out.println("Going home.....");
		return "index";
	}
	
	@RequestMapping("/newUser")
	public String newUser() {
		System.out.println("Going newUser.....");
		return "newUser";
	}
		
	@GetMapping("/showAll")
	public String viewAllUsers(Model model) {
		List<User> listUsers = service.listAll();
		model.addAttribute("listUsers", listUsers);
		System.out.print("Get all users /");
		return "viewAllUsers";
	}
	
	 @RequestMapping(value = "/edit", method = RequestMethod.GET)
	public String showUserEditForum(@RequestParam String email, Model model) {
		User user = service.findUserByEmail(email);
		model.addAttribute("user",user);
		
		return "editUserForm";
	}
	 
	 @PostMapping("/save")
	 public String submitForm(@ModelAttribute("user") User user) {
	      
	     System.out.println(user);
	      
	     return "updateCompleted";
	 }
	 
	 	
	
	
	//@PostMapping
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String saveUser(@ModelAttribute("user") User user) {
		
		user.setId(seqService.getSequenceNumber(User.SEQUENCE_NAME));
		
		 
		//BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		//String encodedPassword = encoder.encode(user.getPasswd());
	//	user.setPasswd(encodedPassword);
		//user.setRole("User");
		
		// Create Roles Set
		Set<String> roles = new HashSet<String>();
		roles.add("User");
		
		// Add roles to user
		user.setRole(roles);
		
		service.saveUser(user);
		System.out.print("Save User /");
		return "viewAllUsers";
	}
	
	
}
