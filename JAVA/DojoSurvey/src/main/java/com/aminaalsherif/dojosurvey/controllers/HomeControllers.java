package com.aminaalsherif.dojosurvey.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeControllers {

    @RequestMapping("/")
    public String index() {
        		return "index.jsp";
    }
    
    @RequestMapping(path="/result", method= RequestMethod.POST)
    public String result(Model model, @RequestParam(value="name") String name, @RequestParam(value="dojolocation") String dojolocation, @RequestParam(value="favoritelanguage") String favoritelanguage, @RequestParam(value="comment") String comment) {
    		model.addAttribute("name", name );
		model.addAttribute("dojolocation", dojolocation);
		model.addAttribute("favoritelangauge", favoritelanguage);
		model.addAttribute("comment", comment);
    		
    		return "result.jsp";
    }
    
	@RequestMapping("/goback")
	public String resetAttribute(Model model) {
		model.addAttribute("name", null );
		model.addAttribute("dojolocation", null);
		model.addAttribute("favoritelangauge", null);
		model.addAttribute("comment", null);
		
		return "redirect:/";
	}
}

