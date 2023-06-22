package com.flipkart.service;

import com.flipkart.DAO.*;
public class BookingSlotService implements BookingSlotInterface{
	public boolean bookSlot(String username, int slot_id) {
		SlotGMSDao slotDAO = new SlotGMSDAOImpl();
		BookingGMSDao bookingDAO = new BookingGMSDAOImpl();
		if(slotDAO.isSlotAvailable(slot_id)) {
			boolean isBooked = bookingDAO.bookSlot(username, slot_id);
			if(isBooked) {
				slotDAO.decrementSeats(slot_id);
				return true;
			}
			else {
				return false;
			}
		}
		System.out.println("Here");
		return false;
	}
	public boolean cancelSlot() {
		return true;
	}
}
