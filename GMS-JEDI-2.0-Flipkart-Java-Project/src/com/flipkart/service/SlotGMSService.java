/**
 * 
 */
package com.flipkart.service;

import java.util.ArrayList;
import java.util.List;

import com.flipkart.bean.Slot;
import com.flipkart.DAO.SlotGMSDao;
import com.flipkart.DAO.SlotGMSDAOImpl;
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

}
