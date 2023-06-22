package com.flipkart.DAO;

import java.util.ArrayList;
import java.util.List;
import com.flipkart.bean.Slot;
import com.flipkart.utils.DBUtils;

import java.sql.*;

public class SlotGMSDAOImpl implements SlotGMSDao {

	@Override
	public List<Slot> getSlotsOfGym(int gymId) {
		// TODO Auto-generated method stub
		Connection conn = DBUtils.getConnection();
		String sql = "SELECT * FROM SLOT WHERE gym_id=?";
		List<Slot> slots = new ArrayList<Slot>();
		try {			
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setLong(1, gymId);
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {		
				Slot slot = new Slot(rs.getInt("slot_id"), rs.getInt("slot_time"), rs.getInt("available_seats"),rs.getInt("gym_id"),rs.getDate("day"));
				slots.add(slot);
			}
			return slots;
			
		}
		catch(SQLException se) {
			System.out.println("Error here");
			se.printStackTrace();
		}
		return null;
	}

}
