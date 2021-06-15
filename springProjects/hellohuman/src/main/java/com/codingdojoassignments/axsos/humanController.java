package com.codingdojoassignments.axsos;

//import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
@RequestMapping
public class humanController {
    @RequestMapping("/")
    public String index(@RequestParam(value="name", required=false) String Name , @RequestParam(value="lname", required=false) String lName) {
    	if(Name == null) {
    		return "Hello Human!";
    	}
    	else if (Name.length() > 0) { 
    	if (lName == null) {
    	    return Name +" "+ "Welcome!";
    	} if (lName.length()>0) {
    		return " Hello " + Name + " " + lName;
    		}
    	}
    	return "Hello Human!";
    	}
    }

