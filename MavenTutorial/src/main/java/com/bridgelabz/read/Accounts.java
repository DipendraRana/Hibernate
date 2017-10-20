package com.bridgelabz.read;

public class Accounts {
	private int id;
	private String username;
	private String password;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id=id;
	}
	public String getUserName() {
		return username;
	}
	public void setUserName(String username) {
		this.username=username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password=password;
	}
	
	@Override
	public String toString() {
		return "Account [username="+username+", id="+id+"]";
	}
}
