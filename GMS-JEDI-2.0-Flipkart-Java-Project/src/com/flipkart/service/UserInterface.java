package com.flipkart.service;


import java.util.List;

import com.flipkart.bean.*;

public interface UserInterface {
	public User login(String username, String password);
	public boolean logout();
	public boolean updatePassword(String username, String oldPassword, String newPassword);
	public void userRegistration(User newUser);
}
