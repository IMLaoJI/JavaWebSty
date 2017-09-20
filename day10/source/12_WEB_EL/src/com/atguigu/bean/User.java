package com.atguigu.bean;

public class User {

	private String username;
	private String gender;
	private int age;
	
	private Address address;
	
	

	public String getUsername() {
		
		System.out.println("GET方法被调用了");
		
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "User [username=" + username + ", gender=" + gender + ", age="
				+ age + "]";
	}

	public User(String username, String gender, int age) {
		super();
		this.username = username;
		this.gender = gender;
		this.age = age;
	}

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

}
