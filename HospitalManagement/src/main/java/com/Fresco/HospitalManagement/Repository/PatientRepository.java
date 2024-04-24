package com.Fresco.HospitalManagement.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Fresco.HospitalManagement.Model.Patient;

@Repository
public interface PatientRepository extends JpaRepository<Patient,Integer> {

}
