package com.flipkart.DAO;

import com.flipkart.bean.GymOwner;

public interface GymOwnerGMSDao {
	public void createGymOwner(GymOwner newGymOwner);
	public boolean isApproved(String gym_owner_id);

}
