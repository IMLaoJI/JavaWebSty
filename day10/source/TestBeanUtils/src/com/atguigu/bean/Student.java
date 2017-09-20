package com.atguigu.bean;

public class Student {

	private String name1;
	private int age;
	private String address;

	public String getName() {
		return name1;
	}

	public void setName1(String name) {
		this.name1 = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Student(String name, int age, String address) {
		super();
		this.name1 = name;
		this.age = age;
		this.address = address;
	}

	@Override
	public String toString() {
		return "Student [name=" + name1 + ", age=" + age + ", address="
				+ address + "]";
	}

}
