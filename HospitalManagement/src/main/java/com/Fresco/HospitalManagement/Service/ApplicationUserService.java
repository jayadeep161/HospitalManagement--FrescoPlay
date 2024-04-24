package com.Fresco.HospitalManagement.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.Fresco.HospitalManagement.Model.ApplicationUser;
import com.Fresco.HospitalManagement.Repository.ApplicationUserRepository;

@Service
public class ApplicationUserService {
	
	@Autowired
	private ApplicationUserRepository applicationUserRepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	public ApplicationUser userreg(ApplicationUser applicationUser) {
		
		applicationUser.setPassword(passwordEncoder.encode(applicationUser.getPassword()));
		
		return applicationUserRepository.save(applicationUser);
		
	}

}
