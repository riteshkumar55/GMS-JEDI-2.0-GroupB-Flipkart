/**
 * 
 */
package com.flipkart.client;

import java.util.Scanner;

import com.flipkart.service.GymOwnerService;
import com.flipkart.service.GymOwnerInterface;

/**
 * 
 */
public class GMSGymOwnerMenu {
	public void showGymOwnerMenu() {
		Scanner in = new Scanner(System.in);
		System.out.println("Menu:");
		System.out.println("1. Add Gym Center");
		System.out.println("2. Logout\n");
		System.out.println("Enter your choice: ");

		int gymOwnerChoice = in.nextInt();

		switch (gymOwnerChoice) {
		case 1:
			GymOwnerInterface gymOwnSer = new GymOwnerService();
			gymOwnSer.addGymCentre();
			break;
		case 2:
			System.out.println("Logged Out!");
			break;
		}
	}
}
