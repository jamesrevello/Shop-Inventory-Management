package com.example.demo.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AboutController {
    @Autowired
    private ApplicationContext context;
    @RequestMapping(value = {"/about", "/about.html"})
    public String showAboutPage() {
        return "/about";
    }


}
