package com.atguigu.bean;

public class Student {

	private String name;
	private String gender;
	private String address;

	@Override
	public String toString() {
		return "Student [name=" + name + ", gender=" + gender + ", address="
				+ address + "]";
	}

	public Student(String name, String gender, String address) {
		super();
		this.name = name;
		this.gender = gender;
		this.address = address;
	}

	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

}
