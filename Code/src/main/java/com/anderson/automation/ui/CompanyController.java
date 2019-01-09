package com.anderson.automation.ui;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.anderson.automation.webboka.service.UserService;

@Controller
public class CompanyController {

    @Autowired
    private UserService userService;

    @Autowired
    private UserDetailsService userDetailsService;

    
    @GetMapping("/company")
    public String company(Model model) {
    	Company company = new Company();
    	company.setName("Fredrik");
    	company.setEmail("fa@gmail.com");

    	model.addAttribute(company);
    	
//        model.addAttribute("name", company.getName());
////        model.addAttribute("email", company.getEmail());
//        model.addAttribute("mobile", company.getMobile());
    	
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();

		String userName = (String) auth.getPrincipal();
		UserDetails user = userDetailsService.loadUserByUsername(userName);
		model.addAttribute("userinfo",
				"Welcome " + user.getUsername() + " (" + user.getAuthorities() + ")");
    	
        return "company";
    }

}
