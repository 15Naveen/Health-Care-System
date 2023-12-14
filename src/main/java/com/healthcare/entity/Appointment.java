	package com.healthcare.entity;
	
	import java.math.BigInteger;
	import java.sql.Date;
	import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
	import jakarta.persistence.Entity;
	import jakarta.persistence.GeneratedValue;
	import jakarta.persistence.GenerationType;
	import jakarta.persistence.Id;
	import jakarta.persistence.JoinColumn;
	import jakarta.persistence.ManyToOne;
	import jakarta.persistence.OneToMany;
	import jakarta.persistence.OneToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
	
	@Entity
	@Table(name = "Appointment")
	public class Appointment {
	
		@Id
		//@GeneratedValue(strategy = GenerationType.IDENTITY)
		@SequenceGenerator(name="test_sequence1",sequenceName = "test_sequence1",allocationSize = 1)
		@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "test_sequence1")
		@Column(name = "appointment_id")
		private BigInteger appointmentId;
		@Column(name = "date_time")
		private Date dateTime;
		/*
		 * @Column(name = "approved") private boolean approved=false;
		 */
	
	
		@OneToMany(cascade =CascadeType.ALL, orphanRemoval = true)//(mappedBy = "appointment", cascade = CascadeType.ALL)
		@JoinColumn(name="appointment_id")
		private List<Test> listOfTest;
		
		@ManyToOne
		@JoinColumn(name="center_id")
		DiagnosticCenter diagnosticCenter;
			
		@OneToOne
		@JoinColumn(name = "user_id")
		private User user;
		
		public Appointment() {
	
		}
	
		public Appointment(BigInteger appointmentId, Date dateTime, boolean approved) {
			this.appointmentId = appointmentId;
			this.dateTime = dateTime;
			//this.approved = approved;
		}
	
		public BigInteger getAppointmentId() {
			return appointmentId;
		}
	
		public void setAppointmentId(BigInteger appointmentId) {
			this.appointmentId = appointmentId;
		}
	
		public Date getDateTime() {
			return dateTime;
		}
	
		public void setDateTime(Date dateTime) {
			this.dateTime = dateTime;
		}
	
		/*
		 * public boolean isApproved() { return approved; }
		 * 
		 * public void setApproved(boolean approved) { this.approved = approved; }
		 */
	
		public List<Test> getListOfTest() {
			return listOfTest;
		}
	
		public void setListOfTest(List<Test> listOfTest) {
			this.listOfTest = listOfTest;
		}
	
		public DiagnosticCenter getDiagnosticCenter() {
			return diagnosticCenter;
		}
	
		public void setDiagnosticCenter(DiagnosticCenter diagnosticCenter) {
			this.diagnosticCenter = diagnosticCenter;
		}
	
		public User getUser() {
			return user;
		}
	
		public void setUser(User user) {
			this.user = user;
		}
	
		
	}