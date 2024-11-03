package com.hexaware.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int uId;

	private String username;

	private String email;

	private String password;

	private String role;

	private boolean isActive;

	private boolean isLoggedIn;

	public User() {
		// TODO Auto-generated constructor stub
	}

	public User(String username, String email, String password, String role) {
		super();

		this.username = username;
		this.email = email;
		this.password = password;
		this.role = role;
		this.isActive = true;
		this.isLoggedIn = false;
	}

	public int getuId() {
		return uId;
	}

	public void setuId(int uId) {
		this.uId = uId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	public boolean isLoggedIn() {
		return isLoggedIn;
	}

	public void setLoggedIn(boolean isLoggedIn) {
		this.isLoggedIn = isLoggedIn;
	}

	@Override
	public String toString() {
		return "User [uId=" + uId + ", username=" + username + ", email=" + email + ", password=" + password + ", role="
				+ role + ", isActive=" + isActive + ", isLoggedIn=" + isLoggedIn + "]";
	}

}
