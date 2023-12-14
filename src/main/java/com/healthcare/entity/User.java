package com.healthcare.entity;

import java.math.BigInteger;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="person")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="user_id")
	private String userId;
	@Column(name="user_name")
	private String userName;
	@Column(name="user_password")
	private String userPassword;
	@Column(name="contact_no")
	private BigInteger contactNo;
	@Column(name="email_id")
	private String emailId;
	@Column(name="user_role")
	private String userRole;
	
	 @ManyToOne
	 @JoinColumn(name = "center_id")
	 // Name of the foreign key column in the DiagnosticCenter table
	 private DiagnosticCenter centerList;
	
	 @OneToOne(mappedBy="user")
	 private Appointment appointment;
	
	public User()
	{
		
	}
	public Appointment getAppointment() {
		return appointment;
	}

	public void setAppointment(Appointment appointment) {
		this.appointment = appointment;
	}

	public User(String userId, String userName, String userPassword, BigInteger contactNo, String emailId,
			String userRole) {
		this.userId = userId;
		this.userName = userName;
		this.userPassword = userPassword;
		this.contactNo = contactNo;
		this.emailId = emailId;
		this.userRole = userRole;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public BigInteger getContactNo() {
		return contactNo;
	}

	public void setContactNo(BigInteger contactNo) {
		this.contactNo = contactNo;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getUserRole() {
		return userRole;
	}

	public void setUserRole(String userRole) {
		this.userRole = userRole;
	}
	public DiagnosticCenter getCenterList() {
		return centerList;
	}
	public void setCenterList(DiagnosticCenter centerList) {
		this.centerList = centerList;
	}
}


/*
 * @OneToMany DiagnosticCenter DiagnosticCenter;
 * 
 * 
 * //@OneToMany(mappedBy = "") // // public Appointment getAppointment() { //
 * return appointment; // } // // public void setAppointment(Appointment
 * appointment) { // this.appointment = appointment; // }
 * //(mappedBy="appointment_id")
	//@JoinColumn(name="appointment_id")
 */