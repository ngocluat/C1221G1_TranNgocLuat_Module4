package com.music.controller;


import com.music.dto.MusicDto;
import com.music.model.Music;
import com.music.service.IMusicService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
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
        model.addAttribute("musicDto", new MusicDto());
        return "create";
    }

    @PostMapping("/create")
    public String creare(@ModelAttribute @Validated MusicDto musicDto,
                         BindingResult bindingResult ,Model model) {

        if (bindingResult.hasFieldErrors()){
            return "create";
        }else {
            Music music1 = new Music();

            BeanUtils.copyProperties(musicDto, music1);
            iMusicService.save(music1);
            model.addAttribute("msg", "successfully add new");
            return "create";
        }
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
    public String edit(@ModelAttribute Music music, Model model, RedirectAttributes redirectAttributes) {
        this.iMusicService.update(music);
        redirectAttributes.addFlashAttribute("update", "successfully update new");
        return "redirect:/";
    }
}

