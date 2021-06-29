package com.codingdojoassignments.axsos.services;

import java.util.List;
import java.util.Optional;

import javax.servlet.jsp.tagext.Tag;

import org.springframework.stereotype.Service;

import com.codingdojoassignments.axsos.repositories.TagRepository;


@Service
public class TagService {
	private static TagRepository tagRepo;

	public TagService(TagRepository tagRepo) {
		TagService.setTagRepo(tagRepo);
	}

	public Tag create(String string) {
		return getTagRepo().save(string);
	}

	public List<Tag> getTags() {
		return (List<Tag>) getTagRepo().findAll();
	}

	public Tag getTag(Long id) {
		Optional<Tag> tag = getTagRepo().findById(id);
		return tag.isPresent() ? tag.get() : null;
	}

	public Tag saveTag(Tag tag) {
		return getTagRepo().save(tag);
	}

	public static TagRepository getTagRepo() {
		return tagRepo;
	}

	public static void setTagRepo(TagRepository tagRepo) {
		TagService.tagRepo = tagRepo;
	}

	public Tag create1(String string) {
		// TODO Auto-generated method stub
		return null;
	}
}
