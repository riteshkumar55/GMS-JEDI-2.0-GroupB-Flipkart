/**
 * 
 */
package com.flipkart.bean;

/**
 * 
 */
public class Customer extends User {
	private String customerName;
	private String customerAddress;
	private String customerEmail;
	private String customerDOB;
	private String customerMobile;

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String name) {
		this.customerName = name;
	}

	public String getCustomerAddress() {
		return customerAddress;
	}

	public void setCustomerAddress(String address) {
		this.customerAddress = address;
	}

	public String getCustomerEmail() {
		return customerEmail;
	}

	public void setCustomerEmail(String customerEmail) {
		this.customerEmail = customerEmail;
	}

	public String getCustomerDOB() {
		return customerDOB;
	}

	public void setCustomerDOB(String customerDOB) {
		this.customerDOB = customerDOB;
	}

	public String getCustomerMobile() {
		return customerMobile;
	}

	public void setCustomerMobile(String customerMobile) {
		this.customerMobile = customerMobile;
	}

}
