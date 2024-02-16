package com.verizon.waleed.training.controllers;

import java.util.ArrayList;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.verizon.waleed.training.dto.User;
import com.verizon.waleed.training.services.UserService;

@RestController
@RequestMapping("api")
public class UserController {

	@Autowired
	UserService service;
	
	
	@GetMapping("/users")
	ArrayList<User> getAllUsers() {
		return service.getAllUsers();
	}
	
	
	@GetMapping("/users/{userId}")
	User getUserById(@PathVariable Integer userId) {
		return service.getUserById(userId);
	}
	
//	@RequestMapping(method = RequestMethod.POST, value =  "/users")
	
	@PostMapping("/users")
	void addNewUser(@RequestBody User user) {
		service.addNewUser(user);
	}
	
	@PutMapping("/users/{userId}")
	public void updateUser(@PathVariable Integer userId,@RequestBody User user) {
		service.updateUser(userId, user);
	}
	
	@DeleteMapping("/users/{userId}")
	public void deleteUserById(@PathVariable Integer userId) {
		service.deleteUserById(userId);
	}
	
	
	
	
}
