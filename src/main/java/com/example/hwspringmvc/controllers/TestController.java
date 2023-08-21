package com.example.hwspringmvc.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalDate;

@Controller
public class TestController {
    @RequestMapping(method = RequestMethod.GET, value = "/test")
    public ModelAndView getRandom() {
        ModelAndView result = new ModelAndView("test");
        result.addObject("random", (int) (Math.random() * 100));
        result.addObject("day", LocalDate.now());
        return result;
    }
}
