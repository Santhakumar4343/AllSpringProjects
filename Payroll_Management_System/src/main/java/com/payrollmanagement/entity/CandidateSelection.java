
package com.payrollmanagement.entity;


import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Interview_Process")

	public class CandidateSelection {

		    @Id
		    @GeneratedValue(strategy = GenerationType.IDENTITY)
		    private Long interviewProcessId;
		    
	         
		    @Column(name = "candidateId")
		    private String candidateId;
	        
		    @Column(name = "candidateName" ,nullable=false)
		    private String candidateName;
	         
		    @Column(name = "interviewerId",nullable=false)
		    private String interviewerId;
		   
		    @Column(name = "interviewerName",nullable=false)
		    private String interviewerName;
		    
		    @Column(name = "dateOfInterview",nullable=false)
		    private Date dateOfInterview;

		    @Column(name = "roundone_Status",nullable=false)
		    private String roundOneStatus;
		    
		    @Column(name = "roundtwo_Status")
		    private String roundTwoStatus;
		    
		    @Column(name = "roundthree_Status")
		    private String roundThreeStatus;

		    @Column(name = "roundone_Remarks",nullable=false)
		    private String roundoneRemarks;

		    @Column(name = "roundtwo_Remarks")
		    private String roundtwoRemarks;
		    
		    @Column(name = "roundthree_Remarks")
		    private String roundthreeRemarks;

			public Long getInterviewProcessId() {
				return interviewProcessId;
			}

			public void setInterviewProcessId(Long interviewProcessId) {
				this.interviewProcessId = interviewProcessId;
			}

			public String getCandidateId() {
				return candidateId;
			}

			public void setCandidateId(String candidateId) {
				this.candidateId = candidateId;
			}

			public String getCandidateName() {
				return candidateName;
			}

			public void setCandidateName(String candidateName) {
				this.candidateName = candidateName;
			}

			public String getInterviewerId() {
				return interviewerId;
			}

			public void setInterviewerId(String interviewerId) {
				this.interviewerId = interviewerId;
			}

			public String getInterviewerName() {
				return interviewerName;
			}

			public void setInterviewerName(String interviewerName) {
				this.interviewerName = interviewerName;
			}

			public Date getDateOfInterview() {
				return dateOfInterview;
			}

			public void setDateOfInterview(Date dateOfInterview) {
				this.dateOfInterview = dateOfInterview;
			}

			public String getRoundOneStatus() {
				return roundOneStatus;
			}

			public void setRoundOneStatus(String roundOneStatus) {
				this.roundOneStatus = roundOneStatus;
			}

			public String getRoundTwoStatus() {
				return roundTwoStatus;
			}

			public void setRoundTwoStatus(String roundTwoStatus) {
				this.roundTwoStatus = roundTwoStatus;
			}

			public String getRoundThreeStatus() {
				return roundThreeStatus;
			}

			public void setRoundThreeStatus(String roundThreeStatus) {
				this.roundThreeStatus = roundThreeStatus;
			}

			public String getRoundoneRemarks() {
				return roundoneRemarks;
			}

			public void setRoundoneRemarks(String roundoneRemarks) {
				this.roundoneRemarks = roundoneRemarks;
			}

			public String getRoundtwoRemarks() {
				return roundtwoRemarks;
			}

			public void setRoundtwoRemarks(String roundtwoRemarks) {
				this.roundtwoRemarks = roundtwoRemarks;
			}

			public String getRoundthreeRemarks() {
				return roundthreeRemarks;
			}

			public void setRoundthreeRemarks(String roundthreeRemarks) {
				this.roundthreeRemarks = roundthreeRemarks;
			}

			public CandidateSelection(Long interviewProcessId, String candidateId, String candidateName,
					String interviewerId, String interviewerName, Date dateOfInterview, String roundOneStatus,
					String roundTwoStatus, String roundThreeStatus, String roundoneRemarks, String roundtwoRemarks,
					String roundthreeRemarks) {
				super();
				this.interviewProcessId = interviewProcessId;
				this.candidateId = candidateId;
				this.candidateName = candidateName;
				this.interviewerId = interviewerId;
				this.interviewerName = interviewerName;
				this.dateOfInterview = dateOfInterview;
				this.roundOneStatus = roundOneStatus;
				this.roundTwoStatus = roundTwoStatus;
				this.roundThreeStatus = roundThreeStatus;
				this.roundoneRemarks = roundoneRemarks;
				this.roundtwoRemarks = roundtwoRemarks;
				this.roundthreeRemarks = roundthreeRemarks;
			}
			@Override
			public String toString() {
				return "CandidateSelection [interviewProcessId=" + interviewProcessId + ", candidateId=" + candidateId
						+ ", candidateName=" + candidateName + ", interviewerId=" + interviewerId + ", interviewerName="
						+ interviewerName + ", dateOfInterview=" + dateOfInterview + ", roundOneStatus=" + roundOneStatus
						+ ", roundTwoStatus=" + roundTwoStatus + ", roundThreeStatus=" + roundThreeStatus
						+ ", roundoneRemarks=" + roundoneRemarks + ", roundtwoRemarks=" + roundtwoRemarks
						+ ", roundthreeRemarks=" + roundthreeRemarks + "]";
			}

			public CandidateSelection() {
				super();
				// TODO Auto-generated constructor stub
			}
	    
		}