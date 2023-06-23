/**
 * 
 */
package com.flipkart.constants;

/**
 * 
 */
public class SQLConstants {
	public static final String CREATE_USER_QUERY = "INSERT INTO User (username,password, role_id,name) VALUES(?,?,?,?)";
	public static final String CREATE_CUSTOMER_QUERY = "INSERT INTO Customer (customer_id, address, phone, gender) VALUES(?,?,?,?)";
	public static final String CREATE_CUSTOMER_REGISTRATION_QUERY = "INSERT INTO Customer_registration (username, password, role_id, name, address, phone, gender) VALUES (?,?,?,?,?,?,?)";
	public static final String CHECK_IS_SLOT_AVAILABLE = "SELECT * FROM Slot WHERE slot_id=? && available_seats>0";
	public static final String GET_ALL_SLOTS = "SELECT * FROM Slot WHERE gym_id = ? ";
	public static final String DECREMENT_SEATS = "UPDATE Slot set available_seats = Slot.available_seats-1 WHERE slot_id=?";
	public static final String GET_ALL_BOOKINGS = "SELECT * FROM Booking WHERE customer_id = ? ";
	public static final String CREATE_BOOKING = "INSERT INTO Booking (slot_id, customer_id,date) VALUES(?,?,(SELECT day FROM slot where slot_id=?))";
	public static final String GET_CLASHING_SLOTS = "SELECT * FROM Booking JOIN Slot ON Booking.slot_id = Slot.slot_id WHERE Booking.customer_id=? AND Booking.date = (SELECT date FROM Slot WHERE slot_id=?) AND Slot.slot_time = (SELECT slot_time FROM Slot WHERE slot_id=?)";
	public static final String CANCEL_BOOKING = "DELETE FROM Booking WHERE booking_id=?";
	public static final String SHOW_ALL_AVAILABLE_GYMS = "SELECT * FROM Gym WHERE is_approved=true";
}
