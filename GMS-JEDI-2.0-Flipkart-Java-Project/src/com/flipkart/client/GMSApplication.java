/**
 * 
 */
package com.flipkart.client;

import java.util.*;
import com.flipkart.service.*;
import com.flipkart.bean.*;

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
		while(userInput != 5) {
			switch(userInput)
			{	
				case 1:
					//login
					gmsApplication.loginUser();
					break;
				case 2:
					//student registration
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
			userInput=in.nextInt();
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
		boolean successLogin = userSer.login(username,password, userList);
		if(successLogin) {
			String role = userSer.checkRole(username, password);
			switch(role) {
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
		}
		else {
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
	public void updatePassword() {
		UserInterface userSerr = new UserService();
		Scanner in = new Scanner(System.in);
		System.out.println("Please enter your username: ");
		String usernamee = in.nextLine();
		System.out.println("Please enter your old password: ");
		String oldPassword = in.nextLine();
		System.out.println("Please enter your new password: ");
		String newPassword = in.nextLine();
		if(userSerr.updatePassword(usernamee , oldPassword, newPassword));
		
	}
	
//	public static List<User> userList = new ArrayList<>();
//
//	public static List<Customer> customerList = new ArrayList<>();
//	
//	
//	
//	public static void main(String[] args) {
//		
////		for(int i=0;i<10;i++) {
////			User user = new User("user" + i ,"pass" + i, "customer");
////			userList.add(user);
////			System.out.println(user.getUserId() + user.getPassword());
////		}
//		Scanner in = new Scanner(System.in);
//		
//		System.out.println("Welcome to FlipFit Gymnasium Application\n");
//		System.out.println("Menu:");
//		System.out.println("1. Login");
//		System.out.println("2. Customer Registration");
//		System.out.println("3. GymOwner Registration");
//		System.out.println("4. Update Password");
//		System.out.println("5. Exit\n");
//		System.out.println("Enter your choice: ");
//		
//		int choice = in.nextInt();
//		
//		switch(choice){
//		case 1:
//			System.out.println("Login to FlipFit");
//			System.out.println("Enter your username: ");
//			String username = in.next();
//			System.out.println("Enter your password: ");
//			String password = in.next();
//			UserInterface userSer = new UserService();
//			boolean successLogin = userSer.login(username,password, userList);
//			if(successLogin) {
//				String role = userSer.checkRole(username, password);
//				switch(role) {
//				case "customer":
//					
//					GMSCustomerMenu cusMenu = new GMSCustomerMenu();
//					cusMenu.showCustomerMenu(username);
//					break;
//					
//				case "Gym Owner":
//					GMSGymOwnerMenu gymOwnerMenu = new GMSGymOwnerMenu();
//					gymOwnerMenu.showGymOwnerMenu();
//					break;
//					
//				case "Admin":
//					GMSAdminMenu adminMenu = new GMSAdminMenu();
//					adminMenu.showAdminMenu();
//					break;
//				}
//			}
//			else {
//				System.out.println("Wrong Login Credentials!");
//			}
//			break;
//		case 2:
//			GMSCustomerMenu cusMenu = new GMSCustomerMenu();
//			cusMenu.customerRegistration(userList, customerList);
//			break;
//		case 3:
//			break;
//		case 4:
//			UserInterface userSerr = new UserService();
//			System.out.println("Please enter your username: ");
//			String usernamee = in.nextLine();
//			System.out.println("Please enter your old password: ");
//			String oldPassword = in.nextLine();
//			System.out.println("Please enter your new password: ");
//			String newPassword = in.nextLine();
//			if(userSerr.updatePassword(usernamee , oldPassword, newPassword));
//			break;
//		case 5:
//			System.exit(0);
//			break;
//		default:
//			System.out.println("Please Select a valid option");
//		}
//	}

}
