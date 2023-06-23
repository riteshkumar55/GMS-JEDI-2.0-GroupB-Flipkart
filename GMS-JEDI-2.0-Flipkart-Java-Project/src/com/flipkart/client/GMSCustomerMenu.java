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
	
	public static void showCustomerMenu(String username) {
		Scanner in = new Scanner(System.in);
		GMSCustomerMenu gmsCustomerMenu = new GMSCustomerMenu();
		createCustomerMenu(username);
		int userInput = in.nextInt();
		while (userInput != 5) {
			switch (userInput) {
			case 1:
				// Show all gym
				gmsCustomerMenu.showAllGym(username);
				break;
			case 2:
				// Show all slot booking
				gmsCustomerMenu.showAllSlotBooking(username);
				break;
			case 3:
				//Cancel Slot Booking
				gmsCustomerMenu.cancelSlotBooking(username);
				break;
			case 4:
				//Logout
//				gmsApplication.updatePassword();
			default:
				System.out.println("Invalid Output");
			}
			createCustomerMenu(username);
			userInput = in.nextInt();
		}
	}
	
	public static void createCustomerMenu(String username) {
		System.out.println("Welcome " + username + " to FlipFit\n");
		System.out.println("Menu:");
		System.out.println("1. Show all gym");
		System.out.println("2. Show all slot bookings");
		System.out.println("3. Cancel slot bookings");
		System.out.println("4. Logout\n");
		System.out.println("Enter your choice: ");

	}
	
	public void showAllGym(String username) {

		CustomerInterface cusSer = new CustomerService();
		SlotGMSInterface slotSer = new SlotGMSService();
		Scanner in = new Scanner(System.in);
		int slotNo = -1;
		while (slotNo < 0) {
			List<Gym> gymnasiums = cusSer.showAllAvailableGym();
			System.out.println("Name \t Address \t No. of Machines Total Slots");
			for (Gym gym : gymnasiums) {
				System.out.printf("%-5s\t", gym.getGymName());
				System.out.printf("%-18s\t", gym.getAddress());
				System.out.printf("%-10d\t", gym.getNumberOfMachines());
				System.out.printf("%-2d\n", gym.getTotSlots());
			}
			System.out.println("Please Select the gym: ");
			System.out.println("Enter -1 to go back to Customer Menu");
			int gymNo = in.nextInt();
			if(gymNo == -1)return;
			Gym selected_gym = gymnasiums.get(gymNo-1);
			List<Slot> slots = slotSer.getSlotsOfGym(selected_gym.getGymId());

			System.out.println("1. Please select the slot you want to book: ");
			System.out.println("Day \t\t Time \t Availabe Seats");
			for (Slot st : slots) {
				System.out.printf("%-3tD\t", st.getDay());
				System.out.printf("%-5d\t", st.getSlotTime());
				System.out.printf("%-3d\n", st.getAvailSeats());
			}
			System.out.println("2. Back(enter -1)");
			System.out.println("Enter your choice: ");
			slotNo = in.nextInt();
			
			if (slotNo != -1) {
				BookingSlotService bookSlotser = new BookingSlotService();
				Slot selected_slot = slots.get(slotNo-1);
				Booking clashing = bookSlotser.getClashingBooking(username, selected_slot.getSlotId());
				if (clashing != null) {
					System.out.println("You already have a booking");
					System.out.println(clashing.getBooking_id() + "  " + clashing.getSlot_id() + "  "
							+ clashing.getDate());
					System.out.println("Press 1 to cancel old booking and create new booking");
					System.out.println("Press 2 to cancel current booking");
					int booking_choice = in.nextInt();
					if (booking_choice == 2)
						continue;
					else if (booking_choice == 1) {
						if (!slotSer.isSlotAvailable(selected_slot.getSlotId())) {
							System.out.println("Slot full, please choose another slot");
							continue;
						}
					}
					bookSlotser.cancelSlot(clashing.getBooking_id());
				}
				if (bookSlotser.bookSlot(username, selected_slot.getSlotId())) {
					System.out.println("Slot booked successfully!");
				} else {
					System.out.println("Slot cannot be booked");
				}
			}
		}

	}
	
	public void showAllSlotBooking(String username) {
		CustomerInterface cusSer = new CustomerService();
		System.out.println("Your Slot Bookings:");
		List<Booking> bookings = cusSer.showAllBookings(username);
		System.out.println("Booking id\tSlot id\t\tDate");
		for (Booking booking : bookings) {
			System.out
					.println(booking.getBooking_id() + "\t\t" + booking.getSlot_id() + "\t\t" + booking.getDate());
		}

		
	}
	
	public void cancelSlotBooking(String username) {
		CustomerInterface cusSer = new CustomerService();
		Scanner in = new Scanner(System.in);
		List<Booking> previous_bookings = cusSer.showAllBookings(username);
		System.out.println("Booking id\tSlot id\t\tDate");
		for (Booking booking : previous_bookings) {
			System.out
					.println(booking.getBooking_id() + "\t\t" + booking.getSlot_id() + "\t\t" + booking.getDate());
		}

		System.out.println("Please select the slot booking you want to cancel: ");
		int bookingNo = in.nextInt();
		if (cusSer.cancelBooking(previous_bookings.get(bookingNo-1).getBooking_id())) {
			System.out.println("Your booking has been successfully cancelled");
		} else {
			System.out.println("Eror! Booking cannot be cancelled");
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
