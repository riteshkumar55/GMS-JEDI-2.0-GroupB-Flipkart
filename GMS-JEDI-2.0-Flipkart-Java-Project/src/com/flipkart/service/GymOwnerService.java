package com.flipkart.service;

import java.util.List;

import com.flipkart.DAO.*;
import com.flipkart.bean.*;

public class GymOwnerService implements GymOwnerInterface{
/*
 * Implements functions to allow -
 * 1. remove gyms existing on the app's database
 * 2. view all gyms previously added by the gym owner
 * 3. registration of a gym owner
 * 4. add a new gym
 */
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
