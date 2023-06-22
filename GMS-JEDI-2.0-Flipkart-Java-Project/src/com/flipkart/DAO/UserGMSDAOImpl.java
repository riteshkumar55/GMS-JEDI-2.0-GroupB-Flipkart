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
		String sql = "INSERT INTO User (user_id, password, role) Values(?,?,?);";
		try {			
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, user.getUserId());
			stmt.setString(2, user.getPassword());
			stmt.setString(3, user.getRole());
			stmt.executeUpdate();
		}
		catch(SQLException se) {
			se.printStackTrace();
		}
	}

	@Override
	public User getUserById(String userId) {
		Connection conn = JDBC.getConnection();
		String sql = "SELECT * FROM User WHERE user_id=? LIMIT 1";
		try {			
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, userId);
			ResultSet rs = stmt.executeQuery();
			if(rs.next()) {				
				return new User(rs.getString("user_id"),rs.getString("password"),rs.getString("role"));
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
