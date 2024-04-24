package com.Fresco.HospitalManagement.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Fresco.HospitalManagement.Model.Appointment;

@Repository
public interface AppointmentRepository  extends JpaRepository<Appointment, String>{

	Appointment findBypatientId(int pid);

}
