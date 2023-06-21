/**
 * 
 */
package com.flipkart.client;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.flipkart.bean.Gym;
import com.flipkart.service.AdminGMSService;
import com.flipkart.service.BookingSlotService;
import com.flipkart.service.CustomerService;
import com.flipkart.service.GymOwnerService;
import com.flipkart.service.UserService;
import com.flipkart.service.UserInterface;
import java.util.*;
import com.flipkart.service.*;
import com.flipkart.bean.*;
import com.flipkart.client.GMSCustomerMenu;
import com.flipkart.client.GMSGymOwnerMenu;

/**
 * 
 */
public class GMSApplication {

	/**
	 * @param args
	 */

	public static List<User> userList = new ArrayList<>();

	public static List<Customer> customerList = new ArrayList<>();

	public static void main(String[] args) {
		for (int i = 0; i < 10; i++) {
			User user = new User("user" + i, "pass" + i, "customer");
			userList.add(user);
			System.out.println(user.getUserId() + user.getPassword());
		}
		Scanner in = new Scanner(System.in);

		System.out.println("Welcome to FlipFit Gymnasium Application\n");
		System.out.println("Menu:");
		System.out.println("1. Login");
		System.out.println("2. Customer Registration");
		System.out.println("3. GymOwner Registration");
		System.out.println("4. Update Password");
		System.out.println("5. Exit\n");
		System.out.println("Enter your choice: ");

		int choice = in.nextInt();

		switch (choice) {
		case 1:
			System.out.println("Login to FlipFit");
			System.out.println("Enter your username: ");
			String username = in.next();
			System.out.println("Enter your password: ");
			String password = in.next();
			UserInterface userSer = new UserService();
			boolean successLogin = userSer.login(username, password, userList);
			if (successLogin) {
				String role = userSer.checkRole(username, password);
				switch (role) {
				case "customer":

					GMSCustomerMenu cusMenu = new GMSCustomerMenu();
					cusMenu.showCustomerMenu(username);
					break;

				case "Gym Owner":
					GMSGymOwnerMenu gymOwnerMenu = new GMSGymOwnerMenu();
					gymOwnerMenu.showGymOwnerMenu();
					break;

				case "Admin":
					GMSAdminMenu adminMenu = new GMSAdminMenu();
					adminMenu.showAdminMenu();
					break;
				}
			} else {
				System.out.println("Wrong Login Credentials!");
			}
			break;
		case 2:
			GMSCustomerMenu cusMenu = new GMSCustomerMenu();
			cusMenu.customerRegistration(userList, customerList);
			break;
		case 3:
			GMSGymOwnerMenu gymOwnerMenu = new GMSGymOwnerMenu();
			gymOwnerMenu.showGymRegistrationMenu();
			break;
		case 4:
			UserInterface userSerr = new UserService();
			System.out.println("Please enter your username: ");
			String usernamee = in.nextLine();
			System.out.println("Please enter your old password: ");
			String oldPassword = in.nextLine();
			System.out.println("Please enter your new password: ");
			String newPassword = in.nextLine();
			if (userSerr.updatePassword(usernamee, oldPassword, newPassword))
				;
			break;
		case 5:
			System.exit(0);
			break;
		default:
			System.out.println("Please Select a valid option");
		}
	}

}
