package com.aminaalsherif.thecode.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class HomeControllers {
	 @RequestMapping("/")
	    public String index(@ModelAttribute("errors") String errors) {
		 	System.out.println("errors");
	        	return "index.jsp";
	 }
	 
	 @RequestMapping("/code")
	 public String code(Model model, @RequestParam(value="code") String code, HttpServletRequest request, HttpServletResponse response, RedirectAttributes redirectAttributes) {
		 if(request.getParameter("code").equals("bushido")) {
			 return "Code.jsp";
		 }
		 redirectAttributes.addFlashAttribute("errors", "you must train harder");
		 return "redirect:/";
	 }
	
	 
}