package com.aminaalsherif.counter.controllers;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("hitNumber")
public class HomeController {
	@ModelAttribute("hitNumber")
	public int getHitNumber() {
		return 0;
	}
	
	@RequestMapping("/")
    public String index(Model model, @ModelAttribute("hitNumber") int hitNumber, HttpSession session) {
    		//get session if it exists
    		if(session.getAttribute("hitNumber") == null) {
    			session.setAttribute("hitNumber", 1);
    		} else {
    			int newCounter = hitNumber + 1;
    			model.addAttribute("hitNumber", newCounter);
    		}
    		//store the value with session object
 
    		return "index.jsp";
    }
	
	@RequestMapping("/counter")
		public String counters(@ModelAttribute("hitNumber") int hitNumber, HttpServletRequest request, HttpServletResponse response, Model model) {
			return "counter.jsp";
		}
	
	@RequestMapping("/reset")
		public String resetAttribute(Model model) {
			model.addAttribute("hitNumber",0);
			return "redirect:/";
	}

}