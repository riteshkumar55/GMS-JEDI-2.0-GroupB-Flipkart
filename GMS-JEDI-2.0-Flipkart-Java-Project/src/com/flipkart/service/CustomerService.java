package com.flipkart.service;

public class CustomerService implements CustomerInterface{
	
	public void showAllGym() {
		System.out.println("Gym1");
		System.out.println("Gym2");
		System.out.println("Gym3");
		System.out.println("Gym4");
		System.out.println("Gym5");
		System.out.println("Gym6");
		
	}
	public void showGymDetails(int gymNo) {
		System.out.println("Gym" + gymNo);
		System.out.println("xyz");
		System.out.println("Slot1");
		System.out.println("Slot2");
		System.out.println("Slot3");
		System.out.println("Slot4");
		System.out.println("Slot5");
		System.out.println("Slot6");
	}
	public void showAllBookings(String username) {
		System.out.println("Booking1");
		System.out.println("Booking2");
		System.out.println("Booking3");
		System.out.println("Booking4");
		System.out.println("Booking5");
		System.out.println("Booking6");
	}
	public boolean cancelBooking(String username , int bookingNo) {
		return true;
	}
	
}
