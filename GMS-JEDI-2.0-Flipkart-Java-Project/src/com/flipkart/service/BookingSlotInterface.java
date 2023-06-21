/**
 * 
 */
package com.flipkart.service;

/**
 * 
 */
public interface BookingSlotInterface {
	public boolean bookSlot(String username,int gymNo,int slotNo);
	public boolean cancelSlot();
}
