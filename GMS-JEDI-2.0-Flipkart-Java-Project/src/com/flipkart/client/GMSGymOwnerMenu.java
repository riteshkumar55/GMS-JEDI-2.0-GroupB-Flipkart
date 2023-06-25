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
import com.flipkart.bean.Slot;
import com.flipkart.bean.User;
import com.flipkart.service.*;
import java.sql.Date;
import java.sql.Time;
/**
 * 
 */
public class GMSGymOwnerMenu {
	public void showGymOwnerMenu(String username ) {
		Scanner in = new Scanner(System.in);
		System.out.println("\nWelcome " + username + " to FlipFit\n");
		System.out.println("Menu:");
		System.out.println("1. Add Gym Center");
		System.out.println("2. Remove Gym Center");
		System.out.println("3. List All My Gym Center");
		System.out.println("4. Logout\n");
		System.out.print("Enter your choice: ");

		int gymOwnerChoice = in.nextInt();

		switch (gymOwnerChoice) {
		case 1:
			Gym newGym = new Gym();
			newGym.setGymOwnerId(username);
			System.out.print("Enter information for Gym\n");
			System.out.print("Enter Gym Name: ");
			newGym.setGymName(in.next());
			System.out.print("Enter GST Number: ");
			newGym.setGstNo(in.next());
			System.out.print("Enter Address of the Gym: ");
			newGym.setAddress(in.next());
			System.out.print("Enter no of seats in a slot: ");
			newGym.setSeats(in.nextInt());
			System.out.print("Enter total number of machines: ");
			newGym.setNumberOfMachines(in.nextInt());
			System.out.print("Enter total number of instructors: ");
			newGym.setNumberOfInstructors(in.nextInt());
			System.out.print("Is cardio available (0 for No and 1 for Yes): ");
			newGym.setIsCardioAvailable(in.nextBoolean());
			System.out.print("Is crossfit available (0 for No and 1 for Yes): ");
			newGym.setIsCrossfitAvailable(in.nextBoolean());
			System.out.print("Enter total floor area: ");
			newGym.setFloorArea(in.nextInt());
			System.out.print("Enter total no of slots: ");
			int total_slots = in.nextInt();
			newGym.setTotSlots(total_slots);
			GymOwnerInterface gymOwnSer = new GymOwnerService();
			Gym new_gym = gymOwnSer.addGym(newGym);
			List<Slot> slots = new ArrayList<Slot>(); 
			System.out.println("Enter the slot informations\n");
			for(int i=0;i<total_slots;i++) {
		        System.out.print("Enter the start time (HH:mm:ss): ");
		        String startTimeString = in.next();
		        System.out.print("Enter the end time (HH:mm:ss): ");
		        String endTimeString = in.next();
		        Time startTime = Time.valueOf(startTimeString);
		        Time endTime = Time.valueOf(endTimeString);
		        slots.add(new Slot(-1,startTime,endTime,newGym.getSeats(),newGym.getGymId(),null));
		        System.out.println();
		        
			}
			SlotGMSInterface slotSer = new SlotGMSService();
			slotSer.createSlots(slots);
			System.out.println("Your Slots have been added");
			break;
		case 2:
			System.out.println("\nRemoved!\n");
			break;
		case 3:
			GymOwnerInterface gymOwner = new GymOwnerService();
			gymOwner.viewGym(username);
			System.out.println("\nAdded\n");
			break;
		case 4:
			System.out.println("\nLogged Out!\n");
			break;
		}
	}
// **remove parameters **
	public void gymOwnerRegistration(List<User> userList, List<GymOwner> gymOwnerList) {
		Scanner in = new Scanner(System.in);
		
		RoleGMSInterface roleGMSSer = new RoleGMSService();
		GymOwnerInterface gymOwner = new GymOwnerService();
		UserInterface user = new UserService();
		
		GymOwner newGymOwner = new GymOwner("1","1",1,"1");
		User newUser = new User("1","1",1,"1");

		newGymOwner.setRoleId(roleGMSSer.getRoleIdByName("Gym Owner"));
		newUser.setRoleId(roleGMSSer.getRoleIdByName("Gym Owner"));
		
		System.out.print("Please enter your Name: ");
		newGymOwner.setName(in.next());
		newUser.setName(newGymOwner.getName());
		
		System.out.print("Please enter your username: ");
		newGymOwner.setUsername(in.next());
		newUser.setUsername(newGymOwner.getUsername());
		
		System.out.print("Please set your password: ");
		newGymOwner.setPassword(in.next());
		newUser.setPassword(newGymOwner.getPassword());

		System.out.print("Please enter your Address: ");
		newGymOwner.setAddress(in.next());
		
		System.out.print("Enter Aadhaar No: ");
		newGymOwner.setAadharNo(in.next());
		
		System.out.print("Enter PAN No: ");
		newGymOwner.setPanCard(in.next());
		
//		System.out.print("Enter Registration id: ");
//		newGymOwner.setRegistrationId(in.next());
		
//		System.out.println("Enter no of gyms");
//		int n = in.nextInt();
//		List<Gym> allGyms = new ArrayList<>();
		
//		for(int i=0;i<n;i++) {
//			Gym newGym = new Gym();
//			System.out.println("Enter information for Gym" + i+1);
//			System.out.println("Enter Gym ID");
//			newGym.setGymId(in.nextInt());
//			System.out.println("Enter Gym Name");
//			newGym.setGymName(in.next());
//			System.out.println("Enter GST Number");
//			newGym.setGstNo(in.next());
//			System.out.println("Enter Address of the Gym");
//			newGym.setAddress(in.next());
//			System.out.println("Enter total no of slots");
//			newGym.setTotSlots(in.nextInt());
//			System.out.println("Enter no of seats in a slot");
//			newGym.setSeats(in.nextInt());
//			System.out.println("Enter total number of machines");
//			newGym.setNumberOfMachines(in.nextInt());
//			System.out.println("Enter total number of instructors");
//			newGym.setNumber_of_instructors(in.nextInt());
//			System.out.println("Is cardio available (0 for No and 1 for Yes");
//			newGym.setIs_cardio_available(in.nextBoolean());
//			System.out.println("Is crossfit available (0 for No and 1 for Yes");
//			newGym.setIs_crossfit_available(in.nextBoolean());
//			System.out.println("Enter total floor area");
//			newGym.setFloor_area(in.nextInt());
//			
//			allGyms.add(newGym);
//		}
//		newGymOwner.setAllGym(allGyms);
//		gymOwnerList.add(newGymOwner);

		user.userRegistration(newUser);
		gymOwner.gymOwnerRegister(newGymOwner);
		
		
		userList.add(newUser);
		System.out.println("\nNew GymOwner Added\n");
	}
}
