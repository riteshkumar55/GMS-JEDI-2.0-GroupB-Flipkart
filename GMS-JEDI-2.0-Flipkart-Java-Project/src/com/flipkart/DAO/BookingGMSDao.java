/**
 * 
 */
package com.flipkart.DAO;

import java.sql.SQLException;
import java.util.List;

import com.flipkart.bean.Booking;

/**
 * 
 */
public interface BookingGMSDao {
	public List<Booking> getAllBookings(String custId);
	public Booking getClashingBooking(String customer_id, int slot_id);
	public boolean bookSlot(String customer_id, int slot_id);
	public boolean cancelBooking(int booking_id);
}
