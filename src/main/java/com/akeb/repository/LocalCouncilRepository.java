package com.akeb.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.akeb.model.LocalCouncil;

public interface LocalCouncilRepository extends JpaRepository<LocalCouncil, Long>{

	@Query("select l from LocalCouncil l join l.regionalCouncil r where r.id=?1")
	List<LocalCouncil> findByRegionalCouncil(Long rid);

	 

}
