package com.flipkart.service;

import java.util.List;

import com.flipkart.bean.Gym;
import com.flipkart.bean.GymOwner;
/*Interface for GymOwner Service */

public interface GymOwnerInterface {
	public boolean gymOwnerRegister(GymOwner newGymOwner);
	public Gym addGym(Gym gym);
	public boolean removeGym(int gymId);
	public List<Gym> viewGym(String username);
}
