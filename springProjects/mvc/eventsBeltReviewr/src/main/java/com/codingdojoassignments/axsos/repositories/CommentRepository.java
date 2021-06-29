package com.codingdojoassignments.axsos.repositories;



import org.springframework.data.repository.CrudRepository;

import com.codingdojoassignments.axsos.models.Comment;

public interface CommentRepository extends CrudRepository<Comment, Long>{

}
