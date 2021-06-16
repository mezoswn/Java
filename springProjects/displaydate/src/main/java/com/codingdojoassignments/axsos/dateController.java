package com.codingdojoassignments.axsos;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class dateController {
	@RequestMapping("/date")
	public String date(Model viewModel) {
		Date d = new Date();
		SimpleDateFormat formattedAsDate = new SimpleDateFormat("EEEE, 'the' dd 'of' MMMM, YYYY");
		viewModel.addAttribute("theDate", formattedAsDate.format(d));
		return "date.jsp";
	}
}

