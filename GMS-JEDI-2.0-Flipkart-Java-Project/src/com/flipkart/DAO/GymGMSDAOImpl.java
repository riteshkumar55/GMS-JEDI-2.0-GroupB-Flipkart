package com.flipkart.DAO;

import java.util.ArrayList;
import java.util.List;

import com.flipkart.bean.Gym;
import com.flipkart.bean.User;
import com.flipkart.constants.SQLConstants;
import com.flipkart.utils.DBUtils;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class GymGMSDAOImpl implements GymGMSDao {

	@Override
	public List<Gym> getAllAvailableGyms() {
		Connection conn = DBUtils.getConnection();
		try {
			String sql = SQLConstants.SHOW_ALL_AVAILABLE_GYMS;
			PreparedStatement stmt = conn.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			List<Gym> gymnasiums = new ArrayList<Gym>();
			while (rs.next()) {
				Gym gym = new Gym(rs.getInt("gym_id"), rs.getString("gym_name"), rs.getString("gst_number"),
						rs.getString("address"), rs.getInt("tot_slots"), rs.getInt("number_of_machines"),
						rs.getInt("seats"), rs.getString("gym_owner_id"));
				gymnasiums.add(gym);

			}
			return gymnasiums;
		} catch (SQLException se) {
			se.printStackTrace();
		}
		return null;
	}

	
	public List<Gym> getAllMyGyms(String username) {
		Connection conn = DBUtils.getConnection();
		try {
			String sql = "SELECT * FROM GYM WHERE gym_owner_id = ?";
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, username);
			ResultSet rs = stmt.executeQuery();
			List<Gym> gymnasiums = new ArrayList<Gym>();
			while (rs.next()) {
				Gym gym = new Gym(rs.getInt("gym_id"), rs.getString("gym_name"), rs.getString("gst_number"),
						rs.getString("address"), rs.getInt("tot_slots"), rs.getInt("number_of_machines"),
						rs.getInt("seats"), rs.getString("gym_owner_id"));
				gymnasiums.add(gym);
			}
			return gymnasiums;
		} catch (SQLException se) {
			se.printStackTrace();
		}
		return null;
	}	
	
	@Override
	public Gym getGymById(int gymId) {
		Connection conn = DBUtils.getConnection();
		String sql = "SELECT * FROM Gym WHERE gymId=? LIMIT 1";
		try {			
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setLong(1, gymId);
			ResultSet rs = stmt.executeQuery();
			if(rs.next()) {				
				return new Gym(rs.getInt("gym_id"),
							   rs.getString("gym_name"),
							   rs.getString("gst_no"),
							   rs.getString("address"),
							   rs.getInt("tot_slots"),
							   rs.getInt("number_of_machines"),
							   rs.getInt("seats"),
							   rs.getString("gym_owner_id"));
			}
			else {
				return null;
			}
			
		}
		catch(SQLException se) {
			System.out.println("Error here");
			se.printStackTrace();
		}
		return null;
	}

	@Override
	public void updateGym(Gym gym) {
		// deepak karega
	}
	
	public String removeGym(int gymId) {
		Connection conn = DBUtils.getConnection();
		//edit kardena isme sql deepak drop karna hai gym 
		String sql = "";
		try {			
			PreparedStatement stmt = conn.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			return "Gym removed";
		}
		catch(SQLException se) {
			System.out.println("Error here");
			se.printStackTrace();
			return "Removal unsuccessful";
		}
	}
	//Add more field number of instructor is missing ******
	public void createGym(Gym gym) {
		Connection conn = DBUtils.getConnection();
		String sql = "INSERT INTO Gym (gym_id, gym_name, gst_number, address, tot_slots, number_of_machines, seats, gym_owner_id,"
				+ "number_of_instructors, is_cardio_available, is_crossfit_available, floor_area) Values(?,?,?,?,?,?,?,?,?,?,?,?);";
		try {			
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setInt(1, gym.getGymId());
			stmt.setString(2, gym.getGymName());
			stmt.setString(3, gym.getGstNo());
			stmt.setString(4, gym.getAddress());
			stmt.setInt(5, gym.getTotSlots());
			stmt.setInt(6, gym.getNumberOfMachines());
			stmt.setInt(7, gym.getSeats());
			stmt.setString(8, gym.getGymOwnerId());
			stmt.setInt(9, gym.getNumber_of_instructors());
			stmt.setBoolean(10, gym.isIs_cardio_available());
			stmt.setBoolean(11, gym.isIs_crossfit_available());
			stmt.setInt(12, gym.getFloor_area());
			stmt.executeUpdate();
		}
		catch(SQLException se) {
			se.printStackTrace();
		}
	}
}