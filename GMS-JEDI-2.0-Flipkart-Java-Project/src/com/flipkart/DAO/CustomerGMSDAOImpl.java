/**
 * 
 */
package com.flipkart.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.flipkart.bean.Customer;
import com.flipkart.bean.User;
import com.flipkart.utils.JDBC;

/**
 * 
 */
public class CustomerGMSDAOImpl implements CustomerGMSDao {
	public void createCustomer(Customer customer) {
		Connection conn = JDBC.getConnection();
		String sql = "INSERT INTO Customer (UserId, Password, role, CusName, Address) Values(?,?,?,?,?);";
		try {			
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, customer.getUserId());
			stmt.setString(2, customer.getPassword());
			stmt.setString(3, customer.getRole());
			stmt.setString(4, customer.getCusName());
			stmt.setString(5, customer.getAddress());
			stmt.executeUpdate();
		}
		catch(SQLException se) {
			se.printStackTrace();
		}
	}

}
