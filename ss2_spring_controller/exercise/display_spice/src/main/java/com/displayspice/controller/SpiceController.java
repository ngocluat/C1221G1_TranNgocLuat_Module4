package com.displayspice.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;


@Controller
public class SpiceController {

    @GetMapping("/")
    public String getHome() {
        return "home";
    }

    @GetMapping("/spice")
    public String save(@RequestParam(value = "condiment") Optional<String[]> condiment, Model model) {
        if (condiment.isPresent()) {
            model.addAttribute("spice", condiment);
        } else {
            model.addAttribute("spice", "không có gì ");
        }
        return "/spice";

    }
}
