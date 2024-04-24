package com.Fresco.HospitalManagement.Model;







import java.util.Date;

import org.hibernate.annotations.GenericGenerator;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="Patient")

public class Patient {

	@Id
	private int patient_Id;
    private String patient_name;
    private String patient_email;
    private String patient_mobile;
    private Date Registered_date;

	public Date getRegistered_date() {
		return Registered_date;
	}
	public void setRegistered_date(Date registered_date) {
		Registered_date = registered_date;
	}
	Patient(){
		
	}
	public Patient(int patient_Id, String patient_name, String patient_email, String patient_mobile,
			Date registered_date) {
		super();
		this.patient_Id = patient_Id;
		this.patient_name = patient_name;
		this.patient_email = patient_email;
		this.patient_mobile = patient_mobile;
		Registered_date = registered_date;
		//this.Role=Role;
	}
	
		public int getPatient_Id() {
		return patient_Id;
	}
	public void setPatient_Id(int patient_Id) {
		this.patient_Id = patient_Id;
	}
	public String getPatient_name() {
		return patient_name;
	}
	public void setPatient_name(String patient_name) {
		this.patient_name = patient_name;
	}
	public String getPatient_email() {
		return patient_email;
	}
	public void setPatient_email(String patient_email) {
		this.patient_email = patient_email;
	}
	public String getPatient_mobile() {
		return patient_mobile;
	}
	public void setPatient_mobile(String patient_mobile) {
		this.patient_mobile = patient_mobile;
	}
    
    


}
