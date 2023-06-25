package com.flipkart.service;


import java.util.List;

import com.flipkart.bean.*;
import com.flipkart.exceptions.AccountNotApprovedException;
import com.flipkart.exceptions.InvalidLoginCredentialsException;

public interface UserInterface {
	public User login(String username, String password) throws InvalidLoginCredentialsException, AccountNotApprovedException;
	public boolean logout();
	public boolean updatePassword(String username, String oldPassword, String newPassword);
	public void userRegistration(User newUser);
}
