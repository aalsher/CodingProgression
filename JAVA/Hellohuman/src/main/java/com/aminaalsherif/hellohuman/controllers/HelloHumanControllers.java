package com.aminaalsherif.hellohuman.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HelloHumanControllers {
//    @RequestMapping("/")
//    public String index() {
//        return "index.jsp";
//    }

    @RequestMapping("/")
    public String index(Model model, @ModelAttribute("name") String printname, @RequestParam(value="name", required=false) String name) {
    		if(name == null) {
    			return "index.jsp";
    		}else {
        		model.addAttribute("name", name);
        		return "name.jsp";
    		}
    }
    
	@RequestMapping("/goback")
	public String resetAttribute(Model model) {
		model.addAttribute("name",null);
		return "redirect:/";
}
}
