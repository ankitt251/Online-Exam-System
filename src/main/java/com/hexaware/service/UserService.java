package com.hexaware.service;

import java.util.Scanner;

import com.hexaware.App;
import com.hexaware.dao.UserDao;
import com.hexaware.model.User;

public class UserService {
	private UserDao userDAO = new UserDao();
	private Scanner scanner = new Scanner(System.in);

	public void registerUser() {
		System.out.print("Name: ");
		String name = scanner.nextLine();
		System.out.print("Email: ");
		String email = scanner.nextLine();
		System.out.print("Password: ");
		String password = scanner.nextLine();
		String role = "User";
		User user = new User(name, email, password, role);
		user.setActive(true);
		userDAO.registerUser(user);
		System.out.println("User registered successfully!");

	}

	public void signIn() {
		System.out.print("Email: ");
		String email = scanner.nextLine();
		System.out.print("Password: ");
		String password = scanner.nextLine();
		userDAO.getUser(email);

		User user = userDAO.getUser(email);
		if (user != null && user.getPassword().equals(password) && user.isActive()) {
			userDAO.logoutAllUsers();
			user.setLoggedIn(true);
			userDAO.updateUser(user);
			if ("Admin".equalsIgnoreCase(user.getRole())) {
				System.out.println("Admin login successful! Access granted to admin operations.");
				App.adminMenu();

			} else if ("User".equalsIgnoreCase(user.getRole())) {
				System.out.println("User login successful! Access granted to user operations.");
				App.userMenu();
			} else {
				System.out.println("Unknown role.");
			}
		} else {
			System.out.println("Invalid email or password. Please try again.");
		}

	}

	public void updateUser() {
		System.out.print("Enter your email: ");
		String email = scanner.nextLine();

		User user = userDAO.getUser(email);
		if (user != null && user.isLoggedIn()) {
			System.out.print("Enter new email: ");
			String newEmail = scanner.nextLine();
			System.out.print("Enter new password: ");
			String newPassword = scanner.nextLine();
			user.setEmail(newEmail);
			user.setPassword(newPassword);
			userDAO.updateUser(user);
			System.out.println("Profile updated successfully!");
		} else {
			System.out.println("Please log in first.");
			signIn();
			updateUser();
		}
	}

	public void removeUser() {
		System.out.print("Enter your email to delete your account: ");
		String email = scanner.nextLine();

		User user = userDAO.getUser(email);
		if (user != null && user.isLoggedIn()) {
			userDAO.deleteUser(user);
			System.out.println("User account deleted successfully!");
		} else {
			System.out.println("You must be logged in to delete your account.");
			System.out.println("Please log in first.");
			signIn();
			removeUser();
		}
	}

}
