package com.flipkart.service;

import com.flipkart.DAO.*;
import com.flipkart.bean.Booking;

public class BookingSlotService implements BookingSlotInterface {
	public boolean bookSlot(String username, int slot_id) {
		SlotGMSDao slotDAO = new SlotGMSDAOImpl();
		BookingGMSDao bookingDAO = new BookingGMSDAOImpl();
		SlotGMSInterface slotSer = new SlotGMSService();
		if (slotSer.isSlotAvailable(slot_id)) {
			Booking previous_booking = getClashingBooking(username, slot_id);
			if (previous_booking != null) {
				return false;
			}
			boolean isBooked = bookingDAO.bookSlot(username, slot_id);
			if (isBooked) {
				slotDAO.decrementSeats(slot_id);
				return true;
			} else {
				return false;
			}
		}
		return false;
	}

	public Booking getClashingBooking(String username, int slot_id) {
		BookingGMSDao bookingDAO = new BookingGMSDAOImpl();
		return bookingDAO.getClashingBooking(username, slot_id);
	}

	@Override
	public boolean cancelSlot(int booking_id) {
		BookingGMSDao bookingDAO = new BookingGMSDAOImpl();
		return bookingDAO.cancelBooking(booking_id);
	}
}
