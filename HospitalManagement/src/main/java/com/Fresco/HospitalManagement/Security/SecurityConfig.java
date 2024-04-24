package com.Fresco.HospitalManagement.Security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import com.Fresco.HospitalManagement.Service.UserDetailsInfo;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
	
	@Autowired
	private Jwtfilter jwtfilter;
	
	 @Bean
	    public WebSecurityCustomizer webSecurityCustomizer() {
	        return (web) -> web.ignoring().requestMatchers(new AntPathRequestMatcher("/h2-console/**"));
	    }
	 
	 @Bean
	 
	 public UserDetailsService userDetailsService() {
		 
		 return new UserDetailsInfo();
		 
	 }
	 
	 @Bean
	 public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		 
		 return http.csrf(x->x.disable())
				 		.authorizeHttpRequests(t-> t.requestMatchers("/register").permitAll()
				 				.requestMatchers("/signin").permitAll()
				 				.requestMatchers("/patients/**").hasAnyRole("USER")
				 				.requestMatchers("/appointment/**").hasAnyRole("USER")
				 				//.requestMatchers("/signin").permitAll()
				 				)
				 		.sessionManagement(sess->sess.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
			 		.authenticationProvider(this.authenticationProvider())
				 	.addFilterBefore(jwtfilter,UsernamePasswordAuthenticationFilter.class)
				 		.build();
		 
	 }
	
	 @Bean
	 
	 public AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception {
		 return config.getAuthenticationManager();
	 }
	 
	 @Bean 
	 public AuthenticationProvider authenticationProvider() {
		 DaoAuthenticationProvider authenticationProvider= new DaoAuthenticationProvider();
		 authenticationProvider.setPasswordEncoder(this.encoder());
		 authenticationProvider.setUserDetailsService(userDetailsService());
		 return authenticationProvider;
	 }
	 
	 @Bean
	 
	 public PasswordEncoder encoder() {
		 return new BCryptPasswordEncoder();
	 }

}
