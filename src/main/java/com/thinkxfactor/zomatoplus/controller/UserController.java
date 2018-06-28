package com.thinkxfactor.zomatoplus.controller;


import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.thinkxfactor.zomatoplus.models.*;
import com.thinkxfactor.zomatoplus.repository.UserRepository;


@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserRepository userRepository;
	
	@PostMapping("/login")
	public Object userLogin(@RequestParam("username") String username, @RequestParam("password") String password) {
		User usr = userRepository.findByUsernameAndPassword(username, password);
		if(usr==null)
			return "Login failed";
		else
			return "Login Success";
	}
	
	@PostMapping("/create")
	public User userCreate(@RequestBody User user) {
		User usr = userRepository.save(user);
		return usr;
	}
	
	@GetMapping("/all")
	public List<User> userList() {
		List<User> users = userRepository.findAll();
		return users;
	}
	
}
