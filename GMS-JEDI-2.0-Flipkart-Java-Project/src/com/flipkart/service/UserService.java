package com.flipkart.service;

public class UserService implements UserInterface{
	public boolean login(String username, String password){
		return true;
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
