package com.Fresco.HospitalManagement.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Fresco.HospitalManagement.Model.Appointment;
import com.Fresco.HospitalManagement.Model.Patient;
import com.Fresco.HospitalManagement.Repository.AppointmentRepository;
import com.Fresco.HospitalManagement.Repository.PatientRepository;

@Service
public class AppointmentService {
	
	@Autowired
	private AppointmentRepository appointmentRepository;
	
	public List<Appointment> getAll(){
		return appointmentRepository.findAll();
	}
	
	public Appointment getById(String id) {
		return appointmentRepository.findById(id).get();
	}
	
	public void deleteById(String id) {
		 appointmentRepository.deleteById(id);
	}
	
	public Appointment getByPatientId(int pid) {
		
		return appointmentRepository.findBypatientId(pid);
		
	}
	public Appointment savepatient(Appointment ap) {
		
		return  appointmentRepository.save(ap);
	}
	

}
