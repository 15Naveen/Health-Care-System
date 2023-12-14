package com.healthcare.entity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name="Test")
public class Test {
	@Id
	//@GeneratedValue(strategy = GenerationType.AUTO)
	@SequenceGenerator(name="test_sequence101",sequenceName = "test_sequence101",allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "test_sequence101")
	@Column(name="test_id")
	private int testId;
	@Column(name="test_name")
	private String testName;
			
	  @ManyToOne
	  @JoinColumn(name = "center_id")
	  DiagnosticCenter diagnosticCenter;
	  
		/*
		 * @ManyToOne
		 * 
		 * @JoinColumn(name = "appointment_id") Appointment appointment;
		 */
	 
	public Test()
	{
	}

	public Test(int testId, String testName) {
		this.testId = testId;
		this.testName = testName;
	}

	public int getTestId() {
		return testId;
	}

	public void setTestId(int testId) {
		this.testId = testId;
	}

	public String getTestName() {
		return testName;
	}

	public void setTestName(String testName) {
		this.testName = testName;
	}

	
	  public DiagnosticCenter getDiagnosticCenter() 
	  {
		  return diagnosticCenter; 
	  }
	  
	  public void setDiagnosticCenter(DiagnosticCenter diagnosticCenter)
	  {
	  this.diagnosticCenter = diagnosticCenter; 
	  }
	  
		/*
		 * public Appointment getAppointment() { return appointment; }
		 * 
		 * public void setAppointment(Appointment appointment) { this.appointment
		 * =appointment; }
		 */
	 
}