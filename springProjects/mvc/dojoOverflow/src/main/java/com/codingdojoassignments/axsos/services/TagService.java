package com.codingdojoassignments.axsos.services;

import java.util.ArrayList;

import javax.servlet.jsp.tagext.Tag;

import org.springframework.stereotype.Service;

import com.codingdojoassignments.axsos.repositories.TagRepository;

@Service
public class TagService {
	
	
	private final TagRepository tagRepository;
	
	
	
	public TagService(TagRepository tagRepository) {
		this.tagRepository = tagRepository;
	}
	
	
	
	public Tag createTag(String tag) {
		Tag myTag = new Tag();
		myTag.setSubject(tag);
		return tagRepository.save(myTag);
		
	}
	
	
	public ArrayList<Tag> findAllTags() {
		return (ArrayList<Tag>) tagRepository.findAll();
	}

}
