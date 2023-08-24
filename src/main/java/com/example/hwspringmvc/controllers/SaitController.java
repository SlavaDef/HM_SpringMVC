package com.example.hwspringmvc.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
@Controller
public class SaitController {

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute( "title", " this is main header!");
        return "home";
    }

    @GetMapping("/about")
    public String about(Model model) {
        model.addAttribute( "title", "Note says a lot about you!");
        return "about";
    }
}
