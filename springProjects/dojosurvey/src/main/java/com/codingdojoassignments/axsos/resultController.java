package com.codingdojoassignments.axsos;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class resultController {
	@RequestMapping("/")
	public String homePage(HttpSession session) {
		session.setAttribute("name", null);
		session.setAttribute("location", null);
		session.setAttribute("language", null);
		session.setAttribute("comment", null);
		
		return "index.jsp";
	}
	

	@RequestMapping(value="/info", method=RequestMethod.POST)
	public String data(@RequestParam(value="name") String name, @RequestParam(value="location") String location ,  @RequestParam(value="lang") String lang , @RequestParam(value="comment" , required=false) String comment , HttpSession session ) {
		
			if(session.getAttribute("name") == null) {
			session.setAttribute("name", name);
			session.setAttribute("location", location);
			session.setAttribute("lang", lang);
			if(comment != null) {
			session.setAttribute("comment", comment);
			}
			
			}
			return "redirect:/result";
	}
			
	
	
	
	@RequestMapping(value="/result")
	public String resultPage() {
		return "result.jsp";
	}

}
