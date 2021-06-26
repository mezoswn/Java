package com.codingdojoassignments.axsos.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.codingdojoassignments.axsos.models.Question;
import com.codingdojoassignments.axsos.repositories.QuestionRepository;

@Service
public class QuestionService {
	
	
	private final QuestionRepository questionRepository;
	
	
	
	public QuestionService(QuestionRepository questionRepository) {
		this.questionRepository = questionRepository;
	}
	
	
	
	public Question createQuestion(Question question) {
		return questionRepository.save(question);
	}
	
	
	
	public Question findQ(Long id) {
		Optional<Question> myQuestion = questionRepository.findById(id);
		if (myQuestion.isPresent()) {
			return myQuestion.get();
		}else {
			return null;
		}
	}
	
	
	public List<Question> findAll(){
		return questionRepository.findAll();
	}

}
