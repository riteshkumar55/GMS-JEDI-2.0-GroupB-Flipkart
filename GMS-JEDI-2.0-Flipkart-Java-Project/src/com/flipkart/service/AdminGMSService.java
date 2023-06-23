/**
 * 
 */
package com.flipkart.service;

import java.util.List;

import com.flipkart.DAO.GymGMSDAOImpl;
import com.flipkart.DAO.GymGMSDao;
import com.flipkart.bean.Gym;

/**
 * 
 */
public class AdminGMSService implements AdminGMSInterface{
	public List<Gym> showAllGymCentres() {
		GymGMSDao GMSDao = new GymGMSDAOImpl();
		List<Gym> gymnasiums = GMSDao.getAllGyms();
		return gymnasiums;
	}
	public boolean approveGym(int gymId) {
		GymGMSDao gymGMSDao = new GymGMSDAOImpl();
		return gymGMSDao.updateApproval(gymId);
	}
}
