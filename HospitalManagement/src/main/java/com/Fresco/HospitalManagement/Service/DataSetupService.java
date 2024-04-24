package com.Fresco.HospitalManagement.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;

import com.Fresco.HospitalManagement.Model.Patient;
import com.Fresco.HospitalManagement.Repository.PatientRepository;

public class DataSetupService implements CommandLineRunner {
	@Autowired
	private PatientRepository patientRepository;
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		this.insertInitialData();
	}
	private void insertInitialData() {
        // Insert patients into the database
		System.out.print("srgsergbvesgvesg");
       
        
        // Add more patient insertions as needed
    }

}
