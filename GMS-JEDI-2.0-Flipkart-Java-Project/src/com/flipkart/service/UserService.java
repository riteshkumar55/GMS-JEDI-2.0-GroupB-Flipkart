package com.flipkart.service;

import java.util.List;

import com.flipkart.bean.*;

public class UserService implements UserInterface{
	public boolean login(String username, String password, List<User> userList){
		for(User cust : userList) {
			if(cust.getUserId().equals(username) && cust.getPassword().equals(password)) {
				return true;
			}
			if(cust.getUserId().equals(username)) {
				System.out.println("Incorrect Password \n");
				return false;
			}
		}
		return false;
	}
	public boolean logout() {
		return true;
	}
	public String checkRole(String username, String password) {
		return "customer";
	}
	public boolean updatePassword(String username, String oldPassword, String newPassword) {
		return true;
	}
}
