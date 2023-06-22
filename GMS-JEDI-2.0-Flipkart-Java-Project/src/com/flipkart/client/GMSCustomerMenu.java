/**
 * 
 */
package com.flipkart.client;

import java.util.*;
import java.util.Scanner;
import com.flipkart.bean.Gym;
import com.flipkart.bean.Customer;
import com.flipkart.bean.User;
import com.flipkart.service.BookingSlotService;
import com.flipkart.service.CustomerService;
import com.flipkart.service.CustomerInterface;
import com.flipkart.bean.*;
import java.util.*;
import com.flipkart.service.*;

/**
 * 
 */
public class GMSCustomerMenu {
	public void showCustomerMenu(String username) {
		Scanner in = new Scanner(System.in);
		System.out.println("Menu:");
		System.out.println("1. Show all gym");
		System.out.println("2. Show all slot bookings");
		System.out.println("3. Cancel slot bookings");
		System.out.println("4. Logout\n");
		System.out.println("Enter your choice: ");
		// TODO Auto-generated method stub
		
		int choiceCus = in.nextInt();
		CustomerInterface cusSer = new CustomerService();
		
		switch(choiceCus) {
		case 1:
			int slotNo = -1;
			while(slotNo<0) {
				List<Gym> gymnasiums = cusSer.showAllGym();
				System.out.println("Name \t Address \t Total Slots Number of Machines");
				for(Gym gym: gymnasiums) {
					System.out.printf("%-5s\t", gym.getGymName());
					System.out.printf("%-10s\t", gym.getAddress());
					System.out.printf("%-3d\t", gym.getTotSlots());
					System.out.printf("%-3d\n", gym.getNumberOfMachines());
				}
				System.out.println("Please Select the gym: ");
				int gymNo = in.nextInt();
				Gym selected_gym = gymnasiums.get(gymNo);
				Gym selected_gym_details = cusSer.showGymDetails(selected_gym.getGymId());
				System.out.println("1. Please select the slot you want to book: ");
				System.out.println("2. Back(enter -1)\n");
				System.out.println("Enter your choice: ");
				slotNo = in.nextInt();
				
				if(slotNo != -1) {
					BookingSlotService bookSlot = new BookingSlotService();
					if(bookSlot.bookSlot(username,gymNo,slotNo)) {
						System.out.println("Slot booked successfully!");
					}
					else {
						System.out.println("Slot full, please choose another slot");
					}
				}
			}
			break;
		case 2:
			System.out.println("Your Slot Bookings:");
			cusSer.showAllBookings(username);
			break;
		case 3:
			cusSer.showAllBookings(username);
			System.out.println("Please select the slot booking you want to cancel: ");
			int bookingNo = in.nextInt();
			if(cusSer.cancelBooking(username , bookingNo)) {
				System.out.println("Your booking has been successfully cancelled");
			}
			else {
				System.out.println("Eror! Booking cannot be cancelled");
			}
			break;
		case 4:
			System.out.println("logged out!");
			break;
		}
	}
	
	public void customerRegistration(List<User> userList, List<Customer> customerList) {
		
		Customer newCustomer = new Customer("1","1","1");
		User newUser = new User("1","1","1");
		Scanner in = new Scanner(System.in);
		
		System.out.println("Please enter your Name: ");
		newCustomer.setCusName(in.nextLine());
		System.out.println("Please enter your Address: ");
		newCustomer.setAddress(in.nextLine());
		System.out.println("Please set your password: ");
		newCustomer.setPassword(in.next());
		newUser.setPassword(newCustomer.getPassword());
		System.out.println("Please enter your username: ");
		newCustomer.setUsername(in.next());
		newUser.setUsername(newCustomer.getUsername());
		newCustomer.setRole("customer");
		newUser.setRole("customer");
//		customerList.add(newCustomer);
//		userList.add(newUser);
//		CustomerInterface cusSer = new CustomerService();
		UserInterface userSer = new UserService();
		userSer.userRegistration(newUser);
		
//		cusSer.customerRegistration(newUser,newCustomer);
		
		
		System.out.println("New Customer Added");
	}
}
