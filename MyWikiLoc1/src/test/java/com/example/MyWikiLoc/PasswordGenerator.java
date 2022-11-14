package com.example.MyWikiLoc;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswordGenerator {

	public static void main(String[] args) {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		String pass = "password3";
		String encPass = encoder.encode(pass);
		System.out.print(encPass);

	}

}
