package com.flipkart.service;
import com.flipkart.DAO.RoleGMSDao;
import com.flipkart.DAO.RoleGMSDAOImpl;
public class RoleGMSService implements RoleGMSInterface {

	@Override
	public String getRoleNameById(int role_id) {
		RoleGMSDao roleDao = new RoleGMSDAOImpl();
		return roleDao.getRoleNameById(role_id);
	}

	@Override
	public int getRoleIdByName(String role_name) {
		RoleGMSDao roleDao = new RoleGMSDAOImpl();
		return roleDao.getRoleIdByName(role_name);
	}

}
