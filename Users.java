package com.example.myfirst;

public class Users {
	private int id;
	private String username;
	private String password;

	public Users() {
	}

	public Users(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}

	// getters & setters

	public Users(int id, String username, String password) {
		super();
		this.username = username;
		this.password = password;
		this.id = id;
	}

	public String toString() {
		return "Users [id=" + id + ", username=" + username + ", password="
				+ password + "]";
	}

	public int setId(int id) {
		return id = id;
	}

	public String setUsername(String string) {

		return username = username;
	}

	public String setPassword(String string) {

		return password = password;
	}

	public int getId() {
		return id = id;

	}

	public String getUsername() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getPassword() {
		// TODO Auto-generated method stub
		return null;
	}

}
