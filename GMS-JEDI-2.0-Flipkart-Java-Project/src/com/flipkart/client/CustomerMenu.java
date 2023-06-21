/**
 * 
 */
package com.flipkart.client;

import java.util.Scanner;

import com.flipkart.service.BookingSlotService;
import com.flipkart.service.CustomerService;
import com.flipkart.service.CustomerInterface;

/**
 * 
 */
public class CustomerMenu {
	public void showCustomerMenu(String username) {
		Scanner in = new Scanner(System.in);
		System.out.println("Menu:");
		System.out.println("1. Show all gym");
		System.out.println("2. Show all slot bookings");
		System.out.println("3. Cancel slot bookings");
		System.out.println("4. Logout\n");
		System.out.println("Enter your choice: ");
		
		int choiceCus = in.nextInt();
		CustomerInterface cusSer = new CustomerService();
		
		switch(choiceCus) {
		case 1:
			int slotNo = -1;
			while(slotNo<0) {
				cusSer.showAllGym();
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
}
