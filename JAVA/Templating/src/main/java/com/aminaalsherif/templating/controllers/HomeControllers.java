package com.aminaalsherif.templating.controllers;

import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;

@Controller
public class HomeControllers {
        @RequestMapping("/")
        public String index() {
                return "index.jsp";
        }
        
        @RequestMapping("/date")
        public String dates() {
                return "date.jsp";
        }
        
        @RequestMapping("/time")
        public String times() {
                return "time.jsp";
        }
}


