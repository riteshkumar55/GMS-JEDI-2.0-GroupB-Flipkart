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
	public boolean customrRegisteration();
	public void showAllGym(List<Gym> gymnasiums);
	public void showGymDetails(int gymNo);
	public void showAllBookings(String username);
	public boolean cancelBooking(String username , int bookingNo);
}
