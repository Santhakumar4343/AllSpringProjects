package com.payrollmanagement.entity;

import java.sql.Date;
import java.util.Arrays;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "AddEmployeeDetails")
public class AddEmployee {

	@Id
//	@GeneratedValue(strategy = GenerationType.AUTO)

	@Column(name = "emp_Id")
	private String empId;

	@OneToOne
	@JoinColumn(name = "candidate_Id", referencedColumnName = "candidate_Id")
	private AddCandidate candidateId;

	@Column(name = "accountHolder_Name")
	private String accountHolderName;

	@Column(name = "account_Number")
	private String accountNumber;

	@Column(name = "bank_Name")
	private String bankName;

	@Column(name = "ifsc_Code")
	private String ifscCode;

	@Column(name = "pan_Card")
	private String panCard;

	@Column(name = "blood_Group")
	private String bloodGroup;

	@Column(name = "nominee")
	private String nominee;

	@Column(name = "nominee_Contact")
	private String nomineeContact;

	@Lob
	@Column(name = "offer_Letter")
	private byte[] offerLetter;

	@Lob
	@Column(name = "joining_Letter")
	private byte[] joiningLetter;

	@Lob
	@Column(name = "agreement")
	private byte[] agreement;

	@Lob
	@Column(name = "experience_Letter")
	private byte[] experienceLetter;

	@Lob
	@Column(name = "photo")
	private byte[] photo;

	@Column(name = "branch")
	private String branch;

	@Column(name = "joining_Date")
	private Date joiningDate;

	public AddEmployee() {
		super();
	}

	public AddEmployee(String empId, AddCandidate candidateId, String accountHolderName, String accountNumber,
			String bankName, String ifscCode, String panCard, String bloodGroup, String nominee, String nomineeContact,
			byte[] offerLetter, byte[] joiningLetter, byte[] agreement, byte[] experienceLetter, byte[] photo,
			String branch, Date joiningDate) {
		super();
		this.empId = empId;
		this.candidateId = candidateId;
		this.accountHolderName = accountHolderName;
		this.accountNumber = accountNumber;
		this.bankName = bankName;
		this.ifscCode = ifscCode;
		this.panCard = panCard;
		this.bloodGroup = bloodGroup;
		this.nominee = nominee;
		this.nomineeContact = nomineeContact;
		this.offerLetter = offerLetter;
		this.joiningLetter = joiningLetter;
		this.agreement = agreement;
		this.experienceLetter = experienceLetter;
		this.photo = photo;
		this.branch = branch;
		this.joiningDate = joiningDate;
	}

	public String getEmpId() {
		return empId;
	}

	public void setEmpId(String empId) {
		this.empId = empId;
	}

	public AddCandidate getCandidateId() {
		return candidateId;
	}

	public void setCandidateId(AddCandidate candidateId) {
		this.candidateId = candidateId;
	}

	public String getAccountHolderName() {
		return accountHolderName;
	}

	public void setAccountHolderName(String accountHolderName) {
		this.accountHolderName = accountHolderName;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	public String getIfscCode() {
		return ifscCode;
	}

	public void setIfscCode(String ifscCode) {
		this.ifscCode = ifscCode;
	}

	public String getPanCard() {
		return panCard;
	}

	public void setPanCard(String panCard) {
		this.panCard = panCard;
	}

	public String getBloodGroup() {
		return bloodGroup;
	}

	public void setBloodGroup(String bloodGroup) {
		this.bloodGroup = bloodGroup;
	}

	public String getNominee() {
		return nominee;
	}

	public void setNominee(String nominee) {
		this.nominee = nominee;
	}

	public String getNomineeContact() {
		return nomineeContact;
	}

	public void setNomineeContact(String nomineeContact) {
		this.nomineeContact = nomineeContact;
	}

	public byte[] getOfferLetter() {
		return offerLetter;
	}

	public void setOfferLetter(byte[] offerLetter) {
		this.offerLetter = offerLetter;
	}

	public byte[] getJoiningLetter() {
		return joiningLetter;
	}

	public void setJoiningLetter(byte[] joiningLetter) {
		this.joiningLetter = joiningLetter;
	}

	public byte[] getAgreement() {
		return agreement;
	}

	public void setAgreement(byte[] agreement) {
		this.agreement = agreement;
	}

	public byte[] getExperienceLetter() {
		return experienceLetter;
	}

	public void setExperienceLetter(byte[] experienceLetter) {
		this.experienceLetter = experienceLetter;
	}

	public byte[] getPhoto() {
		return photo;
	}

	public void setPhoto(byte[] photo) {
		this.photo = photo;
	}

	public String getBranch() {
		return branch;
	}

	public void setBranch(String branch) {
		this.branch = branch;
	}

	public Date getJoiningDate() {
		return joiningDate;
	}

	public void setJoiningDate(Date joiningDate) {
		this.joiningDate = joiningDate;
	}

	@Override
	public String toString() {
		return "AddEmployee [empId=" + empId + ", candidateId=" + candidateId + ", accountHolderName="
				+ accountHolderName + ", accountNumber=" + accountNumber + ", bankName=" + bankName + ", ifscCode="
				+ ifscCode + ", panCard=" + panCard + ", bloodGroup=" + bloodGroup + ", nominee=" + nominee
				+ ", nomineeContact=" + nomineeContact + ", offerLetter=" + Arrays.toString(offerLetter)
				+ ", joiningLetter=" + Arrays.toString(joiningLetter) + ", agreement=" + Arrays.toString(agreement)
				+ ", experienceLetter=" + Arrays.toString(experienceLetter) + ", photo=" + Arrays.toString(photo)
				+ ", branch=" + branch + ", joiningDate=" + joiningDate + "]";
	}

}
