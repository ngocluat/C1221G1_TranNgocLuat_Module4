package com.chuyendoi.controller;

import com.chuyendoi.service.IChuyenDoi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ChuyenDoiController {
    @Autowired
    IChuyenDoi iChuyenDoi;



    @GetMapping({"/home", "/"})
    public String getString() {
        return "homeChuyenDoi";
    }


    @GetMapping(value = "/chuyenDoi")
    public String chuyenDoi(@RequestParam Double VND, Model model) {
        model.addAttribute("ketqua", iChuyenDoi.tienTe(VND));
        return "result";
    }

}
