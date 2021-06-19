package com.codingdojoassignments.axsos;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
@Controller
public class ninjaController {
	ArrayList <String> activities = new ArrayList<String>();
	
	@RequestMapping ("/")
	public String index(HttpSession session) {
		if(session.getAttribute("total")== null) {
			session.setAttribute("total", 0);
		}
		if(session.getAttribute("active")== null) {
			session.setAttribute("active", "");
	}
		return "index.jsp";
	}
	
	@RequestMapping(value="/process_money", method=RequestMethod.POST)
	public String process(@RequestParam(value="gold") String money, HttpSession session) {
		if(session.getAttribute("total")==null) {
			session.setAttribute("total",0);
			session.setAttribute("gold",0);
		}
		if(session.getAttribute("active")==null) {
			session.setAttribute("active",activities);
		}
		Random r = new Random();
		int gold;
		
		Date date = new Date();
		SimpleDateFormat date1 = new SimpleDateFormat("EEEE, MMMM dd YYYY hh:mm:ss a");
		String date2 = date1.format(date);
		
		if(money.equals("farm")) {
			gold = r.nextInt(10)+10;
			session.setAttribute("total", +(gold + (int) session.getAttribute("total")));
			String s = "You entere the farm and earned " + Integer.toString(gold) +" at " + date2;
			activities.add(s);
			session.setAttribute("gold", gold);
			session.setAttribute("active", activities);
		}
		
		if(money.equals("cave")) {
			gold = r.nextInt(5)+5 ;
			session.setAttribute("total", +(gold + (int) session.getAttribute("total")));
			
			String s = "You entere the cave and earned " + Integer.toString(gold) +" at " + date2;
			activities.add(s);
			session.setAttribute("gold", gold);
			session.setAttribute("active", activities);
		}
		
		if(money.equals("house")) {
			gold = r.nextInt(3)+2 ;
			session.setAttribute("total", +(gold+ (int) session.getAttribute("total")));
			
			String s = "You entered the house and earned " + Integer.toString(gold) +" at " + date2;
			activities.add(s);
			session.setAttribute("gold", gold);
			session.setAttribute("active", activities);
		}
		
		if(money.equals("casino")) {
			gold = r.nextInt(100)-50 ;
			session.setAttribute("total", +(gold + (int) session.getAttribute("total")));
			session.setAttribute("gold", gold);
			if(gold >= 0) {
						
				String s = "You entere the casino and earned " + Integer.toString(gold) +" at " + date2;
				activities.add(s);
			}
			else{
				gold *= 1;
//				session.setAttribute("gold", gold);
				String s = "You entere the casino and lost " + Integer.toString(gold)  +" at " + date2;
				activities.add(s);
			}
			//session.setAttribute("total", (gold + (int) session.getAttribute("total")));
			session.setAttribute("active", activities);
		}
		return "redirect:/";
	}
	
	@RequestMapping("/clear")
	public String reset(HttpSession session) {
		session.removeAttribute("total");
		session.removeAttribute("active");
		activities.clear();
		return "redirect:/";
		
	}
		
}
	
	
