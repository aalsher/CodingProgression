package com.aalsher.dojosninjas.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.aalsher.dojosninjas.models.Dojo;
import com.aalsher.dojosninjas.models.Ninja;
import com.aalsher.dojosninjas.services.DojoService;
import com.aalsher.dojosninjas.services.NinjaService;

@Controller
public class DojosNinjas {
	
	private final DojoService dojoService;
	private final NinjaService ninjaService;
	
	public DojosNinjas(DojoService dojoService, NinjaService ninjaService) {
		this.dojoService = dojoService;
		this.ninjaService = ninjaService;
	}

	@RequestMapping("/dojos/new")
	public String addDojo(@ModelAttribute("dojo") Dojo dojo, BindingResult result, Model model) {
		return "adddojo.jsp";
	}
	
	@PostMapping("/dojos/new")
	public String createDojos(@Valid @ModelAttribute("dojo") Dojo dojo, BindingResult result, Model model) {
        if (result.hasErrors()) {
    		return "adddojo.jsp";
        }else{
        Dojo savedDojo = dojoService.addDojo(dojo);
    			return "redirect:/dojos/" + savedDojo.getId();
        }
	}
        
    	@RequestMapping("/ninjas/new")
    	public String addNinja(@ModelAttribute("ninja") Ninja ninja, BindingResult result, Model model, @ModelAttribute("dojoList") Dojo dojoList) {
    		model.addAttribute("dojoList", dojoService.getDojos());
    		return "addninja.jsp";
    	}
    	
    	@PostMapping("/ninjas/new")
    	public String createNinjas(@Valid @ModelAttribute("ninja") Ninja ninja, BindingResult result, Model model, @RequestParam("dojo") Long dojo) {
            if (result.hasErrors()) {
        		return "addninja.jsp";
            }else{
            	ninjaService.addNinja(ninja);
            	Dojo selectedDojo = dojoService.findDojoById(dojo);
            	List<Ninja> dojosNinjas = selectedDojo.getNinjas();
            	dojosNinjas.add(ninja);
            	dojoService.addDojo(selectedDojo);
        			return "redirect:/dojos/" + dojo;
            }
    	}
     
    	@RequestMapping("/dojos/{id}")
    	public String findDojoById(Model model, @PathVariable("id") Long id) {
    		Dojo dojo = dojoService.findDojoById(id);
    		model.addAttribute("dojo", dojo);
    		return "viewlocation.jsp";
    	}
     
}
	

