/**
 * 
 */
package com.flipkart.DAO;

import com.flipkart.bean.Role;
import com.flipkart.utils.DBUtil;
import java.sql.*;

/**
 * 
 */
public class RoleGMSDAOImpl implements RoleGMSDao {

	@Override
	public String getRoleNameById(int role_id) {
		Connection conn = DBUtil.getConnection();
		try {
			PreparedStatement stmt = conn.prepareStatement("SELECT role_name FROM Role WHERE role_id=? LIMIT 1");
			stmt.setInt(1,role_id);
			ResultSet rs = stmt.executeQuery();
			if(rs.next()) {
				return rs.getString("role_name");
			}
			else {
				return null;
			}
		}
		catch(SQLException se) {
			se.printStackTrace();
		}
		return null;
	}
	
	@Override
	public int getRoleIdByName(String role_name) {
		Connection conn = DBUtil.getConnection();
		try {
			PreparedStatement stmt = conn.prepareStatement("SELECT role_id FROM Role WHERE role_name=? LIMIT 1");
			stmt.setString(1,role_name);
			ResultSet rs = stmt.executeQuery();
			if(rs.next()) {
				return rs.getInt("role_id");
			}
			else {
				return -1;
			}
		}
		catch(SQLException se) {
			se.printStackTrace();
		}
		return -1;
	}

}
