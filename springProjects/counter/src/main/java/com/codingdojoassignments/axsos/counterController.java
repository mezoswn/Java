package com.codingdojoassignments.axsos;



import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class counterController {
	@RequestMapping("/")
    public String hompage(HttpSession session){
    	//if(session.isNew()){
    		if(session.getAttribute("count")==null) {
    		session.setAttribute("count", 1);
    	}
    	else {
    		
    	Integer count = (Integer) session.getAttribute("count");
    	count++;
    	session.setAttribute("count",count);
    	}
    		if(session.getAttribute("count2")==null) {
        		session.setAttribute("count2", 1);
        	}
        	else {
        		
        	Integer count = (Integer) session.getAttribute("count2");
        	count=count+2;
        	session.setAttribute("count2",count);
        	}
    	return "home.jsp";
    	}

	@RequestMapping("counter")
	public String countPage(HttpSession session) {
		if(session.getAttribute("count") == null) {
			session.setAttribute("count",0);
		}
		return "counter.jsp";
	}
	
	@RequestMapping("counter2")
	public String count2Page(HttpSession session) {
		if(session.getAttribute("count2") == null) {
			session.setAttribute("count2",0);
		}
		return "counter2.jsp";
	}
	@RequestMapping("reset")
	public String reset(HttpSession session) {
		session.setAttribute("count", null);
		session.setAttribute("count2", null);
		return "redirect:/";
	}
	}
