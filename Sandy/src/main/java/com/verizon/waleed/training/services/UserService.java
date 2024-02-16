package com.verizon.waleed.training.services;

import java.util.ArrayList;
import java.util.Arrays;

import org.springframework.stereotype.Service;

import com.verizon.waleed.training.dto.User;

@Service
public class UserService {

	ArrayList<User> listOfUsers = new ArrayList<>(Arrays.asList(
			new User(1213, "Kotesh", "Chennai"),
			new User(22, "Sandhya", "Bombay"),
			new User(456, "Jalal", "Chennai"),
			new User(213, "Sai Kiran", "Chennai"),
			new User(972, "Meha", "Delhi")
			)); 
	

	public ArrayList<User> getAllUsers() {
		return listOfUsers;
	}
	
	
	public User getUserById(Integer userId) {
		User user = listOfUsers
				.stream()
				.filter(ref -> ref.userId().equals(userId))
				.findFirst()
				.get();
		return user;
	}
	
	public void addNewUser(User user) {
		listOfUsers.add(user);
	}
	
	public void updateUser(Integer userId, User user) {
		listOfUsers
		.set(listOfUsers.indexOf
				(listOfUsers
						.stream()
						.filter(ref -> ref.userId().equals(userId))
						.findFirst()
						.get()), user);
	}
	
	public void deleteUserById(Integer userId) {
		listOfUsers.remove(listOfUsers.stream().filter(ref -> ref.userId().equals(userId))
						.findFirst()
						.get());
	}
	
	
	
	
	
}
