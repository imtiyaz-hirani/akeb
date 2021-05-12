package com.akeb.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.akeb.model.Webinar;

public interface WebinarRepository extends JpaRepository<Webinar, Long> {

}
