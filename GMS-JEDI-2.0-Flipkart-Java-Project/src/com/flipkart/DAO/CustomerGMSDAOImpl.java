/**
 * 
 */
package com.flipkart.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.flipkart.bean.Customer;
import com.flipkart.utils.DBUtils;

/**
 * 
 */
public class CustomerGMSDAOImpl implements CustomerGMSDao {
	public void createCustomer(Customer customer) {
		Connection conn = DBUtils.getConnection();
		String sql = "INSERT INTO Customer (user_id, Password, role, CusName, Address) Values(?,?,?,?,?);";
		try {			
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, customer.getUsername());
			stmt.setString(2, customer.getPassword());
			stmt.setInt(3, customer.getRoleId());
			stmt.setString(4, customer.getCusName());
			stmt.setString(5, customer.getAddress());
			stmt.executeUpdate();
		}
		catch(SQLException se) {
			se.printStackTrace();
		}
	}

}
