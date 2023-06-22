/**
 * 
 */
package com.flipkart.DAO;

import java.util.List;

import com.flipkart.bean.Booking;

/**
 * 
 */
public interface BookingGMSDao {
	public List<Booking> getAllBookings(String custId);
}
