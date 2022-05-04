package com.caculator.controller;

import com.caculator.service.ICalculate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CaculatorController {

    @Autowired
    ICalculate iCalculate;


    @GetMapping("/")
    public String getHome() {
        return "home";
    }


    @PostMapping("/calculationResults")
    public String ketqua(@RequestParam Double number1, @RequestParam Double number2,
                         @RequestParam String pheptinh,
                         Model model) {
        if (number1 == null || number2 == null) {
            model.addAttribute("answer", "input drum");
        } else {
            model.addAttribute("answer", iCalculate.pheptinh1(number1, number2, pheptinh));

        }
        return "home";
    }


}
