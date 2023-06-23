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
	
	public static List<GymOwner> gymOwnerList = new ArrayList<>();
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		GMSApplication gmsApplication = new GMSApplication();
		createMainMenu();
		int userInput = in.nextInt();
		while (userInput != 5) {
			switch (userInput) {
			case 1:
				// login
				gmsApplication.loginUser();
				break;
			case 2:
				// student registration
				gmsApplication.customerRegistration();
				break;
			case 3:
				gmsApplication.gymownerRegistration();
				break;
			case 4:
				gmsApplication.updatePassword();
			default:
				System.out.println("Invalid Output");
			}
			createMainMenu();
			userInput = in.nextInt();
		}

	}

	public static void createMainMenu() {
		System.out.println("Welcome to FlipFit Gymnasium Application\n");
		System.out.println("Menu:");
		System.out.println("1. Login");
		System.out.println("2. Customer Registration");
		System.out.println("3. GymOwner Registration");
		System.out.println("4. Update Password");
		System.out.println("5. Exit\n");
		System.out.println("Enter your choice: ");

	}

	public void loginUser() {
		System.out.println("Login to FlipFit");
		System.out.println("Enter your username: ");
		Scanner in = new Scanner(System.in);
		String username = in.next();
		System.out.println("Enter your password: ");
		String password = in.next();
		UserInterface userSer = new UserService();
		RoleGMSInterface rolSer = new RoleGMSService();
		User user = userSer.login(username, password);
		if (user!=null) {
			String role = rolSer.getRoleNameById(user.getRoleId());
			switch (role) {
			case "Customer":

				GMSCustomerMenu cusMenu = new GMSCustomerMenu();
				cusMenu.showCustomerMenu(username);
				break;

			case "Gym Owner":
				GMSGymOwnerMenu gymOwnerMenu = new GMSGymOwnerMenu();
				gymOwnerMenu.showGymOwnerMenu(username);
				break;

			case "Admin":
				GMSAdminMenu adminMenu = new GMSAdminMenu();
				adminMenu.showAdminMenu(username);
				break;
			
			default:
				System.out.println("Role not found");
				break;
			}
		} else {
			System.out.println("Wrong Login Credentials!");
		}
	}

	public void customerRegistration() {
		GMSCustomerMenu cusMenu = new GMSCustomerMenu();
		cusMenu.customerRegistration(userList, customerList);
	}

	public void gymownerRegistration() {
		GMSGymOwnerMenu gymOwnerMenu = new GMSGymOwnerMenu();
		gymOwnerMenu.gymOwnerRegistration(userList, gymOwnerList);
		
	}

	public boolean updatePassword() {
		UserInterface userSerr = new UserService();
		Scanner in = new Scanner(System.in);
		System.out.println("Please enter your username: ");
		String usernamee = in.nextLine();
		System.out.println("Please enter your old password: ");
		String oldPassword = in.nextLine();
		System.out.println("Please enter your new password: ");
		String newPassword = in.nextLine();
		in.close();
		if (userSerr.updatePassword(usernamee, oldPassword, newPassword))
			return true;
		return false;
	}

}
