package com.Fresco.HospitalManagement.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.Fresco.HospitalManagement.Model.Patient;
import com.Fresco.HospitalManagement.Service.PatientService;


@RestController
public class PatientController {
	
	@Autowired
	private PatientService patientService;
	
	@PostMapping("patients/register")
	
	public ResponseEntity<String> savepatient(@RequestBody Patient p){
		
		if(p==null) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Registration failure");
		}
		else{
			patientService.savepatient(p);
			return ResponseEntity.ok("Registration successful");
		}
		
	}
	
	@GetMapping("patients/list/")
	public List<Patient> getAll(){
		return patientService.getAll();
	}
	
	@GetMapping("patients/view/{Id}")
	public Patient getPatientById(@PathVariable("Id") int id) {
		return patientService.getPatientById(id);
	}
	
	@PutMapping("patients/delete/{Id}")
	
	public void deletePatientById(@PathVariable("Id") int id) {
		 patientService.deletePatientById(id);
	}
	
	
}
