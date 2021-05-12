package com.akeb.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.akeb.model.Question;

public interface QuestionRepository extends JpaRepository<Question, Long>{

}
