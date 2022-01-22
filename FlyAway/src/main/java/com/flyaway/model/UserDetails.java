package com.flyaway.model;

import javax.persistence.*;

@Entity
public class UserDetails {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
	@Column(name="UserId")
	private int id;
	@Column(name="UserName")
	private String userName;
	@Column(name="Age")
	private String age;
	@Column(name="PhNo")
	private long phNo;
	@Column(insertable=false)
	private String isAdmin;
	@Column(name="Password")
	private String password;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public long getPhNo() {
		return phNo;
	}
	public void setPhNo(long phNo) {
		this.phNo = phNo;
	}
	
	public String isAdmin() {
		return isAdmin;
	}
	public void setAdmin(String isAdmin) {
		this.isAdmin = isAdmin;
	}
	
	public String getIsAdmin() {
		return isAdmin;
	}
	public void setIsAdmin(String isAdmin) {
		this.isAdmin = isAdmin;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public UserDetails() {
		super();
	}
	
	

}
