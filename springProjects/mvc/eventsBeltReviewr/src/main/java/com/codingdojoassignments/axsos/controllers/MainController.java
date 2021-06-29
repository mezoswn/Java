package com.codingdojoassignments.axsos.controllers;

import java.util.Collections;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.codingdojoassignments.axsos.models.User;
import com.codingdojoassignments.axsos.models.Comment;
import com.codingdojoassignments.axsos.models.Event;
import com.codingdojoassignments.axsos.services.MainService;
import com.codingdojoassignments.axsos.services.UserService;
import com.codingdojoassignments.axsos.validator.UserValidator;


@Controller
public class MainController {
    String star = String.join("", Collections.nCopies(25, "*"));
	private final UserService userService;
	private final UserValidator userValidator;
	private final MainService mainService;
	public  String[] states = {"AK", "AL", "AR", "AZ", "CA", "CO", "CT", "DC","DE", "FL", "GA", "HI", "IA", "ID", "IL", "IN", "KS", "KY", "LA",  "MA", "MD", "ME", "MI", "MN", "MO", "MS", "MT", "NC", "ND", "NE","NH", "NJ", "NM", "NV", "NY", "OH", "OK", "OR", "PA", "RI", "SC",  "SD", "TN", "TX", "UT", "VA", "VT", "WA", "WI", "WV", "WY"};
	public MainController(UserService userService, UserValidator userValidator, MainService mainService) {
		this.userService = userService;
		this.userValidator = userValidator;
		this.mainService = mainService;
	}
	
	@RequestMapping(value= {"/","/createevent"})
	public String index(HttpSession session, @ModelAttribute("event") Event event, Model model) {
		if(session.getAttribute("userid")==null) {
			return "redirect:/registration";
		}
		User current_user = userService.findUserById((Long) session.getAttribute("userid"));
			model.addAttribute("user", current_user);
			model.addAttribute("eventsjoined", mainService.findJoinedEventsByUserId(current_user.getId()));
			model.addAttribute("instate", mainService.findAllEventsInUserState(current_user.getState()));
			model.addAttribute("outofstate", mainService.findAllEventsOutOfState(current_user.getState()));		
			model.addAttribute("states",states);
		return "index";
	}
	@RequestMapping("/login")
	public String login() {
		return "login";
	}
	@RequestMapping("/registration")
	public String registration(@ModelAttribute("user") User user, Model model, HttpSession session) {
		System.out.println(session.getAttribute("userid"));
		if(session.getAttribute("userid")!=null) {
			return "redirect:/";
		}
		model.addAttribute("states",states);
		return "registration";
	}
	@RequestMapping("/events/edit/{id}")
	public String edit(@PathVariable("id")Long id, Model model, HttpSession session ) {		
		Event event = mainService.findEventById(id);
		Long userid = (Long) session.getAttribute("userid");
		System.out.println(star);
		if( userid==null ||event==null || event.getOwner().getId().longValue() != userid) {		
			return "redirect:/";
		}
		
		System.out.println("event is "  +  event.getId());
		System.out.println("event owner is "  +  event.getOwner().getId());
		System.out.println("user is "  +  userid);
			model.addAttribute("event", event);
			model.addAttribute("eventid", id);
			model.addAttribute("states",states);		
		return "edit";
	}
	
//show event	
	@RequestMapping("/events/{id}")
	public String show(@PathVariable("id")Long id, Model model ,@ModelAttribute("comment") Comment comment) {		
		model.addAttribute("event", mainService.findEventById(id));			
		return "showevent";
	}
	
// ~~~~~~~~~ OPERATIONS ~~~~~~~~~~~~//
	
    @RequestMapping(value="/registration", method=RequestMethod.POST)
	public String registerUser(@Valid @ModelAttribute("user")User user, BindingResult result, HttpSession session) {
    	userValidator.validate(user, result);
		if(result.hasErrors()) {
			return "registration";
		}
		userService.registerUser(user);
		session.setAttribute("user", user);		
		session.setAttribute("userid", user.getId());
				System.out.println("registration done!");
		return "redirect:/";
	}
    
    @RequestMapping("/logout")
    public String logout(HttpSession session) {
    	session.invalidate();
    	return "redirect:/registration";
    }
    
