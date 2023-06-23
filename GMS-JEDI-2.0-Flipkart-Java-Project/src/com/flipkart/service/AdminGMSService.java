/**
 * 
 */
package com.flipkart.service;

import java.util.List;

import com.flipkart.DAO.GymGMSDAOImpl;
import com.flipkart.DAO.GymGMSDao;
import com.flipkart.bean.Gym;

/**
 *  SERVICE FOR ADMIN/FLIPKART TO VIEW ALL GYMS AND APPROVE PENDING GYMS
 */
public class AdminGMSService implements AdminGMSInterface{
	public List<Gym> showAllGymCentres() {
		GymGMSDao GMSDao = new GymGMSDAOImpl();
		List<Gym> gymnasiums = GMSDao.getAllAvailableGyms();
		return gymnasiums;
	}
	public boolean approveGym(int gymId) {
		GymGMSDao gymGMSDao = new GymGMSDAOImpl();
		return gymGMSDao.updateApproval(gymId);
	}
}
