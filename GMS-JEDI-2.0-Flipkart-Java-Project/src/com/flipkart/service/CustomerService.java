package com.flipkart.service;

import java.util.ArrayList;
import java.util.List;

import com.flipkart.bean.Customer;
import com.flipkart.bean.Gym;
import com.flipkart.bean.User;
import com.flipkart.DAO.*;

public class CustomerService implements CustomerInterface{
	
	public List<Gym> showAllGym() {
		GymGMSDao GMSDao = new GymGMSDAOImpl();
		List<Gym> gymnasiums = GMSDao.getAllGyms();
		return gymnasiums;
	}
	public Gym showGymDetails(int gymNo) {

		GymGMSDao GMSDao = new GymGMSDAOImpl();
		Gym gym = GMSDao.getGymById(gymNo);
		return gym;
	}
	public void showAllBookings(String username) {
		
	}
	public boolean cancelBooking(String username , int bookingNo) {
		return true;
	}
	public boolean customerRegistration(Customer newCustomer) {
		CustomerGMSDao custDao = new CustomerGMSDAOImpl();
		custDao.createCustomer(newCustomer);
		
		return true;
	}
	
}
