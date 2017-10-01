package com.aalsher.admindashboard.controllers;
import java.security.Principal;
import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.aalsher.admindashboard.models.Role;
import com.aalsher.admindashboard.models.User;
import com.aalsher.admindashboard.services.RoleService;
import com.aalsher.admindashboard.services.UserService;
import com.aalsher.admindashboard.validations.UserValidator;

@Controller
public class UserController {
	private UserService userService;
	@Autowired
	private RoleService roleService;
	private UserValidator userValidator;
	
	public UserController(UserService userService,RoleService roleService,UserValidator userValidator){
		this.userService = userService;
		this.roleService = roleService;
		this.userValidator = userValidator;
	}
	
	 @RequestMapping("/")
	    public String index() {
	    		return "redirect:/login";
	    }
	
	@RequestMapping(value={"/login","/register"})
	public String login(Model model,@RequestParam(value="error",required=false) String error,@RequestParam(value="logout",required=false) String logout){
		if(error != null){model.addAttribute("errorMessage","Invalid Credentials.");}
		if(logout != null){model.addAttribute("logoutMessage","Logout Successful");}
		
		model.addAttribute("user",new User());
		return "loginandregistration.jsp";
	}
	
	@PostMapping("/register")
	public String register(@Valid @ModelAttribute("user") User user,BindingResult res,Model model){
		userValidator.validate(user,res);
		if(userService.all().size() < 1){ 
		    userService.create(new String[]{"ROLE_USER","ROLE_ADMIN"}, user);
		}else{
		    userService.create(new String[]{"ROLE_USER"}, user);
		}
		return "redirect:/login";
	}

	
	@RequestMapping("/admin")
	public String admin(Principal principal,Model model){		
		model.addAttribute("user",userService.findByUsername(principal.getName()));
		model.addAttribute("users",userService.all());
		return "adminPage.jsp";
	}
	
	@RequestMapping("/admin/delete/{id}")
	public String delete(@PathVariable("id") long id){
		userService.destroy(id);
		return "redirect:/admin";
	}
	
	@RequestMapping("/admin/promote/{id}")
	public String promote(@PathVariable("id") long id){
		User user = userService.getById(id);
		List<Role> userRoles = user.getRoles();
		userRoles.add(roleService.findByName("ROLE_ADMIN"));
		userService.update(user);
		
		return "redirect:/admin";
	}
	
	@RequestMapping("/dashboard")
	public String dashboard(Principal principal,Model model){
		User user = userService.findByUsername(principal.getName());
		System.out.println(user);
		model.addAttribute("user",user);
		user.setUpdatedAt(new Date());
		userService.update(user);
		if(user.isAdmin()){
			return "redirect:/admin";
		}else{
			return "/dashboard";
		}
	}
}