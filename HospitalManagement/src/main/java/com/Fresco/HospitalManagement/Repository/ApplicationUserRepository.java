package com.Fresco.HospitalManagement.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.Fresco.HospitalManagement.Model.ApplicationUser;
@Repository
public interface ApplicationUserRepository extends JpaRepository<ApplicationUser,String> {

//	 Optional<ApplicationUser> findByUserEmail(String userEmail);
//
//	Optional<ApplicationUser> findByuser_email(String username);

//	Optional<ApplicationUser> findByuseremail(String username);
//
//	Optional<ApplicationUser> findByuserEmail(String username);

	@Query("select x from ApplicationUser x where x.user_email like :username")
	Optional<ApplicationUser> findByuseremail(String username);

	

	

	

}
