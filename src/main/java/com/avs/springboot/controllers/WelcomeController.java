package com.avs.springboot.controllers;

import com.avs.springboot.services.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@Controller
public class WelcomeController {


    @Autowired
    LoginService service;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String showLoginPage(ModelMap model) {
        model.put("name", getLoggedInUserName());
        return "welcome";
    }

    private String getLoggedInUserName() {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        if (principal instanceof UserDetails) {
            return ((UserDetails) principal).getUsername();
        }
        return principal.toString();
    }

}


