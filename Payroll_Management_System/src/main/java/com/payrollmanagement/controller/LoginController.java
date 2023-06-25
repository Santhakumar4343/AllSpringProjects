package com.payrollmanagement.controller;

import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.payrollmanagement.entity.Login;
import com.payrollmanagement.serviceImpl.LoginServiceImpl;

  
@RestController
@RequestMapping("/api")
public class LoginController {
    @Autowired
    private LoginServiceImpl LoginServiceImpl;
    
    private final String LETTERS = "abcdefghijlmnopqrstuvwxyz";
	private final char[] ALPHANUMERIC = (LETTERS + LETTERS.toUpperCase() + "0123456789").toCharArray();
	

        @PostMapping("/register")
        public String registerEmployee(@RequestParam int empId,@RequestParam String personalEmail,@RequestParam String officialEmail,@ModelAttribute("employee") Login employee,Integer length) {
        	//employee.setId(id);
        	employee.setEmpId(empId);
        	employee.setPersonalEmail(personalEmail);
        	employee.setOfficialEmail(officialEmail);
        	
        	StringBuilder result = new StringBuilder();

    		for (int i = 0; i < ALPHANUMERIC.length; i++) {
    			
    			while(result.length()<6) {
    			result.append(ALPHANUMERIC[new Random().nextInt(ALPHANUMERIC.length)]);
    			}
    			
    		}
    		String s = result.toString();
    		employee.setOfficialMailPassword(s);    		
    		LoginServiceImpl.registerEmployee(employee);
            return "redirect:details stored"; // assuming "login" is the name of the login form HTML template
        }
   			
	/*	    // Employee Login Form	
		    @GetMapping("/login")	
		    public String showLoginForm() {	
		        return "login";	
		    }	
		*/	
		    // Employee Login	
		    @PostMapping("/login")	
		    public String login(@RequestParam("officialEmail") String officialEmail,	
		                        @RequestParam("password") String password,	
		                        Model model) {	
		        boolean authenticated = LoginServiceImpl.login(officialEmail, password);	
		        if (authenticated) {	
		            return "home"; // Redirect to home page on successful login	
		        } else {	
		            model.addAttribute("error", "Invalid email or password");	
		            return "login"; // Return to login page with error message	
		        }	
		    }	
		       			  
		    // Change Password	
		    @PostMapping("/changepassword")	
		    public String changePassword(@RequestParam("officialEmail") String officialEmail,	
		                                 @RequestParam("oldPassword") String oldPassword,	
		                                 @RequestParam("newPassword") String newPassword,	
		                                 Model model) {	
		        boolean passwordChanged = LoginServiceImpl.changePassword(officialEmail, oldPassword, newPassword);	
		        if (passwordChanged) {	
		            model.addAttribute("message", "Password changed successfully");	
		            return "home"; // Redirect to home page on successful password change	
		        } else {	
		            model.addAttribute("error", "Invalid email or old password");	
		            return "changepassword"; // Return to change password page with error message	
		        }	
		    }
		    
		    
		    
		    
		    @GetMapping("/login")
			public List<Login> getAlllogins() {
				return LoginServiceImpl.getLogins();
			}

		    
		}	
		
	
		
		
		
		
		




