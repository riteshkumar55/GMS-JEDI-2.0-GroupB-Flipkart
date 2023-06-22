/**
 * 
 */
package com.flipkart.bean;

/**
 * 
 */
public class User {
	private String username;
	private String password;
	private int roleId;
	private String name;
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getRoleId() {
		return roleId;
	}
	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public User(String username, String password, int roleId, String name) {
		super();
		this.username = username;
		this.password = password;
		this.roleId = roleId;
		this.name = name;
	}
	public User() {
		super();
	}
	
	
}
