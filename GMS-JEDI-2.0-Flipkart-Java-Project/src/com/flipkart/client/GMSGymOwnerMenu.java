/**
 * 
 */
package com.flipkart.client;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.flipkart.service.GymOwnerService;
import com.flipkart.service.RoleGMSInterface;
import com.flipkart.service.RoleGMSService;
import com.flipkart.bean.Customer;
import com.flipkart.bean.Gym;
import com.flipkart.bean.GymOwner;
import com.flipkart.bean.User;
import com.flipkart.service.GymOwnerInterface;

/**
 * 
 */
public class GMSGymOwnerMenu {
	public void showGymOwnerMenu(String username) {
		Scanner in = new Scanner(System.in);
		System.out.println("Welcome " + username + " to FlipFit\n");
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
			System.out.println("Logged Out!\n");
			break;
		}
	}

	public void gymOwnerRegistration(List<User> userList, List<GymOwner> gymOwnerList) {
		Scanner in = new Scanner(System.in);
		RoleGMSInterface roleGMSSer = new RoleGMSService();
		
		GymOwner newGymOwner = new GymOwner("1","1","1");
		User newUser = new User("1","1",1,"1");
		
		System.out.println("Please enter your Name: ");
		newGymOwner.setOwnerName(in.nextLine());
		System.out.println("Please enter your Address: ");
		newGymOwner.setAddress(in.nextLine());
		System.out.println("Please set your password: ");
		newGymOwner.setPassword(in.next());
		newUser.setPassword(newGymOwner.getPassword());
		System.out.println("Please enter your username: ");
		newGymOwner.setUsername(in.next());
		newUser.setUsername(newGymOwner.getUsername());
		newGymOwner.setRoleId(roleGMSSer.getRoleIdByName("gymOwner"));
		System.out.println("Enter GST No");
		newGymOwner.setAadharNo(in.next());
		System.out.println("Enter no of gyms");
		int n = in.nextInt();
		List<Gym> allGyms = new ArrayList<>();
		
		for(int i=0;i<n;i++) {
			Gym newGym = new Gym();
			System.out.println("Enter information for Gym" + i+1);
			System.out.println("Enter Gym ID");
			newGym.setGymId(in.nextInt());
			System.out.println("Enter Gym Name");
			newGym.setGymName(in.next());
			System.out.println("Enter Address of the Gym");
			newGym.setAddress(in.next());
			System.out.println("Enter total no of slots");
			newGym.setTotSlots(in.nextInt());
			System.out.println("Enter no of seats in a slot");
			newGym.setSeats(in.nextInt());
			allGyms.add(newGym);
		}
		newGymOwner.setAllGym(allGyms);
		newUser.setRoleId(roleGMSSer.getRoleIdByName("gymOwner"));
		gymOwnerList.add(newGymOwner);
		userList.add(newUser);
		System.out.println("New GymOwner Added");
	}
}
