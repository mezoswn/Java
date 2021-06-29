package com.codingdojoassignments.axsos.controllers;

import java.util.Arrays;
import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.codingdojoassignments.axsos.models.Answer;
import com.codingdojoassignments.axsos.models.Question;

@Controller
public class MainController {
	

		private final MainController mainController;

		public MainController(MainController mainController) {

			this.mainController = mainController;
		}

		@GetMapping("/")
		public String notHere() {
			return "redirect:/questions";
		}

		@GetMapping("/questions")
		public String index(Model model) {
			model.addAttribute("questions", mainController.allQuestions());
			return "index.jsp";
		}

		@GetMapping("/questions/new")
		public String newQuestion(@ModelAttribute("addQuestion") Question question) {
			return "addQuestion.jsp";
		}

		@PostMapping("/questions/new")
		public String addQuestion(@RequestParam("other") String tags,
				@Valid @ModelAttribute("addQuestion") Question question, BindingResult result, RedirectAttributes rA) {
			List<String> tagString = Arrays.asList(tags.split(","));
			mainController.tagCheckAndSave(tagString, question);
			return "redirect:/";

		}

		@GetMapping("/questions/{questionId}")
		public String showQuestion(@ModelAttribute("addTheAnswer") Answer answer, @PathVariable("questionId") Long id,
				Model model) {
			model.addAttribute("question", mainController.findQuestionById(id));
			return "showQuestion.jsp";
		}

		@PostMapping("/questions/{questionId}")
		public String addAnswerToQuestion(@Valid @ModelAttribute("addTheAnswer") Answer answer, BindingResult result,
				@PathVariable("questionId") Long id, Model model) {
			if (result.hasErrors()) {
				model.addAttribute("question", mainController.findQuestionById(id));
				return "showQuestion.jsp";
			} else {
				answer.setQuestion(mainController.findQuestionById(id));
				mainController.saveAnswer(answer);
				return "redirect:/questions/" + id;
			}
		}

}
