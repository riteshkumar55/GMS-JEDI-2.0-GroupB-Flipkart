/**
 * 
 */
package com.flipkart.service;

/**
 * 
 */
public interface BookingSlotInterface {
	public boolean bookSlot(String username,int slot_id);
	public boolean cancelSlot();
}
