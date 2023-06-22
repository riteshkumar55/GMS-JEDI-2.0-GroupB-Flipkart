package com.flipkart.service;

import java.util.ArrayList;
import java.util.List;

import com.flipkart.bean.Gym;
import com.flipkart.DAO.*;

public class CustomerService implements CustomerInterface{
	
	public List<Gym> showAllGym() {
		GymGMSDao GMSDao = new GymGMSDAOImpl();
		List<Gym> gymnasiums = GMSDao.getAllGyms();
		return gymnasiums;
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
	public boolean customerRegistration() {
		return true;
	}
	
}
