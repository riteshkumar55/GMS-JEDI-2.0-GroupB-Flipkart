/**
 * 
 */
package com.flipkart.service;

/**
 * 
 */
public interface AdminGMSInterface {
	public boolean adminRegistration();
	public void showNonApprovedGymCentre();
	public boolean approveGym(int gymNo);
}
