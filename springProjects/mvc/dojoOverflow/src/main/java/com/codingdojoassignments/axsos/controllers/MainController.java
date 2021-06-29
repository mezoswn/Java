package com.codingdojoassignments.axsos.controllers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.jsp.tagext.Tag;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.codingdojoassignments.axsos.models.Answer;
import com.codingdojoassignments.axsos.models.Question;
import com.codingdojoassignments.axsos.services.AnswerService;
import com.codingdojoassignments.axsos.services.QuestionService;
import com.codingdojoassignments.axsos.services.TagService;

@Controller
public class MainController {

	
	private final QuestionService questionService;
	private final TagService tagService;
	private final AnswerService answerService;
	
	

	public MainController(QuestionService questionService, TagService tagService, AnswerService answerService ) {
		this.questionService=questionService;
		this.tagService=tagService;
		this.answerService=answerService;
	}
	
	
	
	@RequestMapping("/")
	public String index() {
		return "index.jsp";
	}
	
	
	
	@RequestMapping("/dashboard")
	public String dashboard(Model model) {
		List<Question> myQuestionList = questionService.findAll();
		model.addAttribute("questions", myQuestionList);
		return "show.jsp";
	}
	
	
	
	@RequestMapping("/questions/new")
	public String newQuestion(@ModelAttribute("addQuestion") Question question) {
		return "newQuestion.jsp";
	}
	
	
	
	@RequestMapping("/questions/new")
	public String createQuestion(@Valid @ModelAttribute("addQuestion") Question question, BindingResult result, @RequestParam("myTag") String myTag, RedirectAttributes flash) {
		
		
		int numComma = myTag.replaceAll("[^,]", "").length();
		if (numComma>2) {
			flash.addFlashAttribute("errors", "You can add 3 tags at the most.");
		}
		
			
		if (!myTag.equals(myTag.toLowerCase())) {
			flash.addFlashAttribute("errors", "must be all lower case");
		}

		if (flash.getFlashAttributes().size()>0) {
			return "redirect:/questions/new";
		} else if(result.hasErrors()){	
			
			return "newQuestion.jsp";
		} else {
			
			Question myQuestion = questionService.createQuestion(question);
			
			
			List<String> items = (List<String>)Arrays.asList(myTag.trim().split("\\s*,\\s*"));
			
			
			ArrayList<Tag> tags = new ArrayList<Tag>();
			for(int i=0;i<items.size();i++) {
				tags.add(tagService.create(items.get(i)));
			}
			
			
			myQuestion.setTags(tags);
			
			
			questionService.createQuestion(myQuestion);
			
			return "redirect:/dashboard";
		}
	}
	
	
	
	@RequestMapping("/questions/{id}")
	public String show(@ModelAttribute("ans") Answer answer, @PathVariable("id") Long id, Model model) {
		Question myQuestion = questionService.findQ(id);
		model.addAttribute("myquestion", myQuestion);
		model.addAttribute("myTags", myQuestion.getTags());
		model.addAttribute("answers", myQuestion.getAnswers());
		return "showQuestion.jsp";
	}
	
	
	
	@RequestMapping(value="/questions/new", method=RequestMethod.POST) 
    public String createQuestion(@Valid @ModelAttribute("addQuestion")Question question, BindingResult result, @RequestParam("myTag")String myTag) {

        //question can't be empty  , have errors
        if(result.hasErrors()) {
            return "redirect:/questions/new";
        }else {

            //create question here
            Question myQu = questionService.createQuestion(question);

            //here we split each tag from a string input and add it to list
            List<String> items = (List<String>)Arrays.asList(myTag.trim().split("\s,\s"));
            System.out.println(items);

            //create tags array list
            ArrayList<Tag> tags = new ArrayList<Tag>();
            for(int i=0;i<items.size();i++) {
                tags.add(tagService.create(items.get(i)));
                System.out.println("show : "+   items.get(i));
            }

            // set tags to question
            myQu.setTags(tags);
            //update myQ  , save it in createQuestion
            questionService.createQuestion(myQu);

            return "redirect:/questions/new";
        }

    }



	public AnswerService getAnswerService() {
		return answerService;
	}

}
