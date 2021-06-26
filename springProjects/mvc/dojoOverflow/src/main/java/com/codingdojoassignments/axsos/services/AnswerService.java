package com.codingdojoassignments.axsos.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.codingdojoassignments.axsos.models.Answer;
import com.codingdojoassignments.axsos.repositories.AnswerRepository;

@Service
public class AnswerService {
	
private final AnswerRepository answerRepository;
	
	
	public AnswerService(AnswerRepository answerRepository) {
		this.answerRepository = answerRepository;
	}
	
	
	
	public Answer createAns(Answer answer) {
		return answerRepository.save(answer);
	}
	
	
	public List<Answer> getAll() {
		return answerRepository.findAll();
	}

}
