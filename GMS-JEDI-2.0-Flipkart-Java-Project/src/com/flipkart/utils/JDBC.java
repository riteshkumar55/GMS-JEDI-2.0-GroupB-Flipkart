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
	static final String USER = "root";
	static final String PASS = "Root@1234";

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
