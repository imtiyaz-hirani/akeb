package com.akeb;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.akeb.model.AKEBUser;

public interface AKEBUserRepository extends JpaRepository<AKEBUser, Long> {

	AKEBUser findByEmail(String email);

	@Query("select u from AKEBUser u where u.email=?1")
	AKEBUser findByEmailAddress(String email);

}
