package com.example.rest.model;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class UserInfo {
	

	@Id
	private int iduserInfo;
	private String firstName;
	private String lastName;
	private Date time;
	private String password;
	private String role;
	
	
	public UserInfo() {
		
	}
	public UserInfo(int id, String firstName, String lastName, Date time, String password, String role) {
		super();
		this.iduserInfo = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.time = time;
		this.password = password;
		this.role = role;
	}
	public int getId() {
		return iduserInfo;
	}
	public void setId(int id) {
		this.iduserInfo = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public Date getTime() {
		return time;
	}
	public void setTime(Date time) {
		this.time = time;
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
	
	@Override
	public String toString() {
		return "user_info [id=" + iduserInfo + ", firstName=" + firstName + ", lastName=" + lastName + ", time=" + time
				+ ", password=" + password + ", role=" + role + "]";
	}
	

}
