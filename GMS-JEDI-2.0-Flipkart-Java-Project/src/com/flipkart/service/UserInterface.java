package com.flipkart.service;

public interface UserInterface {
	public boolean login(String username, String password);
	public boolean logout();
	public String checkRole(String username, String password);
	public boolean updatePassword(String username, String oldPassword, String newPassword);
}
