/**
 * 
 */
package com.flipkart.utils;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * 
 */
public class JDBC {
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://localhost/GMS_DB";

	// Database credentials
	static final String USER = "deepak";
	static final String PASS = "pass#2001";

	public static Connection getConnection() {
		Connection conn = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;

	}
}
