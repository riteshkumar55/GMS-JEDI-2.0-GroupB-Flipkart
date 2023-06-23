/**
 * 
 */
package com.flipkart.service;

import java.util.List;

import com.flipkart.bean.*;

/**
 * 
 */
public interface SlotGMSInterface {
	public List<Slot> getSlotsOfGym(int gym_id);
	public boolean isSlotAvailable(int slot_id);

}
