package com.boxmail.controller;

import com.boxmail.model.Mail;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class BoxmailController {




    @GetMapping({"/", "/aaa"})
    public String goEdit(Model model) {
        model.addAttribute("mail", new Mail());
        return "setting";
    }

    @PostMapping("/edit")
    public String updateMail(@ModelAttribute Mail mail, Model model, RedirectAttributes redirectAttributes) {

       if (mail.getSpamsFillter()== null){
           mail.setSpamsFillter("no spams ");
       }
       if (mail.getSignature().equals("")){
           mail.setSignature("user not character name");
       }
        model.addAttribute("mail1", mail);
        return "setting";
    }

}
