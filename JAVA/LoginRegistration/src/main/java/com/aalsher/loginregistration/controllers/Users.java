package com.aalsher.loginregistration.controllers;

import java.security.Principal;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.aalsher.loginregistration.models.User;
import com.aalsher.loginregistration.services.UserService;
import com.aalsher.loginregistration.validations.UserValidator;


@Controller
public class Users {
	private UserService userService;
    private UserValidator userValidator;
    
    public Users(UserService userService, UserValidator userValidator) {
        this.userService = userService;
        this.userValidator = userValidator;
    }
    
    @RequestMapping("/")
    public String index() {
    		return "redirect:/login";
    }
    
    @RequestMapping(value= {"/login", "/register"})
    public String loginregistration(@Valid @ModelAttribute("user") User user, @RequestParam(value="error", required=false) String error, @RequestParam(value="logout", required=false) String logout, Model model) {
    		if(error != null) {
                model.addAttribute("errorMessage", "Invalid Credentials, Please try again.");
            }
        if(logout != null) {
                model.addAttribute("logoutMessage", "Logout Successfull!");
                System.out.println("going to index");
    		}
    		return "loginandregistration.jsp";
   }
	
	@PostMapping("/register")
	public String register(@Valid @ModelAttribute("user") User user, BindingResult result, Model model) {
	    userValidator.validate(user, result);
	    if (result.hasErrors()) {
	    		System.out.println(result.getAllErrors());
	        return "loginandregistration.jsp";
	    }else {
	    		userService.saveUser(user);
	    		return "redirect:/login";
	    }
	}
	
	@RequestMapping("/dashboard")
	public String displayUser(Principal principal, Model model) {
		String username = principal.getName();
		model.addAttribute("currentUser", userService.findByUsername(username));
		return "dashboard.jsp";
	}
	
}



