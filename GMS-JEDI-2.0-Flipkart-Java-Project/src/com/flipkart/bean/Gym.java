package com.flipkart.bean;

public class Gym {
	private int gymId;
	private String gymName;
	private String gstNo;
	private String address;
	private int totSlots;
	private int seats;
	public int getGymId() {
		return gymId;
	}
	public void setGymId(int gymId) {
		this.gymId = gymId;
	}
	public String getGymName() {
		return gymName;
	}
	public void setGymName(String gymName) {
		this.gymName = gymName;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public int getTotSlots() {
		return totSlots;
	}
	public void setTotSlots(int totSlots) {
		this.totSlots = totSlots;
	}
	public int getSeats() {
		return seats;
	}
	public void setSeats(int seats) {
		this.seats = seats;
	}
	public String getGstNo() {
		return gstNo;
	}
	public void setGstNo(String gstNo) {
		this.gstNo = gstNo;
	}
	
}
