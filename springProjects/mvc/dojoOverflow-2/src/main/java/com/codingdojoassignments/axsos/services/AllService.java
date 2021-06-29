package com.codingdojoassignments.axsos.services;

import java.util.List;
import java.util.Optional;

import javax.servlet.jsp.tagext.Tag;

import org.springframework.stereotype.Service;

import com.codingdojoassignments.axsos.models.Answer;
import com.codingdojoassignments.axsos.models.Question;
import com.codingdojoassignments.axsos.models.TagQuestion;
import com.codingdojoassignments.axsos.repositories.AnswerRepository;
import com.codingdojoassignments.axsos.repositories.QuestionRepository;
import com.codingdojoassignments.axsos.repositories.TagQuestionRepository;
import com.codingdojoassignments.axsos.repositories.TagRepository;

@Service
public class AllService {
	
		private final QuestionRepository questionRepo;
		private final TagRepository tagRepo;
		private final TagQuestionRepository tagQRepo;
		private final AnswerRepository answerRepo;
		
		public AllService(QuestionRepository questionRepo, TagRepository tagRepo, TagQuestionRepository tagQRepo, AnswerRepository answerRepo) {
			this.questionRepo = questionRepo;
			this.tagRepo = tagRepo;
			this.tagQRepo = tagQRepo;
			this.answerRepo = answerRepo;
		}
		
		public Question saveQuestion(Question question) {
			return questionRepo.save(question);
		}
		
		public Tag saveTag(Tag tag) {
			return tagRepo.save(tag);
		}
		
		public Answer saveAnswer(Answer answer) {
			return answerRepo.save(answer);
		}
		
		public TagQuestion saveTagQuestion(TagQuestion tagQuestion) {
			return tagQRepo.save(tagQuestion);
		}
		
		public Tag findSpecificTagbyName(String name) {
			return tagRepo.findBySubjectIgnoreCase(name);
		}
		
		public List<Question> allQuestions(){
			return questionRepo.findAll();
		}
		
		public Question findQuestionById(Long id) {
			Optional<Question> check = questionRepo.findById(id);
			if(check.isPresent()) {
				return check.get();
			}
			else {
				return null;
			}
		}
		
		public void tagCheckAndSave(List<String> tags, Question question) {
			Question saveQuestion = saveQuestion(question);
			for(String check : tags) {
				if(findSpecificTagbyName(check) != null) {
					TagQuestion combine = new TagQuestion();
					combine.setTag(findSpecificTagbyName(check));
					combine.setQuestion(saveQuestion);
					saveTagQuestion(combine);
				}
				else {
					Tag newTag = new Tag();
					newTag.setSubject(check);
					Tag cTag = saveTag(newTag);
					TagQuestion combine = new TagQuestion();
					combine.setTag(cTag);
					combine.setQuestion(saveQuestion);
					saveTagQuestion(combine);
				}
			}
		}

}