    @RequestMapping(value="/login", method=RequestMethod.POST)
    public String loginUser(@RequestParam("email") String email, @RequestParam("password") String password , HttpSession session , Model model) {
    	if(userService.authenticateUser(email, password)) {
    		User user = userService.findUserByEmail(email);
    		System.out.println("set sesssion user as "+ user.getFirst_name() +" "+user + " UserID :" + user.getId());
    		session.setAttribute("user", user);
    		session.setAttribute("userid", user.getId());
    		return "redirect:/";
    	}
			model.addAttribute("error" , "Invalid email or password");
			model.addAttribute("user" , new User());
			model.addAttribute("states",states);
		return "/registration";    	
    }
//  create event
    @RequestMapping(value="/createevent", method=RequestMethod.POST)
    public String createEvent(HttpSession session, @Valid @ModelAttribute("event")Event event, BindingResult result, Model model) {
		if(result.hasErrors()) {
			System.out.println("errors found...escaping");
			User current_user = userService.findUserById((Long) session.getAttribute("userid"));
				model.addAttribute("user", current_user);
				model.addAttribute("eventsjoined", mainService.findJoinedEventsByUserId(current_user.getId()));
				model.addAttribute("instate", mainService.findAllEventsInUserState(current_user.getState()));
				model.addAttribute("outofstate", mainService.findAllEventsOutOfState(current_user.getState()));		
				model.addAttribute("states",states);
			return "index";
		}
		Event newevent = mainService.createEvent(event);
		return "redirect:/events/"+newevent.getId();    	
    }
    
//	delete event    
    @RequestMapping(value="/events/delete/{id}")
    public String deleteEvent(HttpSession session, @PathVariable("id") Long id) {    	
    	User current_user = (User) session.getAttribute("user");
    	Event target = mainService.findEventById(id);
    	if(current_user == null || target == null) 
    	{
    		return "redirect:/";
    	}
    	boolean isOwner = current_user.getId()==target.getOwner().getId();
    	if(isOwner==true) 
    	{
    		mainService.deleteEvent(target);
    	}
    	return "redirect:/";
    }    		
    
//    edit event(put)
    @RequestMapping(value="/events/edit/{id}", method=RequestMethod.PUT)
    public String editEvent(HttpSession session, @PathVariable("id") Long id , @Valid @ModelAttribute("event") Event event, BindingResult result) {    	
			if (result.hasErrors()) {
					return "edit";
			}
    	Long userid = (Long) session.getAttribute("userid");
    	Long ownerid= mainService.findEventById(id).getOwner().getId();
	    	if(userid == null || ownerid ==null) {
	    		return "redirect:/";
	    	}
    	boolean isOwner =  mainService.isOwner(userid, ownerid);
	    	if(isOwner==true) 
	    	{
	    		mainService.editEvent(event);
	    	}
	    		return "redirect:/events/edit/"+ id;   	
    }
// 	Join event
    @RequestMapping(value= "/events/{eventid}/join")
    public String joinEvent(HttpSession session, @PathVariable("eventid") Long eventid) {
    	Long userid = (Long) session.getAttribute("userid");
    	User user = userService.findUserById(userid);
    	mainService.joinEvent(eventid, user);
    	return "redirect:/";
    }
//  Leave event  
    @RequestMapping(value="/events/{eventid}/cancel")
    public String leaveEvent(HttpSession session, @PathVariable("eventid") Long eventid) {
    	Long userid = (Long) session.getAttribute("userid");
    	User user = userService.findUserById(userid);
    	mainService.leaveEvent(eventid, user);
    	return "redirect:/";
    }
//  Create Comment
    @RequestMapping(value="/events/{eventid}/addcomment", method = RequestMethod.POST)
    public String createComment(@PathVariable("eventid") Long eventid, HttpSession session, @Valid @ModelAttribute("comment")Comment comment, BindingResult result, Model model) {
    	System.out.println("hit route correctly");
    	if (result.hasErrors()) {
    		return "showevent";
    	}
    	User author = userService.findUserById((Long) session.getAttribute("userid"));    	
    	System.out.println("creating");
    	mainService.createComment(eventid, author, comment);
    	System.out.println("created comment!");
    	return "redirect:/events/"+ eventid;
    }

}
