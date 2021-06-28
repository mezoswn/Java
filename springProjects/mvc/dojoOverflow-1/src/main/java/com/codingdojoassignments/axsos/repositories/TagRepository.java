package com.codingdojoassignments.axsos.repositories;

import java.util.List;
import java.util.Optional;

import javax.servlet.jsp.tagext.Tag;

import org.springframework.data.repository.CrudRepository;

public interface TagRepository extends CrudRepository<Tag, Long>{
	List<Tag> findAll();
	Optional<Tag> findBySubject(String subject);
}
