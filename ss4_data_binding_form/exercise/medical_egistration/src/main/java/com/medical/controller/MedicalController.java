package com.medical.controller;

import com.medical.model.Medical;
import com.medical.service.IService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MedicalController {
    @Autowired
    IService iService;

    @GetMapping({"/", "/home-page"})
    public String goHome(@ModelAttribute Medical medical, Model model) {
        model.addAttribute("list", new Medical());
        return "create";
    }


    @PostMapping("/createinformation")
    public String createInformationMedical(Medical medical, Model model) {
        iService.addInformationMedical(medical);
        return "redirect:/";
    }

    @GetMapping("/inforMedical")
    public String showCreate(Medical medical, Model model) {
        model.addAttribute("inforMedical", iService.medicalList());
        return "infor";
    }
}
