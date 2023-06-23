/**
 * 
 */
package com.flipkart.service;

import com.flipkart.bean.Booking;

/**
 * 
 */
public interface BookingSlotInterface {
	public boolean bookSlot(String username,int slot_id);
	public boolean cancelSlot(int booking_id);
	public Booking getClashingBooking(String username, int slot_id);
}
