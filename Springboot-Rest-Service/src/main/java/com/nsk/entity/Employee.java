package com.nsk.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Employee {
	@Id
	private int empid;
	private String empname;
	private String password;
	private String email;
	private String address;
	private String salary;
	private String desg;
	public Employee(int empid, String empname, String password, String email, String address, String salary, String desg) {
		super();
		this.empid = empid;
		this.empname = empname;
		this.password = password;
		this.email = email;
		this.address = address;
		this.salary = salary;
		this.desg = desg;
	}
	public Employee() {
		super();
	}
	public int getEmpid() {
		return empid;
	}
	public void setEmpid(int empid) {
		this.empid = empid;
	}
	public String getEmpname() {
		return empname;
	}
	public void setEmpname(String empname) {
		this.empname = empname;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getSalary() {
		return salary;
	}
	public void setSalary(String salary) {
		this.salary = salary;
	}
	public String getDesg() {
		return desg;
	}
	public void setDesg(String desg) {
		this.desg = desg;
	}
	@Override
	public String toString() {
		return "Employee [empid=" + empid + ", empname=" + empname + ", password=" + password + ", email=" + email
				+ ", address=" + address + ", salary=" + salary + ", desg=" + desg + "]";
	}

}
