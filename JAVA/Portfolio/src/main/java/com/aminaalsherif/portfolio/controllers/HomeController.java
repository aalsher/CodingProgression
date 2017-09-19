package com.aminaalsherif.portfolio.controllers;

import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;

@Controller
public class HomeController{
	@RequestMapping("/")
	public String index() {
		return "forward:/index.html";
	}
	
	@RequestMapping("/myprojects")
		public String projects() {
			return "forward:/projects.html";
		}
	
	@RequestMapping("/aboutme")
		public String me() {
			return "forward:/me.html";
		}
}
