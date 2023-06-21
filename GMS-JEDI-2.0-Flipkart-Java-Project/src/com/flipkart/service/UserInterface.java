package com.flipkart.service;

import java.util.List;

import com.flipkart.bean.*;

public interface UserInterface {
	public boolean login(String username, String password, List<User> userList);
	public boolean logout();
	public String checkRole(String username, String password);
	public boolean updatePassword(String username, String oldPassword, String newPassword);
}
