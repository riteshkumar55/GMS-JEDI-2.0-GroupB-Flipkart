/**
 * 
 */
package com.flipkart.service;

import java.util.ArrayList;
import java.util.List;

import com.flipkart.bean.Slot;
import com.flipkart.DAO.SlotGMSDao;
import com.flipkart.DAO.SlotGMSDAOImpl;
import java.time.LocalDate;
import java.sql.Date;
import com.flipkart.constants.FlipFitConstants;
/**
 * 
 */
public class SlotGMSService implements SlotGMSInterface {

	@Override
	public List<Slot> getSlotsOfGym(int gym_id) {
		// TODO Auto-generated method stub
		List<Slot> slots = new ArrayList<Slot>();
		SlotGMSDao slotDao = new SlotGMSDAOImpl();
		return slotDao.getSlotsOfGym(gym_id);
	}
	
	public boolean isSlotAvailable(int slot_id) {
		SlotGMSDao slotDAO = new SlotGMSDAOImpl();
		return slotDAO.isSlotAvailable(slot_id);
	}

	@Override
	public boolean createSlots(List<Slot> slots) {
		List<Slot> advanced_slots = new ArrayList<Slot>();
		for(Slot st:slots) {
			for(int i=0;i<FlipFitConstants.ADVANCED_SLOT_BOOKING;i++) {
				Slot new_slot = new Slot(st.getGymId(),st.getSlot_start_time(),st.getSlot_start_time(),st.getAvailSeats(),st.getGymId(),st.getDay());
				LocalDate dt = LocalDate.now().plusDays(i);
				new_slot.setDay(Date.valueOf(dt));
				advanced_slots.add(new_slot);
			}
		}
		SlotGMSDao slotDao = new SlotGMSDAOImpl();
		return slotDao.createSlot(advanced_slots);
	}

}
