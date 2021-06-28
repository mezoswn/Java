package com.codingdojoassignments.axsos.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.codingdojoassignments.axsos.models.User;
import com.codingdojoassignments.axsos.services.UserService;

@Controller
public class UserController {
    private final UserService userService;
    
    public UserController(UserService userService) {
        this.userService = userService;
    }
    
    @RequestMapping("/registration")
    public String registerForm(@ModelAttribute("user") User user) {
        return "registrationPage.jsp";
    }
    @RequestMapping("/login")
    public String login() {
        return "loginPage.jsp";
    }
    @RequestMapping(value= {"/home","/","/index"})
    public String home(HttpSession session, Model model) {
	// get user from session, save them in the model and return the home page
    	if(session.getAttribute("user")==null) {
    		return "redirect:/registration";
    	}
		model.addAttribute("user",session.getAttribute("user"));
				System.out.println("model is holding : "+ session.getAttribute("user"));
		return "index.jsp";    	
    }
    @RequestMapping("/logout")
    public String logout(HttpSession session) {
	// invalidate session
    			session.invalidate();
	// redirect to login page
				return "redirect:/login";
    }
    
    @RequestMapping(value="/registration", method=RequestMethod.POST)
    public String registerUser(@Valid @ModelAttribute("user") User user, BindingResult result, HttpSession session) {
        // if result has errors, return the registration page (don't worry about validations just now)
		    	if (result.hasErrors()) {
		    		return "registrationPage.jsp";
		    	}
    	// else, save the user in the database, save the user id in session, and redirect them to the /home route
		    	userService.registerUser(user);
		    	session.setAttribute("user", user);
	    		return "redirect:home";
    }
    
    @RequestMapping(value="/login", method=RequestMethod.POST)
    public String loginUser(@RequestParam("email") String email, @RequestParam("password") String password, Model model, HttpSession session) {
        // if the user is authenticated, save their user id in session
    			if(userService.authenticateUser(email, password)) {
    				session.setAttribute("user", userService.findByEmail(email));
    				return "redirect:/";
    			}
		// else, add error messages and return the login page
				model.addAttribute("error" , "Invalid email or password");
				return "login";
    }
	

}
