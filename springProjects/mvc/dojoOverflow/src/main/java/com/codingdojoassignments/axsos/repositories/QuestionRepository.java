package com.codingdojoassignments.axsos.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojoassignments.axsos.models.Question;

@Repository
public interface QuestionRepository extends CrudRepository<Question, Long>{
	
	List<Question> findAll();

}
