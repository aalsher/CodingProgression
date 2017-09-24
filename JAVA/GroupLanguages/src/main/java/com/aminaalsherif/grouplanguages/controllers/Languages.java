package com.aminaalsherif.grouplanguages.controllers;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.aminaalsherif.grouplangauges.models.Language;
import com.aminaalsherif.grouplanguages.services.LanguageService;

@Controller
public class Languages {
	private final LanguageService languageService;
	
	public Languages(LanguageService languageService) {
		this.languageService = languageService;
	}
	
	@RequestMapping("/")
	public String index(@ModelAttribute("language") Language language, Model model) {
		model.addAttribute("languages", languageService.getLanguages());
		return "index.jsp";
	}
	
	@PostMapping("/languages")
	public String createLanguages(@Valid @ModelAttribute("language") Language language, BindingResult result, Model model) {
        if (result.hasErrors()) {
        	model.addAttribute("languages", languageService.getLanguages());
    		return "index.jsp";
        }else{
        	languageService.addLanguage(language);
            return "redirect:/";
        }
	}
	
	@RequestMapping("/languages/{id}")
	public String showLanguage(Model model, @PathVariable("id") int id) {
    	Language lang = languageService.getLanguage(id);
    	model.addAttribute("id", id);
    	model.addAttribute("language", lang);
		return "viewlanguage.jsp";
	}
	
	@RequestMapping("/languages/edit/{id}")
	public String editLanguage(Model model, @PathVariable("id") int id) {
    	Language lang = languageService.getLanguage(id);
    	model.addAttribute("id", id);
    	model.addAttribute("language", lang);
		return "editlanguage.jsp";
	}	
	
	@PostMapping("/languages/update/{id}")
	public String updateLanguage(@Valid @ModelAttribute("language") Language language, BindingResult result, @PathVariable("id") int id) {
        if (result.hasErrors()) {
    		return "editlanguage.jsp";
        }else{
        	languageService.updateLanguage(id, language);
            return "redirect:/";
        }
	}
	
	@RequestMapping("/languages/delete/{id}")
	public String deleteLanguage(@PathVariable("id") int id) {
    	languageService.deleteLanguage(id);
        return "redirect:/";
	}
}

