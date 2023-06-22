package com.flipkart.DAO;
import com.flipkart.bean.Role;

public interface RoleGMSDao {
	public String getRoleNameById(int role_id);
	public int getRoleIdByName(String role_name);
}
