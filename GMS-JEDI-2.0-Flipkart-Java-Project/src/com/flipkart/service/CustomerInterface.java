/**
 * 
 */
package com.flipkart.service;

import java.util.List;

import com.flipkart.bean.Gym;

/**
 * 
 */
public interface CustomerInterface {
	public boolean customerRegistration();
	public List<Gym> showAllGym();
	public Gym showGymDetails(int gym_id);
	public void showAllBookings(String username);
	public boolean cancelBooking(String username , int bookingNo);
}
