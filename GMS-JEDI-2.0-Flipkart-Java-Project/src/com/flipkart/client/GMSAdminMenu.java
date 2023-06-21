/**
 * 
 */
package com.flipkart.client;

import java.util.Scanner;

import com.flipkart.service.*;

/**
 * 
 */
public class GMSAdminMenu {
	public void showAdminMenu() {
		Scanner in = new Scanner(System.in);
		System.out.println("Menu:");
		System.out.println("1. Approve Gym Center");
		System.out.println("2. Logout\n");
		System.out.println("Enter your choice: ");

		int adminChoice = in.nextInt();

		switch (adminChoice) {
		case 1:
			AdminGMSInterface admSer = new AdminGMSService();
			admSer.showNonApprovedGymCentre();
			System.out.println("Please select the gym cemtre to approve:");

			int gymNo = in.nextInt();
			if (admSer.approveGym(gymNo)) {
				System.out.println("Gym has been successfully approved!");
			} else {
				System.out.println("Error!Gym Cannot be approved");
			}

		case 2:
			System.out.println("logged out!");
		}
	}
}
