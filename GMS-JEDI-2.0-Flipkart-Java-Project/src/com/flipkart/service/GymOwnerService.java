package com.flipkart.service;

import java.util.List;

import com.flipkart.DAO.*;
import com.flipkart.bean.*;

public class GymOwnerService implements GymOwnerInterface{
//	@Override
//	public boolean addGym(Gym gym, String username) {
//		// TODO Auto-generated method stub
////
////		GymGMSDao gymDao = new GymGMSDAOImpl();
////		gymDao.createGym(gym);
//		
//		
//		return false;
//	}
	@Override
	public boolean removeGym(int gymId) {
		// TODO Auto-generated method stub
		
		GymGMSDao gymDao = new GymGMSDAOImpl();
		String res = gymDao.removeGym(gymId);
		if(res.equals("Gym removed"))
			return true;
		return false;
	}
	@Override
	public void viewGym(String username) {
		// TODO Auto-generated method stub
		GymGMSDao gymDao = new GymGMSDAOImpl();
		List<Gym> gymnasiums = gymDao.getAllMyGyms(username);
		System.out.println("Name \t Address \t Total Slots Number of Machines");
		for(Gym myGym: gymnasiums) {
			System.out.printf("%-5s\t", myGym.getGymName());
			System.out.printf("%-10s\t", myGym.getAddress());
			System.out.printf("%-3d\t", myGym.getTotSlots());
			System.out.printf("%-3d\n", myGym.getNumberOfMachines());
			
		}
		
		
	}
	
	public boolean gymOwnerRegister(GymOwner newGymOwner) {
		GymOwnerGMSDao gymOwnerDao = new GymOwnerGMSDAOImpl();
		gymOwnerDao.createGymOwner(newGymOwner);
		return true;
	}
	@Override
	public boolean addGym(Gym gym, String username) {
		
		// TODO Auto-generated method stub
		GymGMSDao gymDao = new GymGMSDAOImpl();
		gymDao.createGym(gym);
		return false;
	}
}
