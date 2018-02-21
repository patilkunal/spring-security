package com.inovisionsoftware.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.inovisionsoftware.model.Person;

/**
 * 
 * @author kb
 *
 */

@Controller
public class SpringSecurityHelloWorldController {
	
	
	 @RequestMapping("/public/pages")
	    public String helloWorld(@ModelAttribute("person") Person person,BindingResult bindingResult,Model model) {
		 model.addAttribute("message", "Hi user, Great !! , welcome to Secured Hello World page");
	        
	        model.addAttribute("person",new Person());
	 
	        return "/helloWorld";
	    }
	     
	    @RequestMapping("/secured/pages")
	    public String helloWorldSecured(Model model) {
	        model.addAttribute("message", "Hi user, Great !! , welcome to Secured Hello World page");
	 
	        return "/secured/securedHelloWorld";
	    }
	    
	    @RequestMapping(method=RequestMethod.POST,value="/public/ShowUserDetails")
	    public String showUserDetails(@ModelAttribute("person") Person person,BindingResult bindingResult,Model model) {
	    	System.out.println("name passed from request is "+person.getName());
	    	System.out.println("age passed from request is "+person.getAge());
	    	model.addAttribute("name","kbc");
	        model.addAttribute("age", 30);
	       return "personDetails";
	    }

}
