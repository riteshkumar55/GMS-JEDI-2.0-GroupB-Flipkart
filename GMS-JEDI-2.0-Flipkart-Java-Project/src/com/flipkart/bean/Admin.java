/**
 * 
 */
package com.flipkart.bean;

/**
 * 
 */
public class Admin extends User{
	public Admin(String userId, String password, int roleId, String name) {
		super(userId, password, roleId, name);
		// TODO Auto-generated constructor stub
	}
	private String admName;
	private String address;
	public String getAdmName() {
		return admName;
	}
	public void setAdmName(String admName) {
		this.admName = admName;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
}
