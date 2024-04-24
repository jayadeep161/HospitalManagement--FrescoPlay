package com.Fresco.HospitalManagement.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Fresco.HospitalManagement.Model.Patient;
import com.Fresco.HospitalManagement.Repository.PatientRepository;

@Service
public class PatientService {
	
	@Autowired
	private PatientRepository patientRepository;
	
	public List<Patient> getAll(){
		return patientRepository.findAll();
	}
	
	public Patient getPatientById(int id) {
		return patientRepository.findById(id).get();
	}
	
	public void deletePatientById(int id) {
		 patientRepository.deleteById(id);
	}
	
	public Patient savepatient(Patient p) {
		
		return  patientRepository.save(p);
	}

}
