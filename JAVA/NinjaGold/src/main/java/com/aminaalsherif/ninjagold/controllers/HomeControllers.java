package com.aminaalsherif.ninjagold.controllers;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.concurrent.ThreadLocalRandom;

import java.lang.Math.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes(value= {"your_gold", "allactivities"})

public class HomeControllers {
	@ModelAttribute("your_gold")
	public int getGold() {
		return 0;
	}
	
	@ModelAttribute("allactivities")
	public ArrayList<String> getActivities() {
		return new ArrayList<String>();
	}

    @RequestMapping("/")
    public String index() {	
        	return "index.jsp";
    }
    
    @RequestMapping(path="/process_money", method= RequestMethod.POST)
    
    public String result(Model model, @RequestParam(value="building") String cave, @ModelAttribute("your_gold") int your_gold, @ModelAttribute("allactivities") ArrayList<String> allactivities, @ModelAttribute("activity_color") String activity_color, HttpSession session, HttpServletRequest request, HttpServletResponse response) {
    		
    		if(request.getParameter("building").equals("farm")) {
    			int farm_money = ThreadLocalRandom.current().nextInt(10, 21);
    			String timeStamp = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(Calendar.getInstance().getTime());
    			your_gold += farm_money;
    			String activity = "You have entered a farm and earned" + " "+ farm_money + " "+ "gold. (" + timeStamp + ")";
    			allactivities.add(activity);
    			request.getSession().setAttribute("allactivites", allactivities);
    			model.addAttribute("activity_color", "green");
    		}
    		
    		else if(request.getParameter("building").equals("cave")) {
    			int cave_money = ThreadLocalRandom.current().nextInt(5, 11);
    			String timeStamp = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(Calendar.getInstance().getTime());
    			your_gold += cave_money;
    			String activity = "You have entered a cave and earned" + " "+ cave_money + " " + "gold. (" + timeStamp + ")";
    			allactivities.add(activity);
    			request.getSession().setAttribute("allactivites", allactivities);
    			model.addAttribute("activity_color", "green");
    		}
    		
    		else if(request.getParameter("building").equals("house")) {
    			int house_money = ThreadLocalRandom.current().nextInt(5, 11);
    			activity_color = "green";
    			String timeStamp = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(Calendar.getInstance().getTime());
    			your_gold += house_money;
    			String activity = "You have entered a house and earned" + " "+ house_money + " "+"gold. (" + timeStamp + ")";
    			allactivities.add(activity);
    			request.getSession().setAttribute("allactivites", allactivities);
    			model.addAttribute("activity_color", "green");
    			
    		}
    		
    		else if(request.getParameter("building").equals("casino")) {
    			
    			int casino_money = ThreadLocalRandom.current().nextInt(-50, 51);
    			String timeStamp = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(Calendar.getInstance().getTime());
    			your_gold += casino_money;
    			
    			if(casino_money < 0) {
    				String activity = "You have entered a casino and lost" + " "+  Math.abs(casino_money) + " "+ "gold...Ouch (" + timeStamp + ")";
        			allactivities.add(activity);
        			request.getSession().setAttribute("allactivites", allactivities);
        			model.addAttribute("activity_color", "red");

    			}else {
    				String activity = "You have entered a cave and earned" + " "+ casino_money + " "+ "gold. (" + timeStamp + ")";
        			allactivities.add(activity);
        			request.getSession().setAttribute("allactivites", allactivities);
        			model.addAttribute("activity_color", "green");
    			}
    		}
    		model.addAttribute("your_gold", your_gold);
    		model.addAttribute("allactivities", allactivities);
    		model.addAttribute("activity_color", activity_color);
    		
    		return "redirect:/";
    }
    
}