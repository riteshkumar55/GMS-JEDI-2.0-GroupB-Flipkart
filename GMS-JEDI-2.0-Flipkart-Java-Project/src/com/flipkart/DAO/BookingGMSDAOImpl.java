
package com.flipkart.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.flipkart.bean.Booking;
import com.flipkart.bean.Gym;
import com.flipkart.utils.DBUtils;
import com.flipkart.constants.SQLConstants;

public class BookingGMSDAOImpl implements BookingGMSDao {
	public List<Booking> getAllBookings(String custId) {
		Connection conn = DBUtils.getConnection();
		try {
			String sql = SQLConstants.GET_ALL_BOOKINGS;
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
	public boolean bookSlot(String customer_id, int slot_id) {
		Connection conn = DBUtils.getConnection();
		try {
			PreparedStatement stmt = conn.prepareStatement(SQLConstants.CREATE_BOOKING);
			stmt.setString(1, customer_id);
			stmt.setInt(2, slot_id);
			int rows = stmt.executeUpdate();
			return rows==1;
		}
		catch(SQLException se) {
			se.printStackTrace();
		}
		return false;
	}


}
