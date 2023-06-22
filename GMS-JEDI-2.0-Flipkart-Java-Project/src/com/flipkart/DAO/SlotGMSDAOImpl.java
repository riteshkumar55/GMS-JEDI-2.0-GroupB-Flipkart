package com.flipkart.DAO;

import java.util.ArrayList;
import java.util.List;
import com.flipkart.bean.Slot;
import com.flipkart.utils.DBUtils;
import com.flipkart.constants.SQLConstants;
import java.sql.*;

public class SlotGMSDAOImpl implements SlotGMSDao {

	@Override
	public List<Slot> getSlotsOfGym(int gymId) {
		// TODO Auto-generated method stub
		Connection conn = DBUtils.getConnection();
		String sql = SQLConstants.GET_ALL_SLOTS;
		List<Slot> slots = new ArrayList<Slot>();
		try {			
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setInt(1, gymId);
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {		
				Slot slot = new Slot(rs.getInt("slot_id"), rs.getInt("slot_time"), rs.getInt("available_seats"),rs.getInt("gym_id"),rs.getDate("day"));
				slots.add(slot);
			}
			return slots;
			
		}
		catch(SQLException se) {
			System.out.println("Good debug");
			se.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean isSlotAvailable(int slot_id) {
		Connection conn = DBUtils.getConnection();
		try {
			PreparedStatement stmt = conn.prepareStatement(SQLConstants.CHECK_IS_SLOT_AVAILABLE);
			stmt.setInt(1, slot_id);
			ResultSet rs = stmt.executeQuery();
			return rs.next();
		}
		catch(SQLException se) {
			se.printStackTrace();
		}
		return false;
	}

	@Override
	public void decrementSeats(int slot_id) {
		// TODO Auto-generated method stub
		Connection conn = DBUtils.getConnection();
		try {
			PreparedStatement stmt = conn.prepareStatement(SQLConstants.DECREMENT_SEATS);
			stmt.setInt(1, slot_id);
			stmt.executeUpdate();
		}
		catch(SQLException se) {
			se.printStackTrace();
		}
		
	}
	

}
