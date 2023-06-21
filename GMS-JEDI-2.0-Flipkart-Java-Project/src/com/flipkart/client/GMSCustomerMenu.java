/**
 * 
 */
package com.flipkart.client;

<<<<<<< HEAD:GMS-JEDI-2.0-Flipkart-Java-Project/src/com/flipkart/client/CustomerMenu.java
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.flipkart.bean.Gym;
=======
import java.util.List;
import java.util.Scanner;

import com.flipkart.bean.Customer;
import com.flipkart.bean.User;
>>>>>>> 032679d20c8ddcd305a3de852d09c6373afb444a:GMS-JEDI-2.0-Flipkart-Java-Project/src/com/flipkart/client/GMSCustomerMenu.java
import com.flipkart.service.BookingSlotService;
import com.flipkart.service.CustomerService;
import com.flipkart.service.CustomerInterface;

/**
 * 
 */
<<<<<<< HEAD:GMS-JEDI-2.0-Flipkart-Java-Project/src/com/flipkart/client/CustomerMenu.java
public class CustomerMenu {
	public static List<Gym> gymnasiums = new ArrayList<Gym>();
=======
public class GMSCustomerMenu {
>>>>>>> 032679d20c8ddcd305a3de852d09c6373afb444a:GMS-JEDI-2.0-Flipkart-Java-Project/src/com/flipkart/client/GMSCustomerMenu.java
	public void showCustomerMenu(String username) {
		Scanner in = new Scanner(System.in);
		System.out.println("Menu:");
		System.out.println("1. Show all gym");
		System.out.println("2. Show all slot bookings");
		System.out.println("3. Cancel slot bookings");
		System.out.println("4. Logout\n");
		System.out.println("Enter your choice: ");
		// TODO Auto-generated method stub
		for(int i=0;i<10;i++) {
			Gym gm = new Gym(i,"Gym "+i,"GST_GYM_"+i,"Address_"+i,10);
			gymnasiums.add(gm);
		}
		
		int choiceCus = in.nextInt();
		CustomerInterface cusSer = new CustomerService();
		
		switch(choiceCus) {
		case 1:
			int slotNo = -1;
			while(slotNo<0) {
				cusSer.showAllGym(gymnasiums);
				System.out.println("Please Select the gym: ");
				int gymNo = in.nextInt();
				cusSer.showGymDetails(gymNo);
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
	
	public void customerRegistration(List<User> userlist, List<Customer> customerlist) {
		
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
		newCustomer.setUserId(in.next());
		newUser.setUserId(newCustomer.getUserId());
		newCustomer.setRole("customer");
		newUser.setRole("customer");
		customerlist.add(newCustomer);
		userlist.add(newUser);
		System.out.println("New Customer Added");
//	
		
	}
}