package com.codingdojoassignments.axsos;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class codeController {
	@RequestMapping("/")
	public String indexPage() {
		return "index.jsp";
	}
	
	@RequestMapping(value="/code", method=RequestMethod.POST)
	public String trying(@RequestParam(value="try") String tryCode) {
		if(tryCode.equals("bushido")) {
			return "code.jsp";
		}
		return "redirect:/createError";
	}
	
	@RequestMapping("/createError")
	public String flashMessages(RedirectAttributes redirectAttributes) {
		redirectAttributes.addFlashAttribute("error", "You must train harder!!");
		return "redirect:/";
	}

}
