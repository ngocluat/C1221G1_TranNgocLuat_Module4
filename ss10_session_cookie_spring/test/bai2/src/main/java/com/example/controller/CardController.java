package com.example.controller;

import com.example.model.Product;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.SessionAttribute;

@Controller
public class CardController {

    public String showCard(@SessionAttribute(name = "pro", required = false) Product product, Model model) {
        model.addAttribute("product", product);
        return "/card";
    }


}
