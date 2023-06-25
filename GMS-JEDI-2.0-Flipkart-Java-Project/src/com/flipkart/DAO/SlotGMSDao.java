package com.flipkart.DAO;
import java.util.List;
import com.flipkart.bean.Slot;

public interface SlotGMSDao {
	public List<Slot> getSlotsOfGym(int gym_id);
	public boolean isSlotAvailable(int slot_id);
	public boolean decrementSeats(int slot_id);
	public boolean createSlot(List<Slot> slots);
}
