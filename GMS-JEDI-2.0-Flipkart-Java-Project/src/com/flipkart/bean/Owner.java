/**
 * 
 */
package com.flipkart.bean;

/**
 * 
 */
public class Owner extends User{
	public Owner(String userId, String password, String role) {
		super(userId, password, role);
		// TODO Auto-generated constructor stub
	}
	private String ownerName;
	private String address;
	private String allGym[];
	public String getOwnerName() {
		return ownerName;
	}
	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
}
