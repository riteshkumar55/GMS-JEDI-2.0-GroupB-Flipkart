package com.flipkart.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.flipkart.bean.Gym;
import com.flipkart.bean.GymOwner;
import com.flipkart.utils.JDBC;

public class GymOwnerGMSDAOImpl implements GymOwnerGMSDao {
	public void createGymOwner(GymOwner newGymOwner) {
		Connection conn = JDBC.getConnection();
		String sql = "INSERT INTO Gym_owner (gym_owner_id, address, aadhaar, pan) Values (?,?,?,?);";
		try {			
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, newGymOwner.getUsername());
			stmt.setString(2, newGymOwner.getAddress());
			stmt.setString(3, newGymOwner.getAadharNo());
			stmt.setString(4, newGymOwner.getPanCard());
			stmt.executeUpdate();
		}
		catch(SQLException se) {
			se.printStackTrace();
		}
		return ;
	}

}
