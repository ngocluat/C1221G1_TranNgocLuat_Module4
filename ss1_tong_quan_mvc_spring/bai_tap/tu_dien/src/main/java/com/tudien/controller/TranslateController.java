package com.tudien.controller;

import com.tudien.service.ITranslate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class TranslateController {
    @Autowired
    ITranslate iTranslate;

    @GetMapping("/")
    public String getString() {
        return "home";
    }

    @GetMapping("/chuyenDoi")
    public String translate(@RequestParam String english, Model model) {
        if ( iTranslate.StringTranslate(english)!= null){
            model.addAttribute("result",
                    iTranslate.StringTranslate(english));
        }else {
            model.addAttribute("result", "Không tìm thấy");
        }
        return "translate";
    }

}
