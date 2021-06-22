package com.codingdojoassignments.axsos.repositories;


import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojoassignments.axsos.models.Language;

@Repository
public interface LanguageRepositories extends CrudRepository <Language, Long> {
	
	    List<Language> findAll();
	    
}
