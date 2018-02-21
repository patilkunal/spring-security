package com.inovisionsoftware.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SpringSecurityHelloWorldControllerDatabase {
	  @RequestMapping("/public/pages")
    public String helloWorld(Model model) {
        model.addAttribute("message", "Hi   user, welcome to Public Hello World page");
 
        return "/helloWorld";
    }
     
    @RequestMapping("/secured/pages")
    public String helloWorldSecured(Model model) {
        model.addAttribute("message", "Hi user,  Great !! , welcome to Secured Hello World page");
        return "/secured/securedHelloWorld";
    }
	

}
