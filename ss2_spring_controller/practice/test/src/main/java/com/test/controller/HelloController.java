package com.test.controller;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloController {
    @GetMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE)
    public String write(Model model) {
        model.addAttribute("a", "con ẸN  mày ");
        return "home";
    }
    @GetMapping("/hello/a*")
    public String write2(Model model) {
        model.addAttribute("b", "con ẸN  mày ");
        return "home";
    }
}
