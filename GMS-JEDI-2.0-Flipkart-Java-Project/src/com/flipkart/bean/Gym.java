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
	private int number_of_instructors;
	private boolean is_cardio_available;
	private boolean is_crossfit_available;
	private int floor_area;
	private boolean is_approved;
	
	
	public int getNumber_of_instructors() {
		return number_of_instructors;
	}

	public void setNumber_of_instructors(int number_of_instructors) {
		this.number_of_instructors = number_of_instructors;
	}

	public boolean isIs_cardio_available() {
		return is_cardio_available;
	}

	public void setIs_cardio_available(boolean is_cardio_available) {
		this.is_cardio_available = is_cardio_available;
	}

	public boolean isIs_crossfit_available() {
		return is_crossfit_available;
	}

	public void setIs_crossfit_available(boolean is_crossfit_available) {
		this.is_crossfit_available = is_crossfit_available;
	}

	public int getFloor_area() {
		return floor_area;
	}

	public void setFloor_area(int floor_area) {
		this.floor_area = floor_area;
	}

	public boolean isIs_approved() {
		return is_approved;
	}

	public void setIs_approved(boolean is_approved) {
		this.is_approved = is_approved;
	}

	public Gym(int gymId, String gymName, String gstNo, String address, int totSlots, int numberOfMachines,
			Slot[] slots, int seats, String gymOwnerId, int number_of_instructors, boolean is_cardio_available,
			boolean is_crossfit_available, int floor_area, boolean is_approved) {
		super();
		this.gymId = gymId;
		this.gymName = gymName;
		this.gstNo = gstNo;
		this.address = address;
		this.totSlots = totSlots;
		this.numberOfMachines = numberOfMachines;
		this.slots = slots;
		this.seats = seats;
		this.gymOwnerId = gymOwnerId;
		this.number_of_instructors = number_of_instructors;
		this.is_cardio_available = is_cardio_available;
		this.is_crossfit_available = is_crossfit_available;
		this.floor_area = floor_area;
		this.is_approved = is_approved;
	}

	public Gym(int gymId, String gymName, String gstNo, String address, int totSlots, int numberOfMachines, int seats, String gymOwnerId) {
		super();
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
