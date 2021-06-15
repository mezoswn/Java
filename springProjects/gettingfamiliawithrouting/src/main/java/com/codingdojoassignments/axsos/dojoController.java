package com.codingdojoassignments.axsos;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;

//..
@RestController
@RequestMapping("/dojo")
public class dojoController {
	@RequestMapping("")
	public String hello() {
        return "The dojo is awesome!";
	}

    @RequestMapping("/{msg}")
    public String showMsg(@PathVariable("msg") String msg){
    	if (msg.equals("burbank-dojo"))
    			return "Burbank Dojo is located in Southern California";
    	
    	if (msg.equals("san-jose"))
    			return "SJ dojo is the headquarters";
    	return null;
    }
}