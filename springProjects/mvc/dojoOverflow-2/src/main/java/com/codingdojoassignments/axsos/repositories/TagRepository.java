package com.codingdojoassignments.axsos.repositories;


import javax.servlet.jsp.tagext.Tag;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TagRepository extends CrudRepository<Tag, Long> {
	
	Tag findBySubjectIgnoreCase(String subject);
}
