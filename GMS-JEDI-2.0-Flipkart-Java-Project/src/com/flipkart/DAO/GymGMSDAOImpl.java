/**
 * 
 */
package com.flipkart.DAO;

import java.util.ArrayList;
import java.util.List;

import com.flipkart.bean.Gym;
import com.flipkart.utils.JDBC;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * 
 */
public class GymGMSDAOImpl implements GymGMSDao {

	@Override
	public List<Gym> getAllGyms() {
		Connection conn = JDBC.getConnection();
		try {
			String sql = "SELECT * FROM GYM";
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

	@Override
	public Gym getGymById(int gymId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateGym(Gym gym) {
		// TODO Auto-generated method stub

	}

}
