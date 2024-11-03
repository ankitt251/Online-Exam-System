package com.hexaware;

import java.util.Scanner;

import com.hexaware.service.QuestionService;
import com.hexaware.service.UserService;

/**
 * Hello world!
 *
 */
public class App {
	static Scanner sc = new Scanner(System.in);
	static UserService userService = new UserService();
	static QuestionService queService = new QuestionService();

	public static void main(String[] args) {
		int choice;
		do {
			System.out.println("Main Menu:");
			System.out.println("1. Register");
			System.out.println("2. Login");
			System.out.println("3. Exit");
			System.out.print("Enter your choice: ");
			choice = sc.nextInt();
			sc.nextLine(); // Consume newline left-over
			switch (choice) {
			case 1:
				userService.registerUser();
				break;
			case 2:
				// Proceed to login and enter the user/admin menu based on role
				userService.signIn();
				break;
			case 3:
				System.out.println("Exiting the application.");
				break;
			default:
				System.out.println("Invalid choice. Please try again.");
			}
		} while (choice != 3);
	}

	public static void adminMenu() {
		int choice;
		do {
			System.out.println("Admin Menu:");
			System.out.println("1. Add Questions");
			System.out.println("2. Update Questions");
			System.out.println("3. Delete Questions");

			System.out.println("4. Add User");
			System.out.println("5. Update User");
			System.out.println("6. Delete User");
			System.out.println("7. Logout");
			System.out.print("Enter your choice: ");
			choice = sc.nextInt();
			sc.nextLine(); // Consume newline left-over

			switch (choice) {
			case 1:
				queService.addQuestions();
				break;
			case 2:
				queService.updateQuestions();
				break;
			case 3:
				queService.deleteQuestions();
				break;
			case 4:
				userService.registerUser();
				break;
			case 5:
				userService.updateUser();
				break;
			case 6:
				userService.removeUser();
				break;
			case 7:
				System.out.println("Logging out...");
				break;
			default:
				System.out.println("Invalid choice. Please try again.");
			}
		} while (choice != 7);
	}

	public static void userMenu() {
		int choice;
		do {
			System.out.println("User Menu:");
			System.out.println("1. Update Profile");
			System.out.println("2. Delete Account");
			System.out.println("3. Logout");
			System.out.print("Enter your choice: ");
			choice = sc.nextInt();
			sc.nextLine(); // Consume newline left-over

			switch (choice) {
			case 1:
				userService.updateUser();
				break;
			case 2:
				userService.removeUser();
				break;
			case 3:
				System.out.println("Logging out...");
				break;
			default:
				System.out.println("Invalid choice. Please try again.");
			}
		} while (choice != 3);
	}

}
