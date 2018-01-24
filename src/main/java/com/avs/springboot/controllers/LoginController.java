package com.avs.springboot.controllers;

import com.avs.springboot.services.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

@Controller
@SessionAttributes("name")
public class LoginController {


    @Autowired
    LoginService loginService;



//    @GetMapping("/login")
//    public String loginMessage(ModelMap model, @RequestParam String name ){
//
//      model.put("name", name);
//        return "login";
//    }

    @GetMapping("/login")
    public String showLogin(ModelMap model) {
        return "login";
    }

    @PostMapping("/login")
    public String loginMessage(ModelMap model, @RequestParam String name, @RequestParam String password) {
        boolean isValidUser = loginService.validateUser(name, password);

        if (!isValidUser) {
            model.addAttribute("errorMessage", "invalide user");
            return "login";
        }
        model.addAttribute("name", name);
        model.addAttribute("password", password);
        return "welcome";
    }


}


