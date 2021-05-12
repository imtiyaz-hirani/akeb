package com.akeb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.akeb.model.Register;

public interface RegisterRepository extends JpaRepository<Register, Long>{

	@Query("select r from Register r join r.user u join r.webinar w where u.email=?1 and w.id=?2")
	Register checkIfAlreadyRegistered(String email, Long id);

}
