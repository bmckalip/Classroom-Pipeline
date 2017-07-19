package com.revature.models;

import java.io.Serializable;

public class User implements Serializable {
	
	//static serial UID
	private static final long serialVersionUID = -5520922063552900929L;

	//private state
	private int u_id;
	private int u_role_id;
	private String u_username;	
	private String u_password;
	private String u_email;
	private String u_fname;
	private String u_lname;
	
	//no-args constructor
	public User() {
		super();
	}
	
	//constructor with only username and password fields
	public User(String u_username, String u_password) {
		super();
		this.u_username = u_username;
		this.u_password = u_password;
	}
	
	//constructor using all fields except id
	public User(int u_role_id, String u_username, String u_password, String u_email, String u_fname,
			String u_lname) {
		super();
		this.u_role_id = u_role_id;
		this.u_username = u_username;
		this.u_password = u_password;
		this.u_email = u_email;
		this.u_fname = u_fname;
		this.u_lname = u_lname;
	}
	
	//constructor using all fields
	public User(int u_id, int u_role_id, String u_username, String u_password, String u_email, String u_fname,
			String u_lname) {
		super();
		this.u_id = u_id;
		this.u_role_id = u_role_id;
		this.u_username = u_username;
		this.u_password = u_password;
		this.u_email = u_email;
		this.u_fname = u_fname;
		this.u_lname = u_lname;
	}
	
	//to string
	@Override
	public String toString() {
		return "User [u_id=" + u_id + ", u_role_id=" + u_role_id + ", u_username=" + u_username + ", u_password="
				+ u_password + ", u_email=" + u_email + ", u_fname=" + u_fname + ", u_lname=" + u_lname + "]";
	}

	//getters and setters
	public int getU_id() {
		return u_id;
	}

	public void setU_id(int u_id) {
		this.u_id = u_id;
	}

	public int getU_role_id() {
		return u_role_id;
	}

	public void setU_role_id(int u_role_id) {
		this.u_role_id = u_role_id;
	}

	public String getU_email() {
		return u_email;
	}

	public void setU_email(String u_email) {
		this.u_email = u_email;
	}

	public String getU_password() {
		return u_password;
	}

	public void setU_password(String u_password) {
		this.u_password = u_password;
	}
	
	public String getU_username() {
		return u_username;
	}

	public void setU_username(String u_username) {
		this.u_username = u_username;
	}
	
	public String getU_fname() {
		return u_fname;
	}

	public void setU_fname(String u_fname) {
		this.u_fname = u_fname;
	}

	public String getU_lname() {
		return u_lname;
	}

	public void setU_lname(String u_lname) {
		this.u_lname = u_lname;
	}
	
}
