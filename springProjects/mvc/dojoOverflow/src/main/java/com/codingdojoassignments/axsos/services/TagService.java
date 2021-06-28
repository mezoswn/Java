package com.codingdojoassignments.axsos.services;

import java.util.ArrayList;

import javax.servlet.jsp.tagext.Tag;

import org.springframework.stereotype.Service;

import com.codingdojoassignments.axsos.repositories.TagRepository;


@Service
public class TagService {
    private final TagRepository tagrepo;

    public TagService(TagRepository tagrepo) {
        this.tagrepo = tagrepo;
    }

    public ArrayList<Tag> findAllTags() {
        return (ArrayList<Tag>) tagrepo.findAll();
    }

    public Tag createTag(String tag) {

        return tagrepo.save(new String(tag)); //for new one

    }
}
