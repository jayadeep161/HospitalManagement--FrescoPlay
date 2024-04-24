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

import com.Fresco.HospitalManagement.Model.Appointment;
import com.Fresco.HospitalManagement.Service.AppointmentService;

@RestController
public class AppointmentController {
	
	@Autowired
	private AppointmentService appointmentService;
	
	@PostMapping("appointment/register")
	
	public ResponseEntity<String> register(@RequestBody Appointment app){
		
		if(app==null) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("\"Booking failure\"");
		}
		else {
			appointmentService.savepatient(app);
			return ResponseEntity.ok("\"Booking successful\"");
		}
		
	}
	@GetMapping("appointment/list")
	
	public List<Appointment> getAll(){
		return appointmentService.getAll();
	}
	
	@GetMapping("/appointment/view/{appointmentId}")
	
	public Appointment getById(@PathVariable("appointmentId") String aid) {
		return appointmentService.getById(aid);
	}
	
	@GetMapping("/appointment/list/{patientid}")
	public Appointment getByPatientId(@PathVariable("patientid") int  pid) {
		return appointmentService.getByPatientId(pid);
	}
	
	@PutMapping("/appointment/delete/{appointmentId}")
	public void deleteById(@PathVariable("appointmentId") String aid) {
		 appointmentService.deleteById(aid);
	}

}
