/**
 * 
 */
package com.flipkart.bean;

import java.util.List;

/**
 * 
 */
public class GymOwner extends User{
	public GymOwner(String userId, String password, String role) {
		// TODO Auto-generated constructor stub
	}
	public List<Gym> getAllGym() {
		return allGym;
	}
	public void setAllGym(List<Gym> allGym) {
		this.allGym = allGym;
	}
	private String ownerName;
	private String address;
	private List<Gym> allGym;
	private String AadharNo;

	public String getAadharNo() {
		return AadharNo;
	}
	public void setAadharNo(String aadharNo) {
		AadharNo = aadharNo;
	}
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
