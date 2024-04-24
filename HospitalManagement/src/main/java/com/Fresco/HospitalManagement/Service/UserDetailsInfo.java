package com.Fresco.HospitalManagement.Service;

import java.util.Optional;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.Fresco.HospitalManagement.Model.ApplicationUser;
import com.Fresco.HospitalManagement.Repository.ApplicationUserRepository;

@Service
public class UserDetailsInfo implements UserDetailsService {

	@Autowired
	private ApplicationUserRepository applicationUserRepository;
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		
		Optional<ApplicationUser> user =applicationUserRepository.findByuseremail(username);

		
		
		
		return user.map(userDetails::new).orElseThrow(() ->  new UsernameNotFoundException("user not found"));
		
	}

}
