package com.flipkart.service;

import com.flipkart.bean.Gym;
import com.flipkart.bean.GymOwner;

public interface GymOwnerInterface {
	public boolean gymOwnerRegister(GymOwner newGymOwner);
	public boolean addGym(Gym gym, String username);
	public boolean removeGym(int gymId);
	public void viewGym(String username);
}
