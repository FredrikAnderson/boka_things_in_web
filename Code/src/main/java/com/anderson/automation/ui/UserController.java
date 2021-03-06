package com.anderson.automation.ui;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.anderson.automation.security.SecurityService;
import com.anderson.automation.webboka.model.LocalUser;
import com.anderson.automation.webboka.service.UserService;


@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private UserDetailsService userDetailsService;
	
    @Autowired
    private SecurityService securityService;

//    @Autowired
//    private UserValidator userValidator;

    @RequestMapping(value={"/", "/login"}, method = RequestMethod.GET)
    public String login(Model model) {
//        ModelAndView modelAndView = new ModelAndView();
//        modelAndView.setViewName("login");
//        return modelAndView;

        model.addAttribute("userForm", new LocalUser());

        return "login";

    }

//    @RequestMapping(value = "/login", method = RequestMethod.POST)
//    public String login(@ModelAttribute("userForm") LocalUser userForm, BindingResult bindingResult, Model model) {
////        userValidator.validate(userForm, bindingResult);
//
//        if (bindingResult.hasErrors()) {
//            return "login";
//        }
//
//        securityService.autologin(userForm.getUserName(), userForm.getPassword());
//
//        return "redirect:/hello";
//    }
//    

    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    public String registration(Model model) {
        model.addAttribute("userForm", new LocalUser());

        return "registration";
    }

    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public String registration(@ModelAttribute("userForm") LocalUser userForm, BindingResult bindingResult, Model model) {
//        userValidator.validate(userForm, bindingResult);

        if (bindingResult.hasErrors()) {
            return "registration";
        }

        userService.addUser(userForm);

        securityService.autologin(userForm.getUsername(), userForm.getPassword());

        return "redirect:/hello";
    }

	@RequestMapping(value = "/hello", method = RequestMethod.GET)
	public ModelAndView hello() {
		ModelAndView modelAndView = new ModelAndView();
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String userName = (String) auth.getPrincipal();
		UserDetails user = userDetailsService.loadUserByUsername(userName);
		modelAndView.addObject("userName",
				"Welcome " + user.getUsername() + " (" + user.getAuthorities() + ")");
//		modelAndView.addObject("adminMessage", "Content Available Only for Users with Admin Role");
		modelAndView.setViewName("hello");
		return modelAndView;
	}


//    @RequestMapping(value="/registration", method = RequestMethod.GET)
//    public ModelAndView registration(){
//        ModelAndView modelAndView = new ModelAndView();
//        User user = new User();
//        modelAndView.addObject("user", user);
//        modelAndView.setViewName("registration");
//        return modelAndView;
//    }
//
//    @RequestMapping(value = "/registration", method = RequestMethod.POST)
//    public ModelAndView createNewUser(@Valid User user, BindingResult bindingResult) {
//        ModelAndView modelAndView = new ModelAndView();
//        User userExists = userService.findUserByEmail(user.getEmail());
//        if (userExists != null) {
//            bindingResult
//                    .rejectValue("email", "error.user",
//                            "There is already a user registered with the email provided");
//        }
//        if (bindingResult.hasErrors()) {
//            modelAndView.setViewName("registration");
//        } else {
//            userService.saveUser(user);
//            modelAndView.addObject("successMessage", "User has been registered successfully");
//            modelAndView.addObject("user", new User());
//            modelAndView.setViewName("registration");
//
//        }
//        return modelAndView;
//    }
//
//    @RequestMapping(value="/admin/home", method = RequestMethod.GET)
//    public ModelAndView home(){
//        ModelAndView modelAndView = new ModelAndView();
//        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
//        User user = userService.findUserByEmail(auth.getName());
//        modelAndView.addObject("userName", "Welcome " + user.getName() + " " + user.getLastName() + " (" + user.getEmail() + ")");
//        modelAndView.addObject("adminMessage","Content Available Only for Users with Admin Role");
//        modelAndView.setViewName("admin/home");
//        return modelAndView;
//    }


}
