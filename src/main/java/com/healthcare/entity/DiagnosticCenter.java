	package com.healthcare.entity;
	
	import java.math.BigInteger;
	import java.util.List;
	
	import jakarta.persistence.CascadeType;
	import jakarta.persistence.Column;
	import jakarta.persistence.Entity;
	import jakarta.persistence.GeneratedValue;
	import jakarta.persistence.GenerationType;
	import jakarta.persistence.Id;
	import jakarta.persistence.JoinColumn;
	import jakarta.persistence.OneToMany;
	import jakarta.persistence.Table;
	
	@Entity
	@Table(name="Diagnostic_Center")
	public class DiagnosticCenter {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="center_id")
	private int centerId;
	@Column(name="center_name")
	private String centerName;
	@Column(name="address")
	private String address;
	@Column(name="contact_no")
	private BigInteger contactno;
	
		@OneToMany(cascade = CascadeType.ALL)
		@JoinColumn(name="center_id")
		private List<Test> listOfTests;
		
		@OneToMany(mappedBy="diagnosticCenter",cascade = CascadeType.ALL)
		private List<Appointment> appointmentList;
			
		@OneToMany(mappedBy ="centerList"  ,cascade = CascadeType.ALL)
	    private List<User> userList;
		
		public DiagnosticCenter(){
			
		}
	
		public DiagnosticCenter(int centerId, String centerName, String address, BigInteger contactno,
				List<Test> listOfTests, List<Appointment> appointmentList, List<User> userList) {
			super();
			this.centerId = centerId;
			this.centerName = centerName;
			this.address = address;
			this.contactno = contactno;
			this.listOfTests = listOfTests;
			this.appointmentList = appointmentList;
			this.userList = userList;
		}
	
		public int getCenterId() {
			return centerId;
		}
	
		public void setCenterId(int centerId) {
			this.centerId = centerId;
		}
	
		public String getCenterName() {
			return centerName;
		}
	
		public void setCenterName(String centerName) {
			this.centerName = centerName;
		}
	
		public String getAddress() {
			return address;
		}
	
		public void setAddress(String address) {
			this.address = address;
		}
	
		public BigInteger getContactno() {
			return contactno;
		}
	
		public void setContactno(BigInteger contactno) {
			this.contactno = contactno;
		}
	
		public List<Test> getListOfTests() {
			return listOfTests;
		}
	
		public void setListOfTests(List<Test> listOfTests) {
			this.listOfTests = listOfTests;
		}
	
		public List<Appointment> getAppointmentList() {
			return appointmentList;
		}
	
		public void setAppointmentList(List<Appointment> appointmentList) {
			this.appointmentList = appointmentList;
		}
	
		public List<User> getUserList() {
			return userList;
		}
	
		public void setUserList(List<User> userList) {
			this.userList = userList;
		}
	}