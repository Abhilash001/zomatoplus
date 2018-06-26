package com.thinkxfactor.zomatoplus.controller;


import java.util.*;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.thinkxfactor.zomatoplus.models.*;

class FieldEmptyException extends Exception
{
    public FieldEmptyException(String s)
    {
        super(s);
    }
}

@RestController
@RequestMapping("/user")
public class UserController {
	
	List<User> users = new ArrayList<>();

	@PostMapping("/login")
	public Object userLogin(@RequestParam("username") String username, @RequestParam("password") String password) {
		User usr = new User();
		try {
		if(username.length()==0||password.length()==0) throw new FieldEmptyException("username or password field empty");
		}catch (FieldEmptyException e)
		{
			return (e.getMessage());
		}
		usr.setUsername(username);
		usr.setPassword(password);
		return usr;
	}
	
	@GetMapping("/all")
	public List<User> userList() {
		return users;
	}
	
	@PostMapping("/create")
	public User userCreate(@RequestBody User user) {
		System.out.println(user.toString());
		users.add(user);
		return user;
	}
	
	

}
