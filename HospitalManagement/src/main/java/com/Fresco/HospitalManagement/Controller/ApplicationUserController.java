package com.Fresco.HospitalManagement.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.Fresco.HospitalManagement.Model.ApplicationUser;
import com.Fresco.HospitalManagement.Security.JwtUtil;
import com.Fresco.HospitalManagement.Service.ApplicationUserService;

@RestController
public class ApplicationUserController {
	
		@Autowired
		private ApplicationUserService applicationUserService;
		
		@Autowired
		private AuthenticationManager authenticationManager;
		
		@Autowired
		private JwtUtil jwtUtil;

		@PostMapping("register")
		
		public ApplicationUser register(@RequestBody ApplicationUser user){
		
			return applicationUserService.userreg(user);
		}
		
		@PostMapping("signin")
		
		public String signin(@RequestBody ApplicationUser applicationUser) {
			
			Authentication auth=authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(applicationUser.getUser_email(), applicationUser.getPassword()));
			System.out.print(auth);
			if(auth.isAuthenticated()) {
				
				return jwtUtil.generateToken(applicationUser.getUser_email());
			}
			else {
				System.out.println("blahhh");
				throw new UsernameNotFoundException("not found user");
			}
			
		}
}
