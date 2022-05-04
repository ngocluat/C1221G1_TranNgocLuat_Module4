package com.checkmail.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Controller
public class CheckController {
    private static final String EMAIL_REGEX = "^[A-Za-z0-9]+[A-Za-z0-9]*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)$";
    private static Pattern pattern;
    private Matcher matcher;

    public CheckController() {
        pattern = Pattern.compile(EMAIL_REGEX);
    }

    @GetMapping(value = "/")
    public String home() {
        return "home";
    }

    @PostMapping("/validate")
    public String checkMail(@RequestParam("email") String email, ModelMap model) {
        boolean isValid = this.validate(email);
        if (!isValid) {
            model.addAttribute("message", "Email is invalid !! try late ");
            return "home";
        }
        model.addAttribute("email", email);
        return "home";
    }


    private boolean validate(String regex) {
        matcher = pattern.matcher(regex);
        return matcher.matches();
    }
}
