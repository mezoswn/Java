package com.codingdojoassignments.axsos.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.codingdojoassignments.axsos.models.Language;
import com.codingdojoassignments.axsos.services.LanguageServices;


@Controller
public class LanguageController {
    private final LanguageServices languageService ;

     public LanguageController(LanguageServices languageService){
         this.languageService=languageService;
     }
     @RequestMapping("")
     public String index(Model model,@ModelAttribute("language") Language language){
         List<Language> allLanguages=languageService.allLanguauges();
         model.addAttribute("allLanguages",allLanguages);
         return "index.jsp";
     }
     @RequestMapping(value="/languages", method= RequestMethod.POST)
     public String create(@Valid @ModelAttribute("language") Language lang, BindingResult result , Model model) {
         if (result.hasErrors()) {
        	 List<Language> allLanguages=languageService.allLanguauges();
             model.addAttribute("allLanguages",allLanguages);
             return "index.jsp";
         }
         else {
        	 System.out.println("create");
        	 languageService.createLanguage(lang);
             return "redirect:/";
         }
     }




@RequestMapping(value="/languages/{id}" , method=RequestMethod.DELETE)
public String destroy(@PathVariable("id") Long id) {
	languageService.deleteLanguage(id);
   return "redirect:/";
}

@RequestMapping(value="languages/edit/{id}")
public String showEditForm(@PathVariable("id") Long id , Model model){
 Language lang=  languageService.findlanguage(id);
   model.addAttribute("language", lang);
   return "edit.jsp";

}
@RequestMapping(value="/languages/{id}", method=RequestMethod.PUT)
public String update(@Valid @ModelAttribute("language") Language language, BindingResult result) {
   if (result.hasErrors()) {
       return "edit.jsp";
   } else {
	   languageService.updateLanguage(language);
       return "redirect:/";
   }
}
@RequestMapping(value="/languages/{id}", method=RequestMethod.GET)
public String showLanguage(@PathVariable("id") Long id, Model model){
    Language language=languageService.findlanguage(id);
    model.addAttribute("language",language);
    return "info.jsp";
}

}
