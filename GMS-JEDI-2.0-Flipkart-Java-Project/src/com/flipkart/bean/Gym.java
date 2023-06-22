package com.flipkart.bean;

public class Gym {
	private int gymId;
	private String gymName;
	private String gstNo;
	private String address;
	private int totSlots;
	private int numberOfMachines;
	private Slot slots[];
	private int seats;
	private String gymOwnerId;
	
	public Gym(int gymId, String gymName, String gstNo, String address, int totSlots,int numberOfMachines, int seats, String gymOwnerId) {
		this.gymId = gymId;
		this.gymName = gymName;
		this.gstNo = gstNo;
		this.address = address;
		this.totSlots = totSlots;
		this.numberOfMachines = numberOfMachines;
		this.seats = seats;
		this.gymOwnerId = gymOwnerId;
	}
	public Gym() {
		// TODO Auto-generated constructor stub
	}

	public String getGstNo() {
		return gstNo;
	}
	public void setGstNo(String gstNo) {
		this.gstNo = gstNo;
	}
	public Slot[] getSlots() {
		return slots;
	}
	public void setSlots(Slot[] slots) {
		this.slots = slots;
	}
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
	public int getNumberOfMachines() {
		return numberOfMachines;
	}
	public void setNumberOfMachines(int numberOfMachines) {
		this.numberOfMachines = numberOfMachines;
	}
	public String getGymOwnerId() {
		return gymOwnerId;
	}
	public void setGymOwnerId(String gymOwnerId) {
		this.gymOwnerId = gymOwnerId;
	}
	
	
}
