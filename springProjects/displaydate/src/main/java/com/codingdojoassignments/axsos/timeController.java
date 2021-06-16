package com.codingdojoassignments.axsos;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class timeController {
	@RequestMapping("/time")
	public String time(Model viewModel) {
		Date d = new Date();
		SimpleDateFormat formattedAsTime = new SimpleDateFormat("h:mm a");
		viewModel.addAttribute("theTime", formattedAsTime.format(d));
		return "time.jsp";
	}
}
