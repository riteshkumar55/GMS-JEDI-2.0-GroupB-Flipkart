package com.flipkart.service;
import com.flipkart.bean.*;
public class GymOwnerService implements GymOwnerInterface{
	
	public boolean addGym(){
		Gym newGym = new Gym();
		return true;
	}
	public boolean removeGym(){
		return false;
	}
	public void viewGyms(){
		
	}

	@Override
	public boolean OwnerRegister() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean addGymCentre() {
		// TODO Auto-generated method stub
		return false;
	}
	
}
