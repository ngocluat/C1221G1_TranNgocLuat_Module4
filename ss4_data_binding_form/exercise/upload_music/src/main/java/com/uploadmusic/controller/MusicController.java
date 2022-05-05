package com.uploadmusic.controller;

import com.uploadmusic.model.Music;
import com.uploadmusic.service.IUpload;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MusicController {

    @Autowired
    IUpload iUpload;


    @GetMapping({"/", "aa"})
    public String getHome(Model model) {
        model.addAttribute("listMusic", iUpload.findAll());
        return "home";
    }

    @GetMapping("/show-create")
    public String showCreate(@ModelAttribute Music music, Model model) {
        model.addAttribute("createMusic", new Music());
        return "showCreatePage";
    }


    @PostMapping("/create")
    public String create(Music music, Model model) {
        iUpload.save(music);
        return "redirect:/";
    }

}
