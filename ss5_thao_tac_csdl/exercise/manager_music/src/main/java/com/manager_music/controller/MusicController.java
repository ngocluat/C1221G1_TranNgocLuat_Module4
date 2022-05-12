package com.manager_music.controller;

import com.manager_music.model.Music;
import com.manager_music.service.IMusicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class MusicController {
    @Autowired
    private IMusicService iMusicService;

    @GetMapping({"/", "/music"})
    public String getHome(Model model) {
        model.addAttribute("music", iMusicService.findAll());
        return "home";
    }

    @GetMapping("/show-create")
    public String showCreate(Model model) {
        model.addAttribute("music", new Music());
        return "create";
    }

    @PostMapping("/create")
    public String creare(Music music, Model model) {

        iMusicService.save(music);
        model.addAttribute("msg", "successfully add new");
        return "create";
    }

    @GetMapping("/{id}/delete")
    public String delete1(@PathVariable Long id, Model model, Music music) {
        Music music1 = iMusicService.findOne(id);
        iMusicService.delete(music1);
        return "redirect:/";
    }

    @PostMapping("/delete")
    public String delete2(@RequestParam Long id, Model model, Music music) {
        Music music1 = iMusicService.findOne(id);
        iMusicService.delete(music1);
        return "redirect:/music";
    }


    @GetMapping("/{id}/edit")
    public String showEdit(@PathVariable Long id, Model model) {
        model.addAttribute("music", iMusicService.findOne(id));
        return "/edit";
    }


    @PostMapping("/update")
    public String edit(@ModelAttribute Music music , Model model  , RedirectAttributes redirectAttributes){
        this.iMusicService.update(music);
        redirectAttributes.addFlashAttribute("update", "successfully update new");
        return "redirect:/";
    }
}

