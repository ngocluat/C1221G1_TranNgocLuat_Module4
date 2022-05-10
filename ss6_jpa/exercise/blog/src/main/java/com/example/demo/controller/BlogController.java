package com.example.demo.controller;

import com.example.demo.model.Blog;
import com.example.demo.service.IBlogService;
import com.example.demo.service.IPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class BlogController {

    @Autowired
    IBlogService iBlogService;


    @Qualifier("postService")
    @Autowired
    IPostService iPostService;

    @GetMapping({"/", "blog"})
    public String goHome(Model model) {
        model.addAttribute("blog", iBlogService.listBlog());
        return "home";
    }

    @GetMapping("/showCreate")
    public String showCreate(Model model) {
        model.addAttribute("post", iPostService.findAll());
        model.addAttribute("blogCreate", new Blog());
        return "create";
    }


    @PostMapping("/create")
    public String createBlog(Blog blog, Model model) {
        iBlogService.save(blog);
        model.addAttribute("msg", "successfully add new");
        return "redirect:/showCreate";
    }
    @GetMapping("/{id}/edit")
    public String showEdit(@PathVariable Long id, Model model) {
        model.addAttribute("postEdit", iPostService.findAll());
        model.addAttribute("blog", iBlogService.findById(id));
        return "/edit";
    }


    @PostMapping("/update")
    public String edit(@ModelAttribute Blog blog , Model model  , RedirectAttributes redirectAttributes){
        this.iBlogService.update(blog);
        redirectAttributes.addFlashAttribute("update", "successfully update new");
        return "redirect:/blog";
  }


    @GetMapping("/{id}/delete")
    public String delete1(@PathVariable Long id, Model model, Blog blog) {
        Blog blog1 = iBlogService.findById(id);
        iBlogService.delete(blog1);
        return "redirect:/";
    }

    @PostMapping("/delete")
    public String delete2(@RequestParam Long id, Model model, Blog blog) {
        Blog music1 = iBlogService.findById(id);
        iBlogService.delete(music1);
        return "redirect:/";
    }



}
