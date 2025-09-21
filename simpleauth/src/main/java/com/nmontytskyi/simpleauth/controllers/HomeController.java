package com.nmontytskyi.simpleauth.controllers;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HomeController {

    @GetMapping("/main")
    @ResponseBody
    public String mainPage(){
        return "main";
    }

    @GetMapping("/admin")
    @PreAuthorize("hasRole('ADMIN')")
    @ResponseBody
    public String adminPage(){
        return "admin";
    }
}
