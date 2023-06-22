package com.flipkart.service;

import com.flipkart.bean.Gym;

public class GymOwnerService implements GymOwnerInterface{
	public boolean OwnerRegister() {
		return true;
	}
	public boolean addGymCentre() {
		return true;
	}
	public boolean addGym(){
		Gym newGym = new Gym();
		return true;
	}
	public boolean removeGym(){
		return true;
	}
	public void viewGyms(){
		
	}
	
}
