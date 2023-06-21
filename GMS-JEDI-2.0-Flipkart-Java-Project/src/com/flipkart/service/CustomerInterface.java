/**
 * 
 */
package com.flipkart.service;

/**
 * 
 */
public interface CustomerInterface {
	public void showAllGym();
	public void showGymDetails(int gymNo);
	public void showAllBookings(String username);
	public boolean cancelBooking(String username , int bookingNo);
}
