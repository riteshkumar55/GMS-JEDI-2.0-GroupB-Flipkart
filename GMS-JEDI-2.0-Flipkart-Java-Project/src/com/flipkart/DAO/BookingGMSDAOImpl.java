
package com.flipkart.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.flipkart.bean.Booking;
import com.flipkart.bean.Gym;
import com.flipkart.utils.DBUtil;

public class BookingGMSDAOImpl implements BookingGMSDao {
	public List<Booking> getAllBookings(String custId) {
		Connection conn = DBUtil.getConnection();
		try {
			String sql = "SELECT * FROM Booking WHERE customer_id = ? ";
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, custId);
			ResultSet rs = stmt.executeQuery();
			List<Booking> bookings = new ArrayList<Booking>();
			while (rs.next()) {
				Booking booking = new Booking(rs.getInt("booking_id"), rs.getInt("slot_id"),rs.getString("customer_id"),rs.getDate("date"));
				bookings.add(booking);

			}
			return bookings;
		} catch (SQLException se) {
			se.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean bookSlot(String customer_id, String slot_id) {
		Connection conn = DBUtil.getConnection();
		try {
			String sql = "INSERT INTO Booking (booking_id, slot_id, customer_id,date) VALUES()";
		}
		catch(SQLException se) {
			se.printStackTrace();
		}
		return false;
	}


}
