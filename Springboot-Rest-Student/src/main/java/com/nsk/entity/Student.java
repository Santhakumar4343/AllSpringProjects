package com.nsk.entity;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Student {
@Id
@Column(name="id")

	 private int stdid;
@Column(name="name")
	 private String stdname;
	 private String course;
	 private double fee;
	public Student(int stdid, String stdname, String course, double fee) {
		super();
		this.stdid = stdid;
		this.stdname = stdname;
		this.course = course;
		this.fee = fee;
	}
	public int getStdid() {
		return stdid;
	}
	public void setStdid(int stdid) {
		this.stdid = stdid;
	}
	public String getStdname() {
		return stdname;
	}
	public void setStdname(String stdname) {
		this.stdname = stdname;
	}
	public String getCourse() {
		return course;
	}
	public void setCourse(String course) {
		this.course = course;
	}
	public double getFee() {
		return fee;
	}
	public void setFee(double fee) {
		this.fee = fee;
	}
	public Student() {
		super();
	}
	@Override
	public String toString() {
		return "Student [stdid=" + stdid + ", stdname=" + stdname + ", course=" + course + ", fee=" + fee + "]";
	}
	 
}
