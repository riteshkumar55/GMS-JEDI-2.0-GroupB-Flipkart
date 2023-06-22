/**
 * 
 */
package com.flipkart.client;

import java.util.*;
import java.util.Scanner;

import com.flipkart.bean.*;
import com.flipkart.service.*;

/**
 * 
 */
public class GMSCustomerMenu {
	public void showCustomerMenu(String username) {
		Scanner in = new Scanner(System.in);
		System.out.println("Welcome " + username + " to FlipFit\n");
		System.out.println("Menu:");
		System.out.println("1. Show all gym");
		System.out.println("2. Show all slot bookings");
		System.out.println("3. Cancel slot bookings");
		System.out.println("4. Logout\n");
		System.out.println("Enter your choice: ");
		// TODO Auto-generated method stub
		
		int choiceCus = in.nextInt();
		CustomerInterface cusSer = new CustomerService();
		SlotGMSInterface slotSer = new SlotGMSService();
		
		switch(choiceCus) {
		case 1:
			int slotNo = -1;
			while(slotNo<0) {
				List<Gym> gymnasiums = cusSer.showAllGym();
				System.out.println("Name \t Address \t No. of Machines Total Slots");
				for(Gym gym: gymnasiums) {
					System.out.printf("%-5s\t", gym.getGymName());
					System.out.printf("%-8s\t", gym.getAddress());
					System.out.printf("%-10d\t", gym.getNumberOfMachines());
					System.out.printf("%-2d\n", gym.getTotSlots());
				}
				System.out.println("Please Select the gym: ");
				int gymNo = in.nextInt();
				Gym selected_gym = gymnasiums.get(gymNo);
				List<Slot> slots = slotSer.getSlotsOfGym(selected_gym.getGymId());
				
				System.out.println("1. Please select the slot you want to book: ");
				System.out.println("Day \t\t Time \t Availabe Seats");
				for(Slot st: slots) {
					System.out.printf("%-3tD\t", st.getDay());
					System.out.printf("%-5d\t", st.getSlotTime());
					System.out.printf("%-3d\n", st.getAvailSeats());
				}
				System.out.println("2. Back(enter -1)\n");
				System.out.println("Enter your choice: ");
				slotNo = in.nextInt();
				
				if(slotNo != -1) {
					BookingSlotService bookSlot = new BookingSlotService();
					Slot selected_slot = slots.get(slotNo);
					if(bookSlot.bookSlot(username,selected_slot.getSlotId())) {
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
			List<Booking> bookings = cusSer.showAllBookings(username);
			for(Booking booking : bookings) {
				System.out.println(booking.getBooking_id() + "  " + booking.getSlot_id() + "  " + booking.getDate());
			}
			
			
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
			System.out.println("logged out!\n");
			break;
		}
	}
	
	public void customerRegistration() {
		
		RoleGMSInterface roleGMSSer = new RoleGMSService();
		
		Customer newCustomer = new Customer();
		Scanner in = new Scanner(System.in);
		
		System.out.println("Please enter your Username: ");
		newCustomer.setUsername(in.next());
		System.out.println("Please set your Password: ");
		newCustomer.setPassword(in.next());
		newCustomer.setRoleId(roleGMSSer.getRoleIdByName("Customer"));
		System.out.println("Please enter your Name: ");
		newCustomer.setName(in.next());
		System.out.println("Please enter your Address: ");
		newCustomer.setAddress(in.next());
		System.out.println("Please enter your Phone: ");
		newCustomer.setPhone(in.next());
		System.out.println("Please enter your Gender: ");
		newCustomer.setGender(in.next());
		
		CustomerInterface cusSer = new CustomerService();
		cusSer.customerRegistration(newCustomer);
	
		System.out.println("New Customer Added");
	}
}
