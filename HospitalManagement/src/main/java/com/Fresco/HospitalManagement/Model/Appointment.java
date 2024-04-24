package com.Fresco.HospitalManagement.Model;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Appointment {
	
	Appointment(){
		
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	 private String booking_id;
	    private String disease;
	    private Date tentativeDate;
		private String priority;
	    private int patientId;
	    private Date bookingTime; 
	  
		public String getBooking_id() {
			return booking_id;
		}
		public void setBooking_id(String booking_id) {
			this.booking_id = booking_id;
		}
		public String getDisease() {
			return disease;
		}
		public void setDisease(String disease) {
			this.disease = disease;
		}
		public Date getTentativeDate() {
			return tentativeDate;
		}
		public void setTentativeDate(Date tentativeDate) {
			this.tentativeDate = tentativeDate;
		}
		public String getPriority() {
			return priority;
		}
		public void setPriority(String priority) {
			this.priority = priority;
		}
		public int getPatientId() {
			return patientId;
		}
		public void setPatientId(int patientId) {
			this.patientId = patientId;
		}
		public Date getBookingTime() {
			return bookingTime;
		}
		public void setBookingTime(Date bookingTime) {
			this.bookingTime = bookingTime;
		}
	
	    public Appointment(String disease, Date tentativeDate, String priority, int patientId, Date bookingTime) {
			super();
			this.disease = disease;
			this.tentativeDate = tentativeDate;
			this.priority = priority;
			this.patientId = patientId;
			this.bookingTime = bookingTime;
		}
		


}
