package com.aminaalsherif.learningplatform.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;


//"/m/{chapter}/0483/{assignmentNumber}"

@Controller

public class HomeControllers {
	 @RequestMapping("/")
	    public String index() {	
	        	return "index.jsp";
	 }
	 
	 @RequestMapping(value = "/m/{chapter}/0553/{assignmentNumber}")
	 public String lessonDirect(@PathVariable String chapter, @PathVariable String assignmentNumber, Model model, @ModelAttribute("type") String type) {
//		 type = "Lesson";
		 model.addAttribute("type", "Fortran Advanced Lesson Placeholder");
		 return "Lesson.jsp";  
	 }
	 @RequestMapping(value = "/m/{chapter}/0483/{assignmentNumber}")
	 public String assignmentDirect(@PathVariable String chapter, @PathVariable String assignmentNumber, Model model, @ModelAttribute("type") String type) {
//		 type = "Assignment";
		 model.addAttribute("type", "The goal of this assignment is to...");
		 return "Assignment.jsp";  
	 }
	 
}