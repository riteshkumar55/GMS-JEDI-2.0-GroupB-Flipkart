package com.flipkart.service;

import java.util.List;
import com.flipkart.DAO.*;

import com.flipkart.bean.*;

public class UserService implements UserInterface{
	public User login(String username, String password){
		UserGMSDao userDao = new UserGMSDAOImpl();
		User user = userDao.getUserById(username);
		if(user!=null) {
			if(user.getPassword().equals(password)) {
				return user;
			}
		}
		return null;
	}
	public void userRegistration(User newUser){
		UserGMSDao userDao = new UserGMSDAOImpl();
		userDao.createUser(newUser);
		return ;
	}
	public boolean logout() {
		return true;
	}
	public boolean updatePassword(String username, String oldPassword, String newPassword) {
		return true;
	}
}
