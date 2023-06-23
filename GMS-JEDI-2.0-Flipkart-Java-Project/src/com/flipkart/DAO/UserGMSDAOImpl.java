/**
 * 
 */
package com.flipkart.DAO;
import com.flipkart.utils.JDBC;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.List;
import com.flipkart.bean.User;
/**
 * 
 */
public class UserGMSDAOImpl implements UserGMSDao{
	public void createUser(User user) {
		Connection conn = JDBC.getConnection();
		String sql = "INSERT INTO User (username, password, role_id, name) Values(?,?,?,?);";
		try {			
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, user.getUsername());
			stmt.setString(2, user.getPassword());
			stmt.setInt(3, user.getRoleId());
			stmt.setString(4, user.getName());
			stmt.executeUpdate();
		}
		catch(SQLException se) {
			se.printStackTrace();
		}
	}

	@Override
	public User getUserByUsername(String userId) {
		Connection conn = JDBC.getConnection();
		String sql = "SELECT * FROM User WHERE username=? LIMIT 1";
		try {			
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, userId);
			ResultSet rs = stmt.executeQuery();
			if(rs.next()) {				
				return new User(rs.getString("username"),rs.getString("password"),rs.getInt("role_id"),rs.getString("name"));
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
	public void updateUser(User user) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteUser(User user) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<User> getAllUsers() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean authenticateUser(String userId, String password) {
		// TODO Auto-generated method stub
		return false;
	}

}
