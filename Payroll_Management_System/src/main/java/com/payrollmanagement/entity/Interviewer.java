package com.payrollmanagement.entity;

import java.sql.Date;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Interviewer {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
 	private long id;
	
	
 	private String candidateid;  
    private String candidatename;
    private Date date;    
    private String interviewername;
   
    private String interviewerid;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getCandidateid() {
		return candidateid;
	}

	public void setCandidateid(String candidateid) {
		this.candidateid = candidateid;
	}

	public String getCandidatename() {
		return candidatename;
	}

	public void setCandidatename(String candidatename) {
		this.candidatename = candidatename;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getInterviewername() {
		return interviewername;
	}

	public void setInterviewername(String interviewername) {
		this.interviewername = interviewername;
	}

	public String getInterviewerid() {
		return interviewerid;
	}

	public void setInterviewerid(String interviewerid) {
		this.interviewerid = interviewerid;
	}

	public Interviewer(long id, String candidateid, String candidatename, Date date, String interviewername,
			String interviewerid) {
		super();
		this.id = id;
		this.candidateid = candidateid;
		this.candidatename = candidatename;
		this.date = date;
		this.interviewername = interviewername;
		this.interviewerid = interviewerid;
	}

	@Override
	public String toString() {
		return "Interviewer [id=" + id + ", candidateid=" + candidateid + ", candidatename=" + candidatename + ", date="
				+ date + ", interviewername=" + interviewername + ", interviewerid=" + interviewerid + "]";
	}

	public Interviewer() {
		super();
		// TODO Auto-generated constructor stub
	}
  
    
    
    
    
}



