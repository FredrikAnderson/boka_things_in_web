package com.anderson.automation.webboka;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

@Controller
public class CompanyController {

    @GetMapping("/company")
    public String greeting(@Valid @ModelAttribute("company")Company company, BindingResult result, ModelMap model) {
        model.addAttribute("name", company.getName());
        model.addAttribute("email", company.getEmail());
        model.addAttribute("mobile", company.getMobile());
        return "company";
    }

}
