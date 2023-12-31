/**
 * 
 */
package com.flipkart.service;

import java.util.List;

import com.flipkart.bean.Booking;
import com.flipkart.bean.Customer;
import com.flipkart.bean.Gym;

/** Interface for CustomerService
 * 
 */
public interface CustomerInterface {
	public boolean customerRegistration(Customer newCustomer);
	public List<Gym> showAllAvailableGym();
	public Gym showGymDetails(int gym_id);
	public List<Booking> showAllBookings(String username);
	public boolean cancelBooking(int booking_id);
}
