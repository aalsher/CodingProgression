package com.aalsher.grouplanguages.Controllers;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.aalsher.grouplanguages.Models.Language;
import com.aalsher.grouplanguages.Services.LanguageService;

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
	public String findLanguageByIndex(Model model, @PathVariable("id") Long id) {
		model.addAttribute("language", languageService.findLanguageById(id));
		return "viewlanguage.jsp";
	}
	
	@RequestMapping("/languages/edit/{id}")
	public String editLanguage(Model model, @PathVariable("id") Long id) {
	    	Language language = languageService.findLanguageById(id);
	    	if(language != null) {
	    		model.addAttribute("language", language);
	    		return "editlanguage.jsp";
	    	}else {
	    		return "redirect:/";
	    	}
		
	}	
	
	@PostMapping("/languages/edit/{id}")
	public String updateLanguage(@Valid @ModelAttribute("language") Language language, BindingResult result, @PathVariable("id") Long id) {
        if (result.hasErrors()) {
    			return "editlanguage.jsp";
        }else{
        		languageService.updateLanguage(language);
            return "redirect:/";
        }
	}
	
	@PostMapping("/languages/delete/{id}")
	public String deleteLanguage(@PathVariable("id") Long id) {
	    	languageService.deleteLanguage(id);
	        return "redirect:/";
	}
	
}

