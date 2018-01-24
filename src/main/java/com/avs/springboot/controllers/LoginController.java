package com.avs.springboot.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

@Controller
public class LoginController {

    @GetMapping("/login")
    public String loginMessage(ModelMap model, @RequestParam String name ){

      model.put("name", name);
        return "login";
    }
}


