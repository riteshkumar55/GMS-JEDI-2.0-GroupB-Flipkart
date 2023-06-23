/**
 * 
 */
package com.flipkart.service;

import java.util.List;

import com.flipkart.bean.Gym;

/**
 * 
 */
public interface AdminGMSInterface {
	public List<Gym> showAllGymCentres();
	public boolean approveGym(int gymNo);
}
