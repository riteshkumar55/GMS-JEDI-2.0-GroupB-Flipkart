package com.flipkart.service;

import java.util.List;

import com.flipkart.bean.Gym;

public class CustomerService implements CustomerInterface{
	
	public void showAllGym(List<Gym> gymnasiums) {
		System.out.println("Name Address Total Slots Number of Machines");
		for(Gym gym: gymnasiums) {
			System.out.printf("%-5s\t", gym.getGymName());
			System.out.printf("%-10s\t", gym.getAddress());
			System.out.printf("%-3d\t", gym.getTotSlots());
			System.out.printf("%-3d\n", gym.getNumberOfMachines());
		}
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
