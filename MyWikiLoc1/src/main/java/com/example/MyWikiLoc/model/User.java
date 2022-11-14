package com.example.MyWikiLoc.model;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.index.IndexDirection;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Users")
public class User {
	
	@Transient
	// id of object for db_sequence collection
	public static final String SEQUENCE_NAME="user_sequence";
	
	@Id
	private Integer id;
	private String name;
	private String lname;
	@Indexed(unique = true)
	private String email;
	private String passwd;
	private Set<String> role = new HashSet<String>();
	
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	public User(Integer id, String name, String lname, String email, String passwd, Set roles) {
		super();
		this.id = id;
		this.name = name;
		this.lname = lname;
		this.email = email;
		this.passwd = passwd;
		this.role = roles;
	}

	
	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", lname=" + lname + ", email=" + email + ", passwd=" + passwd
				+ ", role=" + role + "]";
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPasswd() {
		return passwd;
	}

	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}
	
	public Set<String> getRole() {
		return role;
	}
	public void setRole(Set role) {
		this.role = role;
	}
	

}
