package com.payrollmanagement.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "login_Credentials")
public class Login {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(nullable =false,name="emp_Id")
	private int empId;
	@Column(nullable =false,name="personal_Email")
	private String personalEmail;
	@Column(nullable = false, unique=true, name="official_Email")
	private String officialEmail;
	@Column(name="official_Mail_Password")
	private String officialMailPassword;

	/*
	 * @NotEmpty(message = "Old password is required") private String oldPassword;
	 * 
	 * @NotEmpty(message = "New password is required")
	 * 
	 * @Size(min = 6, message = "New password must be at least 6 characters long")
	 * private String newPassword;
	 * 
	 * @NotEmpty(message = "Confirm password is required")
	 * 
	 * @Size(min = 6, message =
	 * "Confirm password must be at least 6 characters long") private String
	 * confirmPassword;
	 */

	
	

	public Login() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public String getPersonalEmail() {
		return personalEmail;
	}

	public void setPersonalEmail(String personalEmail) {
		this.personalEmail = personalEmail;
	}

	public String getOfficialEmail() {
		return officialEmail;
	}

	public void setOfficialEmail(String officialEmail) {
		this.officialEmail = officialEmail;
	}

	public String getOfficialMailPassword() {
		return officialMailPassword;
	}

	public void setOfficialMailPassword(String officialMailPassword) {
		this.officialMailPassword = officialMailPassword;
	}

	public Login(int id, int empId, String personalEmail, String officialEmail, String officialMailPassword) {
		super();
		this.id = id;
		this.empId = empId;
		this.personalEmail = personalEmail;
		this.officialEmail = officialEmail;
		this.officialMailPassword = officialMailPassword;
	}

}
