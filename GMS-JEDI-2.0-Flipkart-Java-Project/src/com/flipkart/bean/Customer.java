/**
 * 
 */
package com.flipkart.bean;

/**
 * 
 */
public class Customer extends User{
	public Customer(String userId, String password, int roleId, String name) {
		super(userId, password, roleId, name);
	
	}
	private String cusName;
	private String address;
	public String getCusName() {
		return cusName;
	}
	public void setCusName(String cusName) {
		this.cusName = cusName;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
}
